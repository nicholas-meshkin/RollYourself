package rollYourself.RollYourself.CityGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.citygenmodel.Family;
import rollYourself.RollYourself.citygenmodel.NameItem;
import rollYourself.RollYourself.dao.NamesDao;

@Component
public class NameAssign {

		@Autowired
		NamesDao namesDao;
	
	//All names in database from Gary Gygax's Extraordinary Book of Names
		public void assignNames(List<Family> famList) {
			Random rand = new Random();
			
			//assign tribal names
			Map<Long, String> tribeNames = new HashMap<>();
			List<Long> convList = new ArrayList<>();
			for(int i=0;i<famList.size();i++) {
				convList.add(famList.get(i).getCulture().getId());
			}
			if(convList.contains((long)3)) {
				//make seed for tribe names here
				List<NameItem> afGen = namesDao.findNames((long)3, "T", "E");
				String afGenTribe = afGen.get(rand.nextInt(afGen.size())).getName();
				tribeNames.put((long)3, afGenTribe);
			}
			if(convList.contains((long)14)) {
				//make seed for tribe names here
				List<NameItem> mongol = namesDao.findNames((long)14, "T", "E");
				String mongolTribe = mongol.get(rand.nextInt(mongol.size())).getName();
				tribeNames.put((long)14, mongolTribe);
			}
			if(convList.contains((long)17)) {
				//make seed for tribe names here
				List<NameItem> tibet = namesDao.findNames((long)17, "T", "E");
				String tibetTribe = tibet.get(rand.nextInt(tibet.size())).getName();
				tribeNames.put((long)17, tibetTribe);
			}
			if(convList.contains((long)32)) {
				//make seed for tribe names here
				List<NameItem> celtic = namesDao.findNames((long)32, "T", "E");
				String celticTribe = celtic.get(rand.nextInt(celtic.size())).getName();
				tribeNames.put((long)32, celticTribe);
			}
			if(convList.contains((long)36)) {
				//make seed for tribe names here
				List<NameItem> germanic = namesDao.findNames((long)36, "T", "E");
				String germanicTribe = germanic.get(rand.nextInt(germanic.size())).getName();
				tribeNames.put((long)36, germanicTribe);
			}
			if(convList.contains((long)54)) {
				//make seed for tribe names here
				List<NameItem> aboriginal = namesDao.findNames((long)54, "T", "E");
				String aboriginalTribe = aboriginal.get(rand.nextInt(aboriginal.size())).getName();
				tribeNames.put((long)54, aboriginalTribe);
			}
			if(convList.contains((long)55)) {
				//make seed for tribe names here
				List<NameItem> papua = namesDao.findNames((long)55, "E", "E");
				String papuaTribe = papua.get(rand.nextInt(papua.size())).getName();
				tribeNames.put((long)55, papuaTribe);
			}
			
			for(int i=0;i<famList.size();i++) {
			Family family = famList.get(i);
			Long cultureId = family.getCulture().getId();
			Integer namingCon = family.getCulture().getNamingConvention();
			
			//For cultures with only personal names
			if(namingCon==1) {
				List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
				List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
				List<NameItem> allFirst = new ArrayList<>();
				allFirst.addAll(mFirst);
				allFirst.addAll(fFirst);
					for (int j=0;j<family.getMembers().size();j++) {
					if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
						int y = rand.nextInt(mFirst.size());
						family.getMembers().get(j).setFirstName(mFirst.get(y).getName());
					}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
						int y = rand.nextInt(fFirst.size());
						family.getMembers().get(j).setFirstName(fFirst.get(y).getName());
					}else {
						int y = rand.nextInt(allFirst.size());
						family.getMembers().get(j).setFirstName(allFirst.get(y).getName());
					}
					}
			}
			
