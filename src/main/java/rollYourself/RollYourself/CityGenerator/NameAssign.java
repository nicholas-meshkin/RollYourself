package rollYourself.RollYourself.CityGenerator;

import java.util.ArrayList;
import java.util.List;
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
			
			//TODO figure out how to assign tribal names
			List<Integer> convList = new ArrayList<>();
			for(int i=0;i<famList.size();i++) {
				convList.add(famList.get(i).getCulture().getNamingConvention());
			}
			if(convList.contains(3)||convList.contains(5)) {
				
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
			
			//For cultures with personal name and tribal name
	//		if(namingCon==3) {
	//			List<NameItem> tribeList = namesDao.findNames(cultureId, "T", "E");
	//			List<NameItem> mFirst = namesDao.findNames(cultureId, "F", "M");
	//			List<NameItem> fFirst =namesDao.findNames(cultureId, "F", "F");
	//			List<NameItem> allFirst = new ArrayList<>();
	//			allFirst.addAll(mFirst);
	//			allFirst.addAll(fFirst);
	//			int x = rand.nextInt(tribeList.size());
	//			String lastname = tribeList.get(x).getName();
	//			for (int j=0;j<family.getMembers().size();j++) {
	//				family.getMembers().get(j).setLastName(lastname);
	//				if(family.getMembers().get(j).getGender().equalsIgnoreCase("male")){
	//					int y = rand.nextInt(mFirst.size());
	//					family.getMembers().get(j).setFirstName(mFirst.get(y).getName());
	//				}else if(family.getMembers().get(j).getGender().equalsIgnoreCase("female")){
	//					int y = rand.nextInt(fFirst.size());
	//					family.getMembers().get(j).setFirstName(fFirst.get(y).getName());
	//				}else {
	//					int y = rand.nextInt(allFirst.size());
	//					family.getMembers().get(j).setFirstName(allFirst.get(y).getName());
	//				}
	//			}
	//			
	//		}
			
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
				if(cultureId==7) {
					List<NameItem> nameList = namesDao.findNames(cultureId, "U", "E");
					for (int j=0;j<family.getMembers().size();j++) {
						int roll =  rand.nextInt(20)+1;
						int numNames;
						String name = "";
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
				if(cultureId==17) {}
				if(cultureId==18) {}
				if(cultureId==36) {}
				if(cultureId==51) {}
				if(cultureId==54) {}
				if(cultureId==55) {}
			}
		}
	}
	
	
}
