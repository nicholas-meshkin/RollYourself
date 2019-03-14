package rollYourself.RollYourself;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.dao.DndCharacterDao;
import rollYourself.RollYourself.dao.QuestionResponsesDao;
import rollYourself.RollYourself.dao.SpellsDao;
import rollYourself.RollYourself.model.AbilityScore;
import rollYourself.RollYourself.model.AbilityScoreList;
import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.Equipment;
import rollYourself.RollYourself.model.PropertyItem;
import rollYourself.RollYourself.model.QuestionResponses;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.Skill;
import rollYourself.RollYourself.model.SkillItem;
import rollYourself.RollYourself.model.Spell;
import rollYourself.RollYourself.model.SpellInfo;
import rollYourself.RollYourself.model.Spellcasting;
import rollYourself.RollYourself.model.SubraceDetail;

@Controller
public class RollYourselfController {
	@Autowired 
	private ApiService apiService;
	
	@Autowired
	StatRoller statRoller;
	
	@Autowired
	StatSetter statSetter;
	
	@Autowired
	SkillSetter skillSetter;

	@Autowired
	QuestionResponsesDao questionResponsesDao;
	
	@Autowired
	DndCharacterDao dndCharacterDao;
	
	@Autowired
	DecisionTree decisionTree;
	
	@Autowired
	SpellsDao spellsDao;
	
