package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.dao.DndCharacterDao;
import rollYourself.RollYourself.dao.SpellsDao;
import rollYourself.RollYourself.model.AbScoreJoin;
import rollYourself.RollYourself.model.AbilityScore;
import rollYourself.RollYourself.model.AbilityScoreItem;
import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.Equipment;
import rollYourself.RollYourself.model.QuestionResponses;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.Skill;
import rollYourself.RollYourself.model.Spell;
import rollYourself.RollYourself.model.SpellInfo;
import rollYourself.RollYourself.model.Spellcasting;

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
//		decisionTree.spellsDB();// TODO change this to if statement that checks for empty table
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
		
		
		//select spells
		List<Spell> cantrips = decisionTree.chooseCantrips(dndCharacter);
		String myCantrips="";
		for(int i=0;i<cantrips.size();i++) {
			myCantrips += cantrips.get(i).getIndex()+",";
		}
		List<Spell> firstLevelSpells = decisionTree.chooseFirstLevelSpells(dndCharacter);
		String myFirstLvlSpells="";
		for(int i=0;i<firstLevelSpells.size();i++) {
			myFirstLvlSpells += firstLevelSpells.get(i).getIndex()+",";
		}
		dndCharacter.setCantrips(myCantrips);
		dndCharacter.setFirstLevelSpells(myFirstLvlSpells);
		
		//create character row in the dao
		dndCharacterDao.create(dndCharacter);
	
		Long id = dndCharacter.getId();
//		ModelAndView mav = new ModelAndView("redirect:/displayCharacter");
		
		//go to loading page
		ModelAndView mav = new ModelAndView("testloader");
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
		
		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
		dndCharacter.setClassDetail(classDetail);

		statSetter.raceStatAdjust(dndCharacter);
		
		ModelAndView mav = new ModelAndView("character-sheet");
		
		mav.addObject("character", dndCharacter);
		mav.addObject("classDetail", classDetail);	
		mav.addObject("raceDetail", raceDetail);
		
		
		
		List<Skill> skillList = apiService.getAllSkills();
		List<Integer> skills = skillSetter.setSkills(dndCharacter);
		mav.addObject("skillList", skillList);
		mav.addObject("skills",skills);
		Map<Skill,Integer> skillMaster = new LinkedHashMap<>();
		for(int i=0;i<skillList.size();i++) {
			skillMaster.put(skillList.get(i), skills.get(i));
		}
		mav.addObject("skillMaster", skillMaster);
		
		List<Integer> savingThrows = statSetter.calculateSavingThrows(dndCharacter);
		mav.addObject("savingThrows",savingThrows);
				
		
		List<AbilityScore> abScores = apiService.getAllAbilityScores();
		mav.addObject("abScores", abScores);
		List<Integer> abilityBonuses = statSetter.calculateAbilityBonuses(dndCharacter);
		mav.addObject("abilityBonuses",abilityBonuses);
		List<AbScoreJoin> join = new ArrayList<>();
		
			AbScoreJoin str = new AbScoreJoin(); str.setBonus(abilityBonuses.get(0)); str.setScore(dndCharacter.getStrength());join.add(str);
			AbScoreJoin dex = new AbScoreJoin(); dex.setBonus(abilityBonuses.get(0)); dex.setScore(dndCharacter.getDexterity());join.add(dex);
			AbScoreJoin con = new AbScoreJoin(); con.setBonus(abilityBonuses.get(0)); con.setScore(dndCharacter.getConstitution());join.add(con);
			AbScoreJoin in = new AbScoreJoin(); in.setBonus(abilityBonuses.get(0)); in.setScore(dndCharacter.getIntelligence());join.add(in);
			AbScoreJoin wis = new AbScoreJoin(); wis.setBonus(abilityBonuses.get(0)); wis.setScore(dndCharacter.getWisdom());join.add(wis);
			AbScoreJoin cha = new AbScoreJoin(); cha.setBonus(abilityBonuses.get(0)); cha.setScore(dndCharacter.getCharisma());join.add(cha);
			
		Map<AbilityScore,AbScoreJoin> abMaster = new LinkedHashMap<>();
		for(int i=0;i<abScores.size();i++) {
			abMaster.put(abScores.get(i), join.get(i));
		}
		mav.addObject("abMaster", abMaster);
		
		
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
		
		List<String> profNames = decisionTree.chooseProfs(dndCharacter);
		mav.addObject("profNames", profNames);
		List<Equipment> otherEquipmentList = decisionTree.selectOtherEquipment(classSelection);
		mav.addObject("otherEquipmentList", otherEquipmentList);
		
		if(dndCharacter.getClassDetail().getSpellcasting()!=null 
				&& !dndCharacter.getClassDetail().getSpellcasting().getCharClass().equals("Ranger") 
				&& !dndCharacter.getClassDetail().getSpellcasting().getCharClass().equals("Paladin")) {
		
		List<String>cantString = Arrays.asList(dndCharacter.getCantrips().split((",")));
		List<String>firstString = Arrays.asList(dndCharacter.getFirstLevelSpells().split((",")));
		
		List<Integer> cants = new ArrayList<>();
		List<Integer> firsts = new ArrayList<>();
		
		for (String i : cantString) {cants.add(Integer.valueOf(i));}
		for (String i : firstString) {firsts.add(Integer.valueOf(i));}
		
		List<Spell> cantrips = new ArrayList<>();
		List<Spell> firstLevelSpells = new ArrayList<>();
		for (Integer i : cants) {cantrips.add(apiService.getSpellDetail(i));}
		for (Integer i : firsts) {firstLevelSpells.add(apiService.getSpellDetail(i));}
			SpellInfo spellInfo = decisionTree.getSpellcastingInfo(dndCharacter);
			Spellcasting spellcasting = decisionTree.getSpellcasting(dndCharacter);
			mav.addObject("cantrips", cantrips);
			mav.addObject("firstLevelSpells", firstLevelSpells);
			mav.addObject("spellInfo",spellInfo);
			mav.addObject("spellcasting",spellcasting);
		}
		List<AbilityScoreItem> abList = dndCharacter.getClassDetail().getSavingThrows();
		List<String> stNames = new ArrayList<>();
		for(AbilityScoreItem i : abList) {
			stNames.add(i.getName());
		}
		mav.addObject("stNames",stNames);
		Boolean newChar = false;
		mav.addObject("newChar", newChar);
		return mav;
	}

	@RequestMapping("/viewCharacterList")
	public ModelAndView characterListPage() {
	ModelAndView mav = new ModelAndView("character-list");
	List<DndCharacter> dndcharacters = dndCharacterDao.findAll();
	mav.addObject("characterlist", dndcharacters);
	return mav;
	}
	
	@RequestMapping("/deleteChar")
	public ModelAndView deleteCharacter(@RequestParam("id") Long id) {
		dndCharacterDao.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/viewCharacterList");
		return mav;
	}
		
	
