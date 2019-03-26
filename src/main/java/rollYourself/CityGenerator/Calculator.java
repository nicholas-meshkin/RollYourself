package rollYourself.CityGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.Person;
import rollYourself.RollYourself.citygenmodel.Species;

public class Calculator {

	
	public static List<Double> generateAges(int numPpl, int stDev, int mean){
		List<Double> ageList = new ArrayList<>();
		for(int i=0;i<numPpl;i++) {
		ageList.add(getAge(stDev,mean));
		}
		return ageList;
	}

	public static Double getAge(int stDev, int mean) {
		Double age = -1.0;
		Random rand = new Random();
		while(age<0) {
		age = (rand.nextGaussian()*stDev)+mean;
		}
		return age;
	}
	
	public static Double getChild(int fertAge,int stDev, int mean) {
		Double age = 1000.0;
		while(age>fertAge) {
			age=getAge(stDev,mean);
		}
		return age;
	}
	
	public static Boolean isChild(Person person) {
		boolean isChild;
		if(person.getAge()<person.getSpecies().getFertAge()) {
			isChild = true;
		}
		else {isChild=false;}
		return isChild;
	}
	
	public static Double getAdult(int fertAge,int stDev, int mean) {
		Double age = 0.0;
		while(age<fertAge) {
			age=getAge(stDev,mean);
		}
		return age;
	}
	
	public static List<Family> createTown(Integer townSize){
		List<Family> townspeople = new ArrayList<>();
		int currSum = 0;
		Species testSpec = new Species();
		testSpec.setAgeMean(20);
		testSpec.setAgeStDev(25);
		testSpec.setFamAvg(4);
		testSpec.setFamStDev(2);
		testSpec.setFertAge(18);
		while(currSum<townSize) {
			Family fam = getFam(testSpec);
			townspeople.add(fam);
			currSum+=fam.getSize();
		}
		
		return townspeople;
	}
	
	public static Family getFam(Species famSpecies) {
		Random rand = new Random();
		Family fam = new Family();
		List<Person> famMembers = new ArrayList<>();
		fam.setSize(0);
		while(fam.getSize()<1) {
		fam.setSize((int) (rand.nextGaussian()*famSpecies.getFamStDev())+famSpecies.getFamAvg());
		}
		for(int i=0;i<fam.getSize();i++) {
			Person currPer = new Person();
			currPer.setAge(Calculator.getAge(famSpecies.getAgeStDev(), famSpecies.getAgeMean()).intValue());
			assignGender(currPer);
			famMembers.add(currPer);
		}
		fam.setMembers(famMembers);
		assignOrphanStatus(fam);
		return fam;
	}
	public static void assignGender(Person person) {
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
	public static void assignOrphanStatus(Family family) {
		int ageMax=0;
		for(int i=0;i<family.getSize();i++) {
			int currAge=family.getMembers().get(i).getAge();
			if(currAge>ageMax) {ageMax=currAge;}
		}
		if(ageMax<family.getMembers().get(0).getSpecies().getFertAge()) {
			for(int i=0;i<family.getSize();i++) {
				family.getMembers().get(i).setIsOrphan(true);
			}
		}
	}

}