	@Autowired
	Names names;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		
		List<ClassListItem> classList = apiService.getClassList();
		mav.addObject("classList", classList);
//		decisionTree.spellsDB(); TODO change this to if statement that checks for empty table
		return mav;
		
	}
	
	@RequestMapping("/questionnaire")
	public ModelAndView questionnaire() {
		
		return new ModelAndView("questionnaire-page-1");
	}
	
	@RequestMapping("/questionnaire-page-2")
	public ModelAndView page2(@RequestParam ("q1Response") Integer q1Response,
							@RequestParam ("q2Response") Integer q2Response,
							@RequestParam ("q3Response") Integer q3Response,
							@RequestParam ("q4Response") Integer q4Response) {
		
		DndCharacter dndCharacter = new DndCharacter();
		//set responses
		dndCharacter.setQ1Response(q1Response);
		dndCharacter.setQ2Response(q2Response);
		dndCharacter.setQ3Response(q3Response);
		dndCharacter.setQ4Response(q4Response);
		Integer classSelection = decisionTree.selectClass(dndCharacter);
		String page2 = decisionTree.selectPage2(classSelection);
		ModelAndView mav = new ModelAndView(page2);
		mav.addObject("dndCharacter", dndCharacter);
		return mav;
	}
	
	@RequestMapping("/questionnaire-page-3")
	public ModelAndView page3(@RequestParam ("q1Response") Integer q1Response,
							@RequestParam ("q2Response") Integer q2Response,
							@RequestParam ("q3Response") Integer q3Response,
							@RequestParam ("q4Response") Integer q4Response,
							@RequestParam ("q5Response") Integer q5Response,
							@RequestParam ("q6Response") Integer q6Response) {
		
		DndCharacter dndCharacter = new DndCharacter();
		//set responses
		dndCharacter.setQ1Response(q1Response);
		dndCharacter.setQ2Response(q2Response);
		dndCharacter.setQ3Response(q3Response);
		dndCharacter.setQ4Response(q4Response);
		dndCharacter.setQ5Response(q5Response);
		dndCharacter.setQ6Response(q6Response);
	
		ModelAndView mav = new ModelAndView("questionnaire-page-3");
		mav.addObject("dndCharacter", dndCharacter);
		return mav;
	}
	
	@RequestMapping("/submitResponses")
	public ModelAndView submitResponses(QuestionResponses QuestionResponse) {
		//create dndchar object
		DndCharacter dndCharacter = new DndCharacter();
		
		//set responses
		dndCharacter.setQ1Response( QuestionResponse.getQ1Response() );
		dndCharacter.setQ2Response( QuestionResponse.getQ2Response() );
		dndCharacter.setQ3Response( QuestionResponse.getQ3Response() );
		dndCharacter.setQ4Response( QuestionResponse.getQ4Response() );
		dndCharacter.setQ5Response( QuestionResponse.getQ5Response() );
		dndCharacter.setQ6Response( QuestionResponse.getQ6Response() );
		dndCharacter.setQ7Response( QuestionResponse.getQ7Response() );
		dndCharacter.setQ8Response( QuestionResponse.getQ8Response() );
		
		//determine class from responses
		Integer raceSelection = decisionTree.selectRace(dndCharacter);
		Integer classSelection = decisionTree.selectClass(dndCharacter);
		
		
		ClassDetail classDetail = apiService.getClassDetail(classSelection);		
		RaceDetail raceDetail = apiService.getRaceDetail(raceSelection);
//		SubraceDetail subraceDetail = apiService.getSubraceDetail(/*TODO add param*/);
		
		
		

		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
//		dndCharacter.setSubraceDetail(subraceDetail);
		dndCharacter.setClassDetail(classDetail);


		//call method that rolls stats and assigns them / set stat values on character
		statSetter.setStats(dndCharacter);
		
		// method that selects name from name bank according to character's race
		dndCharacter.setName(names.selectName(dndCharacter));
		
		
		//create character row in the dao
		dndCharacterDao.create(dndCharacter);
	
		Long id = dndCharacter.getId();
		ModelAndView mav = new ModelAndView("redirect:/displayCharacter");
		mav.addObject("id", id);
		return mav;
	}
	
	
	@RequestMapping("/displayCharacter")
	public ModelAndView characterCreate(@RequestParam("id") Long id) {
		DndCharacter dndCharacter = dndCharacterDao.findById(id);
		
		Integer raceSelection = decisionTree.selectRace(dndCharacter);
		Integer classSelection = decisionTree.selectClass(dndCharacter);
		
		ClassDetail classDetail = apiService.getClassDetail(classSelection);		
		RaceDetail raceDetail = apiService.getRaceDetail(raceSelection);
		
		AbilityScore abilityScore1 = apiService.abilityScoreDetail(1);
		AbilityScore abilityScore2 = apiService.abilityScoreDetail(2);
		AbilityScore abilityScore3 = apiService.abilityScoreDetail(3);
		AbilityScore abilityScore4 = apiService.abilityScoreDetail(4);
		AbilityScore abilityScore5 = apiService.abilityScoreDetail(5);
		AbilityScore abilityScore6 = apiService.abilityScoreDetail(6);
		
		Skill skill1 = apiService.getSkill(1);
		Skill skill2 = apiService.getSkill(2);
		Skill skill3 = apiService.getSkill(3);
		Skill skill4 = apiService.getSkill(4);
		Skill skill5 = apiService.getSkill(5);
		Skill skill6 = apiService.getSkill(6);
		Skill skill7 = apiService.getSkill(7);
		Skill skill8 = apiService.getSkill(8);
		Skill skill9 = apiService.getSkill(9);
		Skill skill10 = apiService.getSkill(10);
		Skill skill11 = apiService.getSkill(11);
		Skill skill12 = apiService.getSkill(12);
		Skill skill13 = apiService.getSkill(13);
		Skill skill14 = apiService.getSkill(14);
		Skill skill15 = apiService.getSkill(15);
		Skill skill16 = apiService.getSkill(16);
		Skill skill17 = apiService.getSkill(17);
		Skill skill18 = apiService.getSkill(18);
		
		SubraceDetail subraceDetail = apiService.getSubraceDetail(/*TODO add param*/);
		
		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
		dndCharacter.setSubraceDetail(subraceDetail);
		dndCharacter.setClassDetail(classDetail);

		statSetter.raceStatAdjust(dndCharacter);
		//statSetter.subraceStatAdjust(dndCharacter);
		
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("character", dndCharacter);
		
		mav.addObject("classDetail", classDetail);	
		mav.addObject("raceDetail", raceDetail);
		
		mav.addObject("abilityScore1", abilityScore1);
		mav.addObject("abilityScore2", abilityScore2);
		mav.addObject("abilityScore3", abilityScore3);
		mav.addObject("abilityScore4", abilityScore4);
		mav.addObject("abilityScore5", abilityScore5);
		mav.addObject("abilityScore6", abilityScore6);
		
		mav.addObject("skill1", skill1);
		mav.addObject("skill2", skill2);
		mav.addObject("skill3", skill3);
		mav.addObject("skill4", skill4);
		mav.addObject("skill5", skill5);
		mav.addObject("skill6", skill6);
		mav.addObject("skill7", skill7);
		mav.addObject("skill8", skill8);
		mav.addObject("skill9", skill9);
		mav.addObject("skill10", skill10);
		mav.addObject("skill11", skill11);
		mav.addObject("skill12", skill12);
		mav.addObject("skill13", skill13);
		mav.addObject("skill14", skill14);
		mav.addObject("skill15", skill15);
		mav.addObject("skill16", skill16);
		mav.addObject("skill17", skill17);
		mav.addObject("skill18", skill18);
		
		List<Integer> savingThrows = statSetter.calculateSavingThrows(dndCharacter);
		mav.addObject("savingThrows",savingThrows);
				
		List<Integer> abilityBonuses = statSetter.calculateAbilityBonuses(dndCharacter);
		mav.addObject("abilityBonuses",abilityBonuses);
		
		List<Integer> skills = skillSetter.setSkills(dndCharacter);
		mav.addObject("skills",skills);
		
		Integer maxHp = statSetter.calculateBonus(dndCharacter.getConstitution())+dndCharacter.getClassDetail().getHitDie();
		mav.addObject("maxHp",maxHp);
		
		String alignment = decisionTree.selectAlignment(dndCharacter);
		mav.addObject("alignment", alignment);
		Integer passivePerception = statSetter.calculateBonus(dndCharacter.getWisdom())+10;
		mav.addObject("passivePerception", passivePerception);
		
		List<Equipment> weaponList = decisionTree.selectWeapons(classSelection);
		weaponList = decisionTree.setWeaponStats(weaponList, dndCharacter);
		mav.addObject("weaponList", weaponList);
		
		
		List<Equipment> armorList = decisionTree.selectArmor(classSelection);
		Integer aC = decisionTree.calculateAC(classSelection, dndCharacter, armorList);
		mav.addObject("armorList", armorList);
		mav.addObject("aC",aC);
		
		List<Equipment> otherEquipmentList = decisionTree.selectOtherEquipment(classSelection);
		mav.addObject("otherEquipmentList", otherEquipmentList);
		
//		if(dndCharacter.getClassDetail().getSpellcasting()!=null) {
		
		//TODO: fix spell thing so it isn't making 300 requests every time page is loaded
			List<Spell> cantrips = decisionTree.chooseCantrips(dndCharacter);
			List<Spell> firstLevelSpells = decisionTree.chooseFirstLevelSpells(dndCharacter);
			SpellInfo spellInfo = decisionTree.getSpellcastingInfo(dndCharacter);
			Spellcasting spellcasting = decisionTree.getSpellcasting(dndCharacter);
			mav.addObject("cantrips", cantrips);
			mav.addObject("firstLevelSpells", firstLevelSpells);
			mav.addObject("spellInfo",spellInfo);
			mav.addObject("spellcasting",spellcasting);
			
//		}
		
		return mav;
	}

	@RequestMapping("/viewCharacterList")
	public ModelAndView characterListPage() {
	ModelAndView mav = new ModelAndView("character-list");
	List<DndCharacter> dndcharacters = dndCharacterDao.findAll();
	mav.addObject("characterlist", dndcharacters);
	return mav;
	}
		
	
	@RequestMapping("/race-details/{index}")
	public ModelAndView raceDetailsPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("race-details-page");
		RaceDetail raceDetail = apiService.getRaceDetail(index);
