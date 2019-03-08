package rollYourself.RollYourself;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.model.ClassListItem;

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
		Collections.sort(stats, Collections.reverseOrder()); 
		
		ModelAndView mav = new ModelAndView("character-sheet");
		mav.addObject("stat", stats);
		return mav;
	}

}