			//For cultures with personal name and family name
			if(namingCon==2) {
				List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
				List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
				List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
				List<NameItem> allFirst = new ArrayList<>();
				allFirst.addAll(mFirst);
				allFirst.addAll(fFirst);
				int x = rand.nextInt(lastList.size());
				String lastname = lastList.get(x).getName();
					for (int j=0;j<family.getMembers().size();j++) {
						family.getMembers().get(j).setLastName(lastname);
						if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
							int y = rand.nextInt(mFirst.size());
							family.getMembers().get(j).setFirstName(mFirst.get(y).getName());
						}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
							int y = rand.nextInt(fFirst.size());
							family.getMembers().get(j).setFirstName(fFirst.get(y).getName());
						}else {
							int y = rand.nextInt(allFirst.size());
							family.getMembers().get(j).setFirstName(allFirst.get(y).getName());
						}
					}
			}
			
//			For cultures with personal name and tribal name
			if(namingCon==3) {
				List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
				List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
				List<NameItem> allFirst = new ArrayList<>();
				allFirst.addAll(mFirst);
				allFirst.addAll(fFirst);
				
				String lastname = tribeNames.get(family.getCulture().getId());
				for (int j=0;j<family.getMembers().size();j++) {
					family.getMembers().get(j).setLastName(lastname);
					if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
						int y = rand.nextInt(mFirst.size());
						family.getMembers().get(j).setFirstName(mFirst.get(y).getName());
					}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
						int y = rand.nextInt(fFirst.size());
						family.getMembers().get(j).setFirstName(fFirst.get(y).getName());
					}else {
						int y = rand.nextInt(allFirst.size());
						family.getMembers().get(j).setFirstName(allFirst.get(y).getName());
					}
				}
				
			}
			
			//For cultures with compound first name and surname
			if(namingCon==4) {
				List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
				List<NameItem> mFFirst = namesDao.findNames(cultureId, "FF", "M");
				List<NameItem> fFFirst =namesDao.findNames(cultureId, "FF", "F");
				List<NameItem> mFSecond = namesDao.findNames(cultureId, "FS", "M");
				List<NameItem> fFSecond =namesDao.findNames(cultureId, "FS", "F");
				List<NameItem> allFFirst = new ArrayList<>();
				List<NameItem> allFSecond = new ArrayList<>();
				allFFirst.addAll(mFFirst);
				allFFirst.addAll(fFFirst);
				allFSecond.addAll(mFSecond);
				allFSecond.addAll(fFSecond);
				int x = rand.nextInt(lastList.size());
				String lastname = lastList.get(x).getName();
				
				for (int j=0;j<family.getMembers().size();j++) {
					family.getMembers().get(j).setLastName(lastname);
					
					if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
						int y = rand.nextInt(mFFirst.size());
						int z = rand.nextInt(mFSecond.size());
						family.getMembers().get(j).setFirstName(mFFirst.get(y).getName()+"-"+mFSecond.get(z).getName());
					}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
						int y = rand.nextInt(fFFirst.size());
						int z = rand.nextInt(fFSecond.size());
						family.getMembers().get(j).setFirstName(fFFirst.get(y).getName()+"-"+fFSecond.get(z).getName());
					}else {
						int y = rand.nextInt(allFFirst.size());
						int z = rand.nextInt(allFSecond.size());
						family.getMembers().get(j).setFirstName(allFFirst.get(y).getName()+"-"+allFSecond.get(z).getName());
					}
				}
			}
			
			//Alt rules for unusual naming conventions
			if(namingCon==5) {
				
				//Maya - multi-part names
				if(cultureId==7) {
					List<NameItem> nameList = namesDao.findNames(cultureId, "U", "E");
					for (int j=0;j<family.getMembers().size();j++) {
						int roll =  rand.nextInt(20)+1;
						int numNames;
						String name = "";
						if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")) {
							name+="Ix-";
						}
						if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")) {
							name+="Ah-";
						}
						if(roll<4) {numNames=1;}
						else if(roll<15) {numNames=2;}
						else if(roll<20) {numNames=3;}
						else{numNames=4;}
						for(int h=0;h<numNames;h++) {
							int x = rand.nextInt(nameList.size());
							name+=nameList.get(x).getName()+"-";
						}
						String fullname = name.substring(0, name.length()-1);
						family.getMembers().get(j).setFirstName(fullname);
					}
				}
				
				//Tibet - First name, surname based on weekday, tribal name
				if(cultureId==17) {
					List<NameItem> lastList = namesDao.findNames(cultureId, "FS", "E");
					List<NameItem> First = namesDao.findNames(cultureId, "FF", "E");
					
						for (int j=0;j<family.getMembers().size();j++) {
							family.getMembers().get(j).setLastName(tribeNames.get(cultureId));
							int x = rand.nextInt(lastList.size());
							String weekname = lastList.get(x).getName();
								int y = rand.nextInt(First.size());
								family.getMembers().get(j).setFirstName(First.get(y).getName()+" "+weekname);
							}
						}
				
				
				//Anglo-Saxon - sometimes compound first name, sometimes single first name
				if(cultureId==18) {
					List<NameItem> singleNames = namesDao.findNames(cultureId, "F", "E");
					List<NameItem> mFFirst = namesDao.findNames(cultureId, "FF", "M");
					List<NameItem> fFFirst =namesDao.findNames(cultureId, "FF", "F");
					List<NameItem> mFSecond = namesDao.findNames(cultureId, "FS", "M");
					List<NameItem> fFSecond =namesDao.findNames(cultureId, "FS", "F");
					List<NameItem> allFFirst = new ArrayList<>();
					List<NameItem> allFSecond = new ArrayList<>();
					allFFirst.addAll(mFFirst);
					allFFirst.addAll(fFFirst);
					allFSecond.addAll(mFSecond);
					allFSecond.addAll(fFSecond);
					for (int j=0;j<family.getMembers().size();j++) {
						int roll = rand.nextInt(20)+1;
						if(roll<8) {
							int x = rand.nextInt(singleNames.size());
							family.getMembers().get(j).setFirstName(singleNames.get(x).getName());
						}else {
							if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
								int x = rand.nextInt(fFFirst.size());
								int y = rand.nextInt(fFSecond.size());
								String name = fFFirst.get(x).getName()+fFSecond.get(y).getName();
								family.getMembers().get(j).setFirstName(name);
							}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
								int x = rand.nextInt(mFFirst.size());
								int y = rand.nextInt(mFSecond.size());
								String name = mFFirst.get(x).getName()+mFSecond.get(y).getName();
								family.getMembers().get(j).setFirstName(name);
							}else {
								int x = rand.nextInt(allFFirst.size());
								int y = rand.nextInt(allFSecond.size());
								String name = allFFirst.get(x).getName()+allFSecond.get(y).getName();
								family.getMembers().get(j).setFirstName(name);
							}
						}
					}
				}
				//Germanic - compound personal, tribal
				if(cultureId==36) {
					List<NameItem> mFFirst = namesDao.findNames(cultureId, "FF", "M");
					List<NameItem> fFFirst =namesDao.findNames(cultureId, "FF", "F");
					List<NameItem> mFSecond = namesDao.findNames(cultureId, "FS", "M");
					List<NameItem> fFSecond =namesDao.findNames(cultureId, "FS", "F");
					List<NameItem> allFFirst = new ArrayList<>();
					List<NameItem> allFSecond = new ArrayList<>();
					allFFirst.addAll(mFFirst);
					allFFirst.addAll(fFFirst);
					allFSecond.addAll(mFSecond);
					allFSecond.addAll(fFSecond);
					for (int j=0;j<family.getMembers().size();j++) {
						family.getMembers().get(j).setLastName(tribeNames.get(cultureId));
						if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
							int y = rand.nextInt(mFFirst.size());
							int z = rand.nextInt(mFSecond.size());
							family.getMembers().get(j).setFirstName(mFFirst.get(y).getName()+"-"+mFSecond.get(z).getName());
						}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
							int y = rand.nextInt(fFFirst.size());
							int z = rand.nextInt(fFSecond.size());
							family.getMembers().get(j).setFirstName(fFFirst.get(y).getName()+"-"+fFSecond.get(z).getName());
						}else {
							int y = rand.nextInt(allFFirst.size());
							int z = rand.nextInt(allFSecond.size());
							family.getMembers().get(j).setFirstName(allFFirst.get(y).getName()+"-"+allFSecond.get(z).getName());
						}
					}
				}
				//Rome - 3 parts with alterations for females, not doing this totally accurately because I don't feel like it
				if(cultureId==51) {
					List<NameItem> praenomens = namesDao.findNames(cultureId, "FF", "M");
					List<NameItem> nomens = namesDao.findNames(cultureId, "FS", "M");
					List<NameItem> cognomens = namesDao.findNames(cultureId, "FT", "M");
					for (int j=0;j<family.getMembers().size();j++) {
						
						if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")) {
							int x = rand.nextInt(praenomens.size());
							int y = rand.nextInt(nomens.size());
							int z = rand.nextInt(cognomens.size());
							family.getMembers().get(j).setFirstName(romanConversion(praenomens.get(x).getName())+" "+romanConversion(nomens.get(y).getName()));
							family.getMembers().get(j).setLastName(romanConversion(cognomens.get(z).getName()));
						}else{
							int x = rand.nextInt(praenomens.size());
							int y = rand.nextInt(nomens.size());
							int z = rand.nextInt(cognomens.size());
							family.getMembers().get(j).setFirstName(praenomens.get(x).getName()+" "+nomens.get(y).getName());
							family.getMembers().get(j).setLastName(cognomens.get(z).getName());
						}
					}
				}
				//Aboriginal - first, surname, tribal name
				if(cultureId==54) {
					List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
					List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
					List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
					List<NameItem> allFirst = new ArrayList<>();
					allFirst.addAll(mFirst);
					allFirst.addAll(fFirst);
					int x = rand.nextInt(lastList.size());
					String lastname = lastList.get(x).getName();
						for (int j=0;j<family.getMembers().size();j++) {
							family.getMembers().get(j).setLastName(tribeNames.get(cultureId));
							if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
								int y = rand.nextInt(mFirst.size());
								family.getMembers().get(j).setFirstName(mFirst.get(y).getName()+"-"+lastname);
							}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
								int y = rand.nextInt(fFirst.size());
								family.getMembers().get(j).setFirstName(fFirst.get(y).getName()+"-"+lastname);
							}else {
								int y = rand.nextInt(allFirst.size());
								family.getMembers().get(j).setFirstName(allFirst.get(y).getName()+"-"+lastname);
							}
						}
				}
				//Papua - First, surname, list of alts that can be either, I'm using them as tribal names
				if(cultureId==55) {
					List<NameItem> lastList = namesDao.findNames(cultureId, "S", "E");
					List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
					List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
					List<NameItem> allFirst = new ArrayList<>();
					allFirst.addAll(mFirst);
					allFirst.addAll(fFirst);
					int x = rand.nextInt(lastList.size());
					String lastname = lastList.get(x).getName();
						for (int j=0;j<family.getMembers().size();j++) {
							family.getMembers().get(j).setLastName(tribeNames.get(cultureId));
							if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
								int y = rand.nextInt(mFirst.size());
								family.getMembers().get(j).setFirstName(mFirst.get(y).getName()+"-"+lastname);
							}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
								int y = rand.nextInt(fFirst.size());
								family.getMembers().get(j).setFirstName(fFirst.get(y).getName()+"-"+lastname);
							}else {
								int y = rand.nextInt(allFirst.size());
								family.getMembers().get(j).setFirstName(allFirst.get(y).getName()+"-"+lastname);
							}
						}
				}
			}
		}
	}
	
	public String romanConversion(String name) {
		String newName;
		if(name.endsWith("us")) {
			newName = name.substring(0,name.length()-2)+"a";
		}else if(name.endsWith("o")) {
			newName = name.substring(0,name.length()-1)+"a";
		}else if(name.endsWith("a")) {
			newName = name.substring(0,name.length()-1)+"ina";
		}else {newName=name;}
		return newName;
	}
}
