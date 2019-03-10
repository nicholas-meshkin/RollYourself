package rollYourself.RollYourself;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.model.AbilityScore;
import rollYourself.RollYourself.model.AbilityScoreList;
import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.Skill;
import rollYourself.RollYourself.model.SubraceDetail;

@Controller
public class RollYourselfController {
	@Autowired private ApiService apiService;
	@Autowired
	StatRoller statRoller;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<ClassListItem> classList = apiService.getClassList();
		mav.addObject("classList", classList);
		return mav;
	}
	
	@RequestMapping("/character")
	public ModelAndView characterSheet() {
		DndCharacter dndCharacter = new DndCharacter();
		
		List<Integer> stats = statRoller.getStatList();
		Collections.sort(stats, Collections.reverseOrder());

		ClassDetail classDetail = apiService.getClassDetail(/*TODO add param*/);
		RaceDetail raceDetail = apiService.getRaceDetail(/*TODO add param*/);
		
		dndCharacter.setName("Creator of Worlds");
		dndCharacter.setCharacterClass(classDetail.getName());
		dndCharacter.setRace(raceDetail.getName());
		
		int j = 0;
		for(int i:stats) {
			if(j == 0) {
				dndCharacter.setStrength(i);
			}
			if(j == 1) {
				dndCharacter.setDexterity(i);
			}
			if(j == 2) {
				dndCharacter.setConstitution(i);
			}
			if(j == 3) {
				dndCharacter.setIntelligence(i);
			}
			if(j == 4) {
				dndCharacter.setWisdom(i);
			}
			if(j == 5) {
				dndCharacter.setCharisma(i);
			}
			j++;
		}
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("character", dndCharacter);
		return mav;
	}
	
	@RequestMapping("/race-details")
	public ModelAndView raceDetailsPage(/*TODO add parameter*/) {
		ModelAndView mav = new ModelAndView("race-details-page");
		RaceDetail raceDetail = apiService.getRaceDetail(/*TODO add param*/);
		SubraceDetail subraceDetail = apiService.getSubraceDetail(/**/);
		mav.addObject("raceDetail",raceDetail);
		mav.addObject("subraceDetail",subraceDetail);
		return mav;
	}
	
	@RequestMapping("/skill-detail")
	public ModelAndView skillDetailsPage(/*TODO add param*/) {
		ModelAndView mav = new ModelAndView("skill-detail");
		Skill skill = apiService.getSkill(/*TODO add param*/);
		mav.addObject("skill", skill);
		return mav;
	}
	
	@RequestMapping("/ability-detail")
	public ModelAndView abilityDetailsPage(int index) {
		ModelAndView mav = new ModelAndView("ability-score-detail");
		AbilityScore abilityScore = apiService.abilityScoreDetail(index);
		mav.addObject("abilityScore", abilityScore);
		return mav;
	}

}