//		SubraceDetail subraceDetail = apiService.getSubraceDetail(/**/);
		mav.addObject("raceDetail",raceDetail);
//		mav.addObject("subraceDetail",subraceDetail);
		return mav;
	}
	@RequestMapping("language-detail/{index}")
	public ModelAndView languageDedailPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("language-detail");
		RaceDetail raceDetail = apiService.getRaceDetail(index);
		mav.addObject("raceDetail",raceDetail);
		return mav;
	}
	@RequestMapping("/skill-detail/{index}")
	public ModelAndView skillDetailsPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("skill-detail");
		Skill skill = apiService.getSkill(index);
		mav.addObject("skill", skill);
		return mav;
	}
	
	@RequestMapping("/ability-detail/{index}")
	public ModelAndView abilityDetailsPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("ability-score-detail");
		AbilityScore abilityScore = apiService.abilityScoreDetail(index);
		mav.addObject("abilityScore", abilityScore);
		return mav;
	}
	
	@RequestMapping("/spell-detail/{index}")
	public ModelAndView spellDetailPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("spell-detail");
		Spell spell = apiService.getSpellDetail(index);
		mav.addObject("spell",spell);
		return mav;
	}

	//for our use, not a user page
	@RequestMapping("/profChoiceList")
	public ModelAndView profPage(){
		ModelAndView mav = new ModelAndView("prof-page");
		List<ClassDetail> classList = new ArrayList<>();
		for(int i=1;i<13;i++) {
			classList.add(apiService.getClassDetail(i));
		}
		
		mav.addObject("classList", classList);
		return mav;
	}
}