//	@RequestMapping("/race-details/{index}")
//	public ModelAndView raceDetailsPage(@PathVariable("index") Integer index) {
//		ModelAndView mav = new ModelAndView("race-details-page");
//		RaceDetail raceDetail = apiService.getRaceDetail(index);
////		SubraceDetail subraceDetail = apiService.getSubraceDetail(/**/);
//		mav.addObject("raceDetail",raceDetail);
////		mav.addObject("subraceDetail",subraceDetail);
//		return mav;
//	}
	@RequestMapping("language-detail/{index}")
	public ModelAndView languageDedailPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("language-detail");
		RaceDetail raceDetail = apiService.getRaceDetail(index);
		mav.addObject("raceDetail",raceDetail);
		return mav;
	}
//	@RequestMapping("/skill-detail/{index}")
//	public ModelAndView skillDetailsPage(@PathVariable("index") Integer index) {
//		ModelAndView mav = new ModelAndView("skill-detail");
//		Skill skill = apiService.getSkill(index);
//		mav.addObject("skill", skill);
//		return mav;
//	}
	
//	@RequestMapping("/ability-detail/{index}")
//	public ModelAndView abilityDetailsPage(@PathVariable("index") Integer index) {
//		ModelAndView mav = new ModelAndView("ability-score-detail");
//		AbilityScore abilityScore = apiService.abilityScoreDetail(index);
//		mav.addObject("abilityScore", abilityScore);
//		return mav;
//	}
	
	@RequestMapping("/spell-detail/{index}")
	public ModelAndView spellDetailPage(@PathVariable("index") Integer index) {
		ModelAndView mav = new ModelAndView("spell-detail");
		Spell spell = apiService.getSpellDetail(index);
		mav.addObject("spell",spell);
		return mav;
	}

	@RequestMapping("/newCharacter")
	public ModelAndView characterNew(@RequestParam("id") Long id) {
		DndCharacter dndCharacter = dndCharacterDao.findById(id);
		
		Integer raceSelection = decisionTree.selectRace(dndCharacter);
		Integer classSelection = decisionTree.selectClass(dndCharacter);
		
		ClassDetail classDetail = apiService.getClassDetail(classSelection);		
		RaceDetail raceDetail = apiService.getRaceDetail(raceSelection);
		
		
		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
		dndCharacter.setClassDetail(classDetail);

		statSetter.raceStatAdjust(dndCharacter);
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("character", dndCharacter);
		
		mav.addObject("classDetail", classDetail);	
		mav.addObject("raceDetail", raceDetail);
		
		List<Skill> skillList = apiService.getAllSkills();
		List<Integer> skills = skillSetter.setSkills(dndCharacter);
		mav.addObject("skillList", skillList);
		mav.addObject("skills",skills);
		Map<Skill,Integer> skillMaster = new LinkedHashMap<>();
		for(int i=0;i<skillList.size();i++) {
			skillMaster.put(skillList.get(i), skills.get(i));
		}
		mav.addObject("skillMaster", skillMaster);
		
		List<AbilityScore> abScores = apiService.getAllAbilityScores();
		mav.addObject("abScores", abScores);
		List<Integer> abilityBonuses = statSetter.calculateAbilityBonuses(dndCharacter);
		mav.addObject("abilityBonuses",abilityBonuses);
		List<AbScoreJoin> join = new ArrayList<>();
		
			AbScoreJoin str = new AbScoreJoin(); str.setBonus(abilityBonuses.get(0)); str.setScore(dndCharacter.getStrength());join.add(str);
			AbScoreJoin dex = new AbScoreJoin(); dex.setBonus(abilityBonuses.get(0)); dex.setScore(dndCharacter.getDexterity());join.add(dex);
			AbScoreJoin con = new AbScoreJoin(); con.setBonus(abilityBonuses.get(0)); con.setScore(dndCharacter.getConstitution());join.add(con);
			AbScoreJoin in = new AbScoreJoin(); in.setBonus(abilityBonuses.get(0)); in.setScore(dndCharacter.getIntelligence());join.add(in);
			AbScoreJoin wis = new AbScoreJoin(); wis.setBonus(abilityBonuses.get(0)); wis.setScore(dndCharacter.getWisdom());join.add(wis);
			AbScoreJoin cha = new AbScoreJoin(); cha.setBonus(abilityBonuses.get(0)); cha.setScore(dndCharacter.getCharisma());join.add(cha);
			
		Map<AbilityScore,AbScoreJoin> abMaster = new LinkedHashMap<>();
		for(int i=0;i<abScores.size();i++) {
			abMaster.put(abScores.get(i), join.get(i));
		}
		mav.addObject("abMaster", abMaster);		
		
		List<Integer> savingThrows = statSetter.calculateSavingThrows(dndCharacter);
		mav.addObject("savingThrows",savingThrows);
				
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
		
		List<String> profNames = decisionTree.chooseProfs(dndCharacter);
		mav.addObject("profNames", profNames);
		List<Equipment> otherEquipmentList = decisionTree.selectOtherEquipment(classSelection);
		mav.addObject("otherEquipmentList", otherEquipmentList);
		
		List<AbilityScoreItem> abList = dndCharacter.getClassDetail().getSavingThrows();
		List<String> stNames = new ArrayList<>();
		for(AbilityScoreItem i : abList) {
			stNames.add(i.getName());
		}
		mav.addObject("stNames",stNames);
		
		if(dndCharacter.getClassDetail().getSpellcasting()!=null 
				&& !dndCharacter.getClassDetail().getSpellcasting().getCharClass().equals("Ranger") 
				&& !dndCharacter.getClassDetail().getSpellcasting().getCharClass().equals("Paladin")) {
		
		List<String>cantString = Arrays.asList(dndCharacter.getCantrips().split((",")));
		List<String>firstString = Arrays.asList(dndCharacter.getFirstLevelSpells().split((",")));
		
		List<Integer> cants = new ArrayList<>();
		List<Integer> firsts = new ArrayList<>();
		
		for (String i : cantString) {cants.add(Integer.valueOf(i));}
		for (String i : firstString) {firsts.add(Integer.valueOf(i));}
		
		List<Spell> cantrips = new ArrayList<>();
		List<Spell> firstLevelSpells = new ArrayList<>();
		
		for (Integer i : cants) {cantrips.add(apiService.getSpellDetail(i));}
		for (Integer i : firsts) {firstLevelSpells.add(apiService.getSpellDetail(i));}
			SpellInfo spellInfo = decisionTree.getSpellcastingInfo(dndCharacter);
			Spellcasting spellcasting = decisionTree.getSpellcasting(dndCharacter);
			mav.addObject("cantrips", cantrips);
			mav.addObject("firstLevelSpells", firstLevelSpells);
			mav.addObject("spellInfo",spellInfo);
			mav.addObject("spellcasting",spellcasting);
		}
		Boolean newChar = true;
		mav.addObject("newChar", newChar);
		
		return mav;
	}
}
