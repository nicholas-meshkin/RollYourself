package rollYourself.RollYourself.CityGenerator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.citygenmodel.Culture;
import rollYourself.RollYourself.citygenmodel.DefaultSV;
import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.NameItem;
import rollYourself.RollYourself.citygenmodel.Person;
import rollYourself.RollYourself.citygenmodel.Species;
import rollYourself.RollYourself.citygenmodel.Town;
import rollYourself.RollYourself.dao.NamesDao;
import rollYourself.RollYourself.dao.SVDao;
import rollYourself.RollYourself.dao.SpeciesDao;

@Component
public class Calculator {

	@Autowired
	SVDao svDao;
	
	@Autowired
	SpeciesDao speciesDao;
	
	@Autowired
	NamesDao namesDao;
	
	@Autowired NameAssign nameAssign;
	
	public List<Double> generateAges(int numPpl, int stDev, int mean){
		List<Double> ageList = new ArrayList<>();
		for(int i=0;i<numPpl;i++) {
		ageList.add(getAge(stDev,mean));
		}
		return ageList;
	}

	public Double getAge(int stDev, int mean) {
		Double age = -1.0;
		Random rand = new Random();
		while(age<0) {
		age = (rand.nextGaussian()*stDev)+mean;
		}
		return age;
	}
	
	public Double getChild(int fertAge,int stDev, int mean) {
		Double age = 1000.0;
		while(age>fertAge) {
			age=getAge(stDev,mean);
		}
		return age;
	}
	
	public Boolean isChild(Person person) {
		boolean isChild;
		if(person.getAge()<person.getSpecies().getFertAge()) {
			isChild = true;
		}
		else {isChild=false;}
		return isChild;
	}
	
	public Double getAdult(int fertAge,int stDev, int mean) {
		Double age = 0.0;
		while(age<fertAge) {
			age=getAge(stDev,mean);
		}
		return age;
	}
	
	public List<Family> createTown(Integer townSize, List<Species> specList, List<Integer> popList, List<Culture> cultList){
		List<Family> townspeople = new ArrayList<>();
		int currSum = 0;
		while(currSum<townSize) {
			Species testSpec = specSelector(specList,popList);
			Family fam = getFam(testSpec);
			Culture culture = cultList.get(specList.indexOf(testSpec));
			fam.setSpecies(testSpec);
			fam.setCulture(culture);
			townspeople.add(fam);
			currSum+=fam.getSize();
		}
		nameAssign.assignNames(townspeople);
		return townspeople;
	}
	
//	public Species specSelector(LinkedHashMap<Species,Integer> specList) {
//		Random rand = new Random();
//		int x = rand.nextInt(100)+1;
//		Species species = new Species();
//		int currSum=0;
//		for(Map.Entry<Species, Integer> entry : specList.entrySet()) {
//			currSum+=entry.getValue();
//			if(x<=currSum) {
//				species = entry.getKey();
//				return species;
//			}
//		}
//		return species;
//	}
	public Species specSelector(List<Species> specList, List<Integer> popList) {
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		Species species = new Species();
		int currSum=0;
		for(int i=0;i<specList.size();i++) {
			currSum+=popList.get(i);
			if(x<=currSum) {
				species = specList.get(i);
				return species;
			}
		}
		return species;
	}
	
	public Family getFam(Species famSpecies) {
		Random rand = new Random();
		Family fam = new Family();
		List<Person> famMembers = new ArrayList<>();
		fam.setSize(0);
		while(fam.getSize()<1) {
		fam.setSize((int) (rand.nextGaussian()*famSpecies.getFamStDev())+famSpecies.getFamAvg());
		}
		for(int i=0;i<fam.getSize();i++) {
			Person currPer = new Person();
			currPer.setAge(getAge(famSpecies.getAgeStDev(), famSpecies.getAgeMean()).intValue());
			assignGender(currPer);
			currPer.setSpecies(famSpecies);
			famMembers.add(currPer);
		}
		fam.setMembers(famMembers);
		assignOrphanStatus(fam);
		return fam;
	}
	public void assignGender(Person person) {
		Random rand = new Random();
		int x = rand.nextInt(251);
		//1/250 ratio from https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5227946/
		if(x==0) {
			person.setGender("non-binary");
		}
		if(x>0 && x<126) {
			person.setGender("male");
		}
		if(x>125) {
			person.setGender("female");
		}
	}
	public void assignOrphanStatus(Family family) {
		int ageMax=0;
		for(int i=0;i<family.getSize();i++) {
			int currAge=family.getMembers().get(i).getAge();
			if(currAge>ageMax) {
				ageMax=currAge;
				}
		}
		if(ageMax<family.getMembers().get(0).getSpecies().getFertAge()) {
			for(int i=0;i<family.getSize();i++) {
				family.getMembers().get(i).setIsOrphan(true);
			}
		}else {
			for(int i=0;i<family.getSize();i++) {
			family.getMembers().get(i).setIsOrphan(false);
				}
			}
	}
	
