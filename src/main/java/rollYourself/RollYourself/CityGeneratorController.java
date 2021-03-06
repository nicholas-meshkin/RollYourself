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
import rollYourself.RollYourself.citygenmodel.Culture;
import rollYourself.RollYourself.citygenmodel.DefaultSV;
import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.Person;
import rollYourself.RollYourself.citygenmodel.Species;
import rollYourself.RollYourself.citygenmodel.Town;
import rollYourself.RollYourself.dao.CultureDao;
import rollYourself.RollYourself.dao.NamesDao;
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
	
	@Autowired
	NamesDao namesDao;
	@Autowired
	CultureDao cultureDao;
	
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
		List<Species> specList = speciesDao.findAll();
		mav.addObject("specList", specList);

		return mav;
	}
	@RequestMapping("/townBuilder2")
	public ModelAndView townBuilder2(@RequestParam("svType") String svType,
			@RequestParam("size") Integer size,
			@RequestParam("specIds") List<Long> specIds) {
		ModelAndView mav = new ModelAndView("town-builder-pg2");
		mav.addObject("svType", svType);
		mav.addObject("size", size);
		List<Species> specList = new ArrayList<>();
		for (int i=0;i<specIds.size();i++) {
			specList.add(speciesDao.findById(specIds.get(i)));
		}
		mav.addObject("specList", specList);
		List<Culture> cultureList = cultureDao.findAll();
		mav.addObject("cultureList", cultureList);
		return mav;
	}
	@RequestMapping("/townBuilder3")
	public ModelAndView townBuilder3(@RequestParam("svType") String svType,
									@RequestParam("size") Integer size,
									@RequestParam("specIds") List<Long> specIds,
									@RequestParam("popList") List<Integer> popList,
									@RequestParam("cultureList") List<Long> cultureList) {
			ModelAndView mav = new ModelAndView("town-builder-pg3");
			Town town = new Town();
			System.out.println(cultureList.size());
			town.setSize(size);
			town.setSvType(svType);
			List<Species> specList = new ArrayList<>();
			for (int i=0;i<specIds.size();i++) {
				specList.add(speciesDao.findById(specIds.get(i)));
			}
			List<Culture> cultList = new ArrayList<>();
			for (int i=0;i<cultureList.size();i++) {
				cultList.add(cultureDao.findById(cultureList.get(i)));
			}
			
			List<DefaultSV> svList = calculator.jobList(town);
			List<String> jobs = new ArrayList<>();
			for(int i=0;i<svList.size();i++) {
				jobs.add(svList.get(i).getTitle());
			}
			
			List<Family> testTown = calculator.createTown(size,specList,popList,cultList);
			
			
			testTown = calculator.assignJobs(svList, testTown);
			
			/*	TESTER
			 * for(int i=0;i<testTown.size();i++) {
				for(int j=0;j<testTown.get(i).getMembers().size();j++) {
					Person tempPerson = testTown.get(i).getMembers().get(j);
					System.out.println(tempPerson.getAge() + "," + tempPerson.getJob() + "," + tempPerson.getGender()
					+ "," + tempPerson.getSpecies().getName());
				}
			}*/
			
			/*Tester*/
//			Integer cultureId = 2;
//			for(int i=0;i<testTown.size();i++) {
//				calculator.assignNames(testTown.get(i));
//			}
			mav.addObject("testTown", testTown);
			return mav;
	}
}