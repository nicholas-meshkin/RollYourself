package rollYourself.RollYourself;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rollYourself.RollYourself.CityGenerator.Calculator;
import rollYourself.RollYourself.citygenmodel.DefaultSV;
import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.Person;
import rollYourself.RollYourself.citygenmodel.Species;
import rollYourself.RollYourself.citygenmodel.Town;
import rollYourself.RollYourself.dao.SVDao;
import rollYourself.RollYourself.dao.SpeciesDao;

@Controller
public class CityGeneratorController {
	@Autowired
	SVDao svDao;
	
	@Autowired
	SpeciesDao speciesDao;
	
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
								@RequestParam("townType") String townType,
								@RequestParam("famjob") Boolean famjob) {
		DefaultSV newSV = new DefaultSV();
		newSV.setSv(sv);
		newSV.setTitle(title);
		newSV.setTownType(townType);
		newSV.setFamjob(famjob);
		svDao.create(newSV);
		ModelAndView mav = new ModelAndView("redirect:/sv-editor");
		return mav;
	}
	
	@RequestMapping("/reg-city-list")
	public ModelAndView regCityList() {
		ModelAndView mav = new ModelAndView("reg-city-list");
		List<DefaultSV> listAll = svDao.findByTownType("ActualCity");
		System.out.println(listAll);
		mav.addObject("listAll", listAll);
		return mav;
	}
	
	@RequestMapping("/rural-city-list")
	public ModelAndView ruralCityList() {
		ModelAndView mav = new ModelAndView("reg-city-list");
		List<DefaultSV> listAll = svDao.findByTownType("RuralCommunity");
		System.out.println(listAll);
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
	
	@RequestMapping("/specEdit")
	public ModelAndView specEdit() {
		ModelAndView mav = new ModelAndView("spec-edit");
		List<Species> specList = speciesDao.findAll();
		mav.addObject("specList", specList);
		return mav;
		
	}
	@PostMapping("/specEdit")
	public ModelAndView submitSpec(@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("famAvg") Integer famAvg,
			@RequestParam("famStDev") Integer famStDev,
			@RequestParam("ageMean") Integer ageMean,
			@RequestParam("ageStDev") Integer ageStDev,
			@RequestParam("fertAge") Integer fertAge) {
		ModelAndView mav = new ModelAndView("spec-edit");
		Species species = new Species();
		species.setAgeMean(ageMean);
		species.setAgeStDev(ageStDev);
		species.setFamAvg(famAvg);
		species.setFamStDev(famStDev);
		species.setFertAge(fertAge);
		species.setName(name);
		speciesDao.create(species);
		List<Species> specList = speciesDao.findAll();
		mav.addObject("specList", specList);
		return mav;
	}
	
	@RequestMapping("/deleteSpecies")
	public ModelAndView deleteSpecies(@RequestParam("id") Long id) {
		speciesDao.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/specEdit");
		return mav;
	}
	
	@RequestMapping("/updateSpecies")
	public ModelAndView specUpdatePage(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("species-edit-page");
		Species species = speciesDao.findById(id);
		mav.addObject("species", species);
		return mav;
	}
	@PostMapping("/updateSpecies")
	public ModelAndView updateSV(@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("famAvg") Integer famAvg,
			@RequestParam("famStDev") Integer famStDev,
			@RequestParam("ageMean") Integer ageMean,
			@RequestParam("ageStDev") Integer ageStDev,
			@RequestParam("fertAge") Integer fertAge,
			@RequestParam("popPct") Integer popPct) {
		Species species = speciesDao.findById(id);
		species.setAgeMean(ageMean);
		species.setAgeStDev(ageStDev);
		species.setFamAvg(famAvg);
		species.setFamStDev(famStDev);
		species.setFertAge(fertAge);
		species.setName(name);
		species.setPopPct(popPct);
		speciesDao.update(species);
		ModelAndView mav = new ModelAndView("redirect:/specEdit");
		return mav;
	}
	
	@RequestMapping("/townBuilder")
	public ModelAndView townBuilder() {
		ModelAndView mav = new ModelAndView("town-builder-pg1");
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
				testTown = calculator.assignJobs(svList, testTown);
				for(int i=0;i<testTown.size();i++) {
					for(int j=0;j<testTown.get(i).getMembers().size();j++) {
						Person tempPerson = testTown.get(i).getMembers().get(j);
						System.out.println(tempPerson.getAge() + "," + tempPerson.getJob() + "," + tempPerson.getGender()
						+ "," + tempPerson.getSpecies().getName());
					}
					System.out.println();
				}
				//end tester

		return mav;
	}
	
	@RequestMapping("/townBuilder2")
	public ModelAndView townBuilder2() {
			ModelAndView mav = new ModelAndView("town-builder-pg2");
			
			return mav;
	}
}