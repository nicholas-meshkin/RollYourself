package rollYourself.RollYourself;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.model.AbilityScore;
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
		List<Integer> stats = statRoller.getStatList();

		ClassDetail classDetail = apiService.getClassDetail(/*TODO add param*/);
		RaceDetail raceDetail = apiService.getRaceDetail(/*TODO add param*/);
		Collections.sort(stats, Collections.reverseOrder()); 
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("classDetail", classDetail);
		mav.addObject("stat", stats);
		mav.addObject("raceDetail", raceDetail);
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
	public ModelAndView abilityDetailsPage(/*TODO add param*/) {
		ModelAndView mav = new ModelAndView("ability-score-detail");
		AbilityScore abilityScore = apiService.abilityScoreDetail();
		mav.addObject("abilityScore", abilityScore);
		return mav;
	}

}
