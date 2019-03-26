package rollYourself.RollYourself;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.CityGenerator.Calculator;
import rollYourself.RollYourself.citygenmodel.DefaultSV;
import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.Person;
import rollYourself.RollYourself.citygenmodel.Town;
import rollYourself.RollYourself.dao.SVDao;

@Controller
public class CityGeneratorController {
	@Autowired
	SVDao svDao;
	
	@Autowired
	Calculator calculator;
	
	@RequestMapping("/buildCharPage")
	public ModelAndView buildCharPage(){
		ModelAndView mav = new ModelAndView("char-builder");
		return mav;
	}
	
	@RequestMapping("/city-generator-index")
	public ModelAndView cityGenHome(){
		ModelAndView mav = new ModelAndView("city-generator-index");
		//tester
		Town town = new Town();
		town.setSize(100);
		town.setSvType("ActualCity");
		List<DefaultSV> svList = calculator.jobList(town);
		List<String> jobs = new ArrayList<>();
		for(int i=0;i<svList.size();i++) {
			jobs.add(svList.get(i).getTitle());
		}
		
		System.out.println(jobs);
		
		List<Family> testTown = calculator.createTown(100);
//		for(int i=0;i<testTown.size();i++) {
//			int x = testTown.get(i).getSize();
//			int[] famAges = new int[x];
//			for(int j=0;j<famAges.length;j++) {
//				famAges[j] = testTown.get(i).getMembers().get(j).getAge();
//			}
//			System.out.println(Arrays.toString(famAges));
//		}
		testTown = calculator.assignJobs(svList, testTown);
		for(int i=0;i<testTown.size();i++) {
			for(int j=0;j<testTown.get(i).getMembers().size();j++) {
				Person tempPerson = testTown.get(i).getMembers().get(j);
				System.out.println(tempPerson.getAge() + "," + tempPerson.getJob());
			}
			System.out.println();
		}
		//end tester
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
	
	@RequestMapping("/reg-city-list")
	public ModelAndView regCityList() {
		ModelAndView mav = new ModelAndView("reg-city-list");
		List<DefaultSV> listAll = svDao.findByTownType("ActualCity");
		mav.addObject("listAll", listAll);
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
								@RequestParam("townType") String townType,
								@RequestParam("famjob") Boolean famjob) {
		DefaultSV defaultSV = svDao.findById(id);
		defaultSV.setSv(sv);
		defaultSV.setTitle(title);
		defaultSV.setTownType(townType);
		defaultSV.setFamjob(famjob);
		svDao.update(defaultSV);
		ModelAndView mav = new ModelAndView("redirect:/sv-editor");
		return mav;
	}
}