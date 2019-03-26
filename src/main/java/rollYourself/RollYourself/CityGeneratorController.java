package rollYourself.RollYourself;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.citygenmodel.DefaultSV;
import rollYourself.RollYourself.dao.SVDao;

@Controller
public class CityGeneratorController {
	@Autowired
	SVDao svDao;
	
	@RequestMapping("/buildCharPage")
	public ModelAndView buildCharPage(){
		ModelAndView mav = new ModelAndView("char-builder");
		return mav;
	}
	
	@RequestMapping("/city-generator-index")
	public ModelAndView cityGenHome(){
		ModelAndView mav = new ModelAndView("city-generator-index");
		return mav;
	}
	
	@RequestMapping("/sv-editor")
	public ModelAndView svEditor(){
		ModelAndView mav = new ModelAndView("sv-editor");
		List<DefaultSV> list = svDao.findAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/sv-editor")
	public ModelAndView svSubmit(@RequestParam("title") String title,
								@RequestParam("sv") Integer sv,
								@RequestParam("townType") String townType) {
		DefaultSV newSV = new DefaultSV();
		newSV.setSv(sv);
		newSV.setTitle(title);
		newSV.setTownType(townType);
		svDao.create(newSV);
		ModelAndView mav = new ModelAndView("redirect:/sv-editor");
		return mav;
	}
	
	@RequestMapping("/deleteSV")
	public ModelAndView deleteSV(@RequestParam("id") Long id) {
		svDao.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/sv-editor");
		return mav;
	}
	
	@RequestMapping("/updateSV")
	public ModelAndView updatePage(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("sv-edit-page");
		DefaultSV defaultSV = svDao.findById(id);
		mav.addObject("defaultSV", defaultSV);
		return mav;
	}
	@PostMapping("/updateSV")
	public ModelAndView updateSV(@RequestParam("id") Long id,
								@RequestParam("title") String title,
								@RequestParam("sv") Integer sv,
								@RequestParam("townType") String townType) {
		DefaultSV defaultSV = svDao.findById(id);
		defaultSV.setSv(sv);
		defaultSV.setTitle(title);
		defaultSV.setTownType(townType);
		svDao.update(defaultSV);
		ModelAndView mav = new ModelAndView("redirect:/sv-editor");
		return mav;
	}
}