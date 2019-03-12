package rollYourself.RollYourself;

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
import rollYourself.RollYourself.model.AbilityScore;
import rollYourself.RollYourself.model.AbilityScoreList;
import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.QuestionResponses;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.Skill;
import rollYourself.RollYourself.model.SkillItem;
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
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<ClassListItem> classList = apiService.getClassList();
		mav.addObject("classList", classList);
		return mav;
	}
	
	@RequestMapping("/questionnaire")
	public ModelAndView questionnaire() {
		
		return new ModelAndView("questionnaire-page-1");
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
		
		//determine class from responses
		Integer raceSelection = 0;
	
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 8;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 9;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 9;}
		
		Integer classSelection = 0;
		
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 2;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 3;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 4;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 6;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 7;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 8;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 9;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 11;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 12;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 9;}

		
		ClassDetail classDetail = apiService.getClassDetail(classSelection);		
		RaceDetail raceDetail = apiService.getRaceDetail(raceSelection);
		SubraceDetail subraceDetail = apiService.getSubraceDetail(/*TODO add param*/);
		

		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
		dndCharacter.setSubraceDetail(subraceDetail);
		dndCharacter.setClassDetail(classDetail);


		//call method that rolls stats and assigns them / set stat values on character
		statSetter.setStats(dndCharacter);

		dndCharacter.setName("Creator of Worlds");
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
		
		Integer raceSelection = 0;
		
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 8;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 9;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 9;}
		Integer classSelection = 0;
		
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 2;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 3;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 4;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 6;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 7;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 8;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 9;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 11;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 12;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 9;}

		
		ClassDetail classDetail = apiService.getClassDetail(classSelection);		
		RaceDetail raceDetail = apiService.getRaceDetail(raceSelection);
		SubraceDetail subraceDetail = apiService.getSubraceDetail(/*TODO add param*/);
		

		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		dndCharacter.setRaceDetail(raceDetail);
		dndCharacter.setSubraceDetail(subraceDetail);
		dndCharacter.setClassDetail(classDetail);

		statSetter.raceStatAdjust(dndCharacter);
		statSetter.subraceStatAdjust(dndCharacter);
		
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("character", dndCharacter);
		
		List<Integer> savingThrows = statSetter.calculateSavingThrows(dndCharacter);
		mav.addObject("savingThrows",savingThrows);
				
		List<Integer> skills = skillSetter.setSkills(dndCharacter);
		mav.addObject("skills",skills);
		
		Integer maxHp = statSetter.calculateBonus(dndCharacter.getConstitution())+dndCharacter.getClassDetail().getHitDie();
		mav.addObject("maxHp",maxHp);
		
		Integer passivePerception = statSetter.calculateBonus(dndCharacter.getWisdom())+10;
		mav.addObject("passivePerception", passivePerception);
		
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

}