	public int countAdults(Family fam) {
		int adCount = 0;
		for(int i=0;i<fam.getMembers().size();i++) {
			if(fam.getMembers().get(i).getAge()>fam.getMembers().get(0).getSpecies().getFertAge()) {
				adCount++;
			}
		}
		return adCount;
	}
	
	public void assignNobleStatus(Family fam) {
		for(int i=0;i<fam.getMembers().size();i++) {
			fam.getMembers().get(i).setJob("Noble");
		}
	}
	
	
	public void assignDefaultJob(Family fam) {
		for(int i=0;i<fam.getMembers().size();i++) {
			fam.getMembers().get(i).setJob("Commoner");
		}
	}
	
	public void assignFamJob(Family fam, DefaultSV job) {
		for(int i=0;i<fam.getMembers().size();i++) {
			fam.getMembers().get(i).setJob(job.getTitle());
		}
	}
	
	public List<DefaultSV> jobList(Town town){
		List<DefaultSV> listAll = svDao.findByTownType(town.getSvType());
		List<DefaultSV> thisList = new ArrayList<>();
		Random rand = new Random();
		for(int i=0;i<listAll.size();i++) {
			int currSV = town.getSize();
			while(currSV>0) {
				if(currSV>listAll.get(i).getSv()) {
					currSV-= listAll.get(i).getSv();
					thisList.add(listAll.get(i));
				}else {
					int chance = rand.nextInt(listAll.get(i).getSv());
					if(chance<currSV) {
						thisList.add(listAll.get(i));
					}
					currSV=0;
				}
			}
		}
		return thisList;
	}
	
	public List<Family> assignJobs(List<DefaultSV> jobList, List<Family> famList){
		Random rand = new Random();
		List<Family> famListNew = new ArrayList<>();
//		List<String> jobNames = new ArrayList<>();
//		for(int i=0;i<jobList.size();i++) {
//			jobNames.add(jobList.get(i).getTitle());
//		}
		
		//set noble families
			for(int i=0;i<jobList.size();i++) {
				if(jobList.get(i).getTitle().equals("Noble")){
					famList.get(0).setIsNoble(true);
					Family tempFam = famList.get(0);
					assignNobleStatus(tempFam);
					famListNew.add(tempFam);
					famList.remove(0);
					jobList.remove(i);
					i--;
				}
			}
		for(int i=0;i<famList.size();i++) {
			//Set job to urchin if orphan and non-noble
			if(famList.get(i).getMembers().get(0).getIsOrphan()){
				Family tempFam = new Family();
				List<Person> tempList = new ArrayList<>();
				for(int j=0;j<famList.get(i).getMembers().size();j++) {
					Person tempPerson = famList.get(i).getMembers().get(j);
					tempPerson.setJob("urchin");
					tempList.add(tempPerson);
				}
				tempFam.setMembers(tempList);
				famListNew.add(tempFam);
				famList.remove(i);
			}
		}
		
//		while(jobList.size()!=0) {
		
		//assign family professions
			for(int i=0;i<jobList.size();i++) {
				
				if(jobList.get(i).getFamjob()){
					Family tempFam = famList.get(0);
					assignFamJob(tempFam, jobList.get(i));
					famListNew.add(tempFam);
					famList.remove(0);
					jobList.remove(i);
					i--;
				}
				}
			
			//set everyone that is left to default jobs
			for(int i=0;i<famList.size();i++) {
				assignDefaultJob(famList.get(i));
				Family tempFam = famList.get(i);
				famListNew.add(tempFam);
			}
			
			//assign solo jobs randomly
//			for(int i=0;i<jobList.size();i++) 
			while(!jobList.isEmpty()){
					int x = rand.nextInt(famListNew.size());
					int y = rand.nextInt(famListNew.get(x).getMembers().size());
					if( famListNew.get(x).getMembers().get(y).getAge()>famListNew.get(x).getMembers().get(y).getSpecies().getFertAge() &&
							(famListNew.get(x).getMembers().get(y).getJob().equals("Commoner"))|| countAdults(famListNew.get(x))>3 ) {
						famListNew.get(x).getMembers().get(y).setJob(jobList.get(0).getTitle());
						jobList.remove(0);
					}
				}
//			}
		
//		//add rest of fams to new list
//		for(Family i :famList) {
//			famListNew.add(i);
//		}
		
		return famListNew;
	}
	
//	public void assignNames(Family family) {
//		Random rand = new Random();
//		Long cultureId = family.getCulture().getId();
//		
//		//For cultures with only personal names
//		if(cultureId==1) {
//			List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
//			List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
//			List<NameItem> allFirst = new ArrayList<>();
//			allFirst.addAll(mFirst);
//			allFirst.addAll(fFirst);
//				for (int i=0;i<family.getMembers().size();i++) {
//				if(family.getMembers().get(i).getGender().equalsIgnoreCase("male")){
//					int y = rand.nextInt(mFirst.size());
//					family.getMembers().get(i).setFirstName(mFirst.get(y).getName());
//				}else if(family.getMembers().get(i).getGender().equalsIgnoreCase("female")){
//					int y = rand.nextInt(fFirst.size());
//					family.getMembers().get(i).setFirstName(fFirst.get(y).getName());
//				}else {
//					int y = rand.nextInt(allFirst.size());
//					family.getMembers().get(i).setFirstName(allFirst.get(y).getName());
//				}
//				}
//		}
//		
//		//For cultures with personal name and family name
//		if(cultureId==2) {
//			List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
//			List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
//			List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
//			List<NameItem> allFirst = new ArrayList<>();
//			allFirst.addAll(mFirst);
//			allFirst.addAll(fFirst);
//			int x = rand.nextInt(lastList.size());
//			String lastname = lastList.get(x).getName();
//				for (int i=0;i<family.getMembers().size();i++) {
//					family.getMembers().get(i).setLastName(lastname);
//					if(family.getMembers().get(i).getGender().equalsIgnoreCase("male")){
//						int y = rand.nextInt(mFirst.size());
//						family.getMembers().get(i).setFirstName(mFirst.get(y).getName());
//					}else if(family.getMembers().get(i).getGender().equalsIgnoreCase("female")){
//						int y = rand.nextInt(fFirst.size());
//						family.getMembers().get(i).setFirstName(fFirst.get(y).getName());
//					}else {
//						int y = rand.nextInt(allFirst.size());
//						family.getMembers().get(i).setFirstName(allFirst.get(y).getName());
//					}
//				}
//		}
//		
//		//For cultures with personal name and tribal name
//		if(cultureId==3) {
//			List<NameItem> tribeList = namesDao.findNames(cultureId, "T", "E");
//			List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
//			List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
//			List<NameItem> allFirst = new ArrayList<>();
//			allFirst.addAll(mFirst);
//			allFirst.addAll(fFirst);
//			int x = rand.nextInt(tribeList.size());
//			String lastname = tribeList.get(x).getName();
//			for (int i=0;i<family.getMembers().size();i++) {
//				family.getMembers().get(i).setLastName(lastname);
//				if(family.getMembers().get(i).getGender().equalsIgnoreCase("male")){
//					int y = rand.nextInt(mFirst.size());
//					family.getMembers().get(i).setFirstName(mFirst.get(y).getName());
//				}else if(family.getMembers().get(i).getGender().equalsIgnoreCase("female")){
//					int y = rand.nextInt(fFirst.size());
//					family.getMembers().get(i).setFirstName(fFirst.get(y).getName());
//				}else {
//					int y = rand.nextInt(allFirst.size());
//					family.getMembers().get(i).setFirstName(allFirst.get(y).getName());
//				}
//			}
//			
//		}
//		if(cultureId==4) {}
//		if(cultureId==5) {}
//		List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
//		List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
//		List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
//		List<NameItem> allFirst = new ArrayList<>();
//		allFirst.addAll(mFirst);
//		allFirst.addAll(fFirst);
//		int x = rand.nextInt(lastList.size());
//		String lastname = lastList.get(x).getName();
//		for (int i=0;i<family.getMembers().size();i++) {
//			family.getMembers().get(i).setLastName(lastname);
//			if(family.getMembers().get(i).getGender().equalsIgnoreCase("male")){
//				int y = rand.nextInt(mFirst.size());
//				family.getMembers().get(i).setFirstName(mFirst.get(y).getName());
//			}else if(family.getMembers().get(i).getGender().equalsIgnoreCase("female")){
//				int y = rand.nextInt(fFirst.size());
//				family.getMembers().get(i).setFirstName(fFirst.get(y).getName());
//			}else {
//				int y = rand.nextInt(allFirst.size());
//				family.getMembers().get(i).setFirstName(allFirst.get(y).getName());
//			}
//		}
//	}

}