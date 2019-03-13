package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.dao.QuestionResponsesDao;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.Equipment;
import rollYourself.RollYourself.model.PropertyItem;
import rollYourself.RollYourself.model.QuestionResponses;
import rollYourself.RollYourself.model.Spell;
import rollYourself.RollYourself.model.SpellInfo;

@Component
public class DecisionTree {

	@Autowired 
	private ApiService apiService;
	
	@Autowired
	private StatSetter statSetter;
	
	@Autowired
	QuestionResponsesDao questionResponsesDao;
	
	public Integer selectRace(DndCharacter dndCharacter) {
		Integer raceSelection = 0;
		
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 8;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 9;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 4) && (dndCharacter.getQ2Response() == 4) ) {raceSelection = 9;}
		return raceSelection;
	}
	
	public Integer selectRace(Long id) {
		QuestionResponses questionResponses = questionResponsesDao.findById(id);
		Integer raceSelection = 0;
	
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 1;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 2;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 4) ) {raceSelection = 4;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 4;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 4) ) {raceSelection = 1;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 7;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 8;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 9;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 4) ) {raceSelection = 2;}
		if ( (questionResponses.getQ1Response() == 4) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 3;}
		if ( (questionResponses.getQ1Response() == 4) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (questionResponses.getQ1Response() == 4) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 5;}
		if ( (questionResponses.getQ1Response() == 4) && (questionResponses.getQ2Response() == 4) ) {raceSelection = 9;}
		return raceSelection;
	}
	
	public Integer selectClass(Long id) {
		QuestionResponses questionResponses = questionResponsesDao.findById(id);
		Integer classSelection = 0;
		
		if ( (questionResponses.getQ3Response() == 1) && (questionResponses.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (questionResponses.getQ3Response() == 1) && (questionResponses.getQ4Response() == 2) ) {classSelection = 2;}
		if ( (questionResponses.getQ3Response() == 1) && (questionResponses.getQ4Response() == 3) ) {classSelection = 3;}
		if ( (questionResponses.getQ3Response() == 1) && (questionResponses.getQ4Response() == 4) ) {classSelection = 4;}
		if ( (questionResponses.getQ3Response() == 2) && (questionResponses.getQ4Response() == 1) ) {classSelection = 5;}
		if ( (questionResponses.getQ3Response() == 2) && (questionResponses.getQ4Response() == 2) ) {classSelection = 6;}
		if ( (questionResponses.getQ3Response() == 2) && (questionResponses.getQ4Response() == 3) ) {classSelection = 7;}
		if ( (questionResponses.getQ3Response() == 2) && (questionResponses.getQ4Response() == 4) ) {classSelection = 8;}
		if ( (questionResponses.getQ3Response() == 3) && (questionResponses.getQ4Response() == 1) ) {classSelection = 9;}
		if ( (questionResponses.getQ3Response() == 3) && (questionResponses.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (questionResponses.getQ3Response() == 3) && (questionResponses.getQ4Response() == 3) ) {classSelection = 11;}
		if ( (questionResponses.getQ3Response() == 3) && (questionResponses.getQ4Response() == 4) ) {classSelection = 12;}
		if ( (questionResponses.getQ3Response() == 4) && (questionResponses.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (questionResponses.getQ3Response() == 4) && (questionResponses.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (questionResponses.getQ3Response() == 4) && (questionResponses.getQ4Response() == 3) ) {classSelection = 5;}
		if ( (questionResponses.getQ3Response() == 4) && (questionResponses.getQ4Response() == 4) ) {classSelection = 9;}
		
		return classSelection;
	}
	
	public Integer selectClass(DndCharacter dndCharacter) {
		Integer classSelection = 0;
		
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 2;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 3;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 4;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 6;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 7;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 8;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 9;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 11;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 12;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 1;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 4) ) {classSelection = 9;}
		return classSelection;
	}
	
	public List<Equipment> selectWeapons(Integer classSelection){
			List<Equipment> weaponList = new ArrayList<>();
				if (classSelection == 1){
					weaponList.add(apiService.getEquipment(5));//TODO figure out how to adjust count
					weaponList.add(apiService.getEquipment(18));
					weaponList.add(apiService.getEquipment(4));//TODO figure out how to adjust count
				}
				if (classSelection == 2){
					weaponList.add(apiService.getEquipment(2));
					weaponList.add(apiService.getEquipment(26));
				}
				if (classSelection == 3){
					weaponList.add(apiService.getEquipment(7));
					weaponList.add(apiService.getEquipment(11)); //TODO add bolts for light crossbow
				}
				if (classSelection == 4){
					weaponList.add(apiService.getEquipment(27));
				}
				if (classSelection == 5){
					weaponList.add(apiService.getEquipment(15));
					weaponList.add(apiService.getEquipment(11)); //TODO add bolts for light crossbow
				}
				if (classSelection == 6){
					weaponList.add(apiService.getEquipment(10));//TODO figure out how to adjust count
					weaponList.add(apiService.getEquipment(8));
				}
				if (classSelection == 7){
					weaponList.add(apiService.getEquipment(22));
					weaponList.add(apiService.getEquipment(5));//TODO figure out how to adjust count
				}
				if (classSelection == 8){
					weaponList.add(apiService.getEquipment(36)); //TODO add arrows
					weaponList.add(apiService.getEquipment(28)); //TODO adjust count
				}
				if (classSelection == 9){
					weaponList.add(apiService.getEquipment(13));//TODO add arrows
					weaponList.add(apiService.getEquipment(2));
					weaponList.add(apiService.getEquipment(26));
				}
				if (classSelection == 10){
					weaponList.add(apiService.getEquipment(2));//TODO adjust count
					weaponList.add(apiService.getEquipment(11));//TODO add bolts
				}
				if (classSelection == 11){
					weaponList.add(apiService.getEquipment(2));//TODO adjust count
					weaponList.add(apiService.getEquipment(11));//TODO add bolts
					weaponList.add(apiService.getEquipment(8));
				}
				if (classSelection == 12){
					weaponList.add(apiService.getEquipment(8));
				}
				return weaponList;
	
	}
	
	public List<Equipment> selectArmor(Integer classSelection){
		List<Equipment> armorList = new ArrayList<>();
			if (classSelection == 1 || classSelection == 6 || classSelection == 10 || classSelection == 12){
				//no armor for these
			}
			if (classSelection == 2){
				armorList.add(apiService.getEquipment(39));
			}
			if (classSelection == 3){
				armorList.add(apiService.getEquipment(43));
				armorList.add(apiService.getEquipment(50));
			}
			if (classSelection == 4){
				armorList.add(apiService.getEquipment(39));
				armorList.add(apiService.getEquipment(50));
			}
			if (classSelection == 5){
				armorList.add(apiService.getEquipment(47));
				armorList.add(apiService.getEquipment(50));
			}
			if (classSelection == 7){
				armorList.add(apiService.getEquipment(47));
				armorList.add(apiService.getEquipment(50));
			}
			if (classSelection == 8){
				armorList.add(apiService.getEquipment(43));
			}
			if (classSelection == 9){
				armorList.add(apiService.getEquipment(39));
			}
			if (classSelection == 11){
				armorList.add(apiService.getEquipment(39));
			}
			
			return armorList;

}
	public List<Equipment> selectOtherEquipment(Integer classSelection){
		List<Equipment> otherList = new ArrayList<>();
			if (classSelection == 1){
				otherList.add(apiService.getEquipment(158));
			}
			if (classSelection == 2){
				otherList.add(apiService.getEquipment(157));
				otherList.add(apiService.getEquipment(184));
			}
			if (classSelection == 3){
				otherList.add(apiService.getEquipment(159));
				otherList.add(apiService.getEquipment(58));
			}
			if (classSelection == 4){
				otherList.add(apiService.getEquipment(158));
				otherList.add(apiService.getEquipment(90));
			}
			if (classSelection == 5){
				otherList.add(apiService.getEquipment(156));
			}
			if (classSelection == 6){
				otherList.add(apiService.getEquipment(158));
			}
			if (classSelection == 7){
				otherList.add(apiService.getEquipment(159));
				otherList.add(apiService.getEquipment(134));
			}
			if (classSelection == 8){
				otherList.add(apiService.getEquipment(158));
			}
			if (classSelection == 9){
				otherList.add(apiService.getEquipment(191));
				otherList.add(apiService.getEquipment(154));
			}
			if (classSelection == 10){
				otherList.add(apiService.getEquipment(61));
				otherList.add(apiService.getEquipment(156));
			}
			if (classSelection == 11){
				otherList.add(apiService.getEquipment(60));
				otherList.add(apiService.getEquipment(160));
			}
			if (classSelection == 12){
				otherList.add(apiService.getEquipment(145));
				otherList.add(apiService.getEquipment(64));
				otherList.add(apiService.getEquipment(160));
			}
			return otherList;

}
	
	public Integer calculateAC(Integer classSelection, DndCharacter dndCharacter, List<Equipment> armorList) {
		Integer aC = 10;
		if(armorList.size()>0) {
			for(int i=0;i<armorList.size();i++) {
				Equipment item = armorList.get(i);
				if(item.getArmorCategory().equals("Shield")){
					aC+=item.getArmorClass().getBase();
				}else if(!item.getArmorClass().getDexBonus()){
					aC+=(item.getArmorClass().getBase()-10);
				}else if(item.getArmorClass().getDexBonus() &&  item.getArmorClass().getMaxBonus()==null){
					aC+=item.getArmorClass().getBase() - 10 + statSetter.calculateBonus(dndCharacter.getDexterity());
				} else if(item.getArmorClass().getDexBonus() &&  item.getArmorClass().getMaxBonus()!=null && statSetter.calculateBonus(dndCharacter.getDexterity())<item.getArmorClass().getMaxBonus()){
					aC+=item.getArmorClass().getBase() - 10 + statSetter.calculateBonus(dndCharacter.getDexterity());
				}else {
					aC+=(item.getArmorClass().getBase() - 10 + item.getArmorClass().getMaxBonus());
				}
			}
		}else if(classSelection == 1){
			aC+=statSetter.calculateBonus(dndCharacter.getDexterity())+statSetter.calculateBonus(dndCharacter.getConstitution());
		}else if (classSelection==6) {
			aC+=statSetter.calculateBonus(dndCharacter.getDexterity())+statSetter.calculateBonus(dndCharacter.getWisdom());
		}else if(classSelection==10||classSelection==12) {
			aC+=statSetter.calculateBonus(dndCharacter.getDexterity());
		}
		return aC;
	}
	
	public List<Equipment> setWeaponStats(List<Equipment> weaponList, DndCharacter dndCharacter){
		for(int i=0;i<weaponList.size();i++) {
			List<String> weaponPropertyNames = new ArrayList<>();
			List<PropertyItem> weaponPropertyItems = weaponList.get(i).getProperties();
			for(int j=0;j<weaponPropertyItems.size();j++) {
				weaponPropertyNames.add(weaponPropertyItems.get(j).getName());
			}
			if(weaponList.get(i).getWeaponRange().equals("Ranged") || weaponPropertyNames.contains("Finesse")) {
				weaponList.get(i).setAtkBonus(statSetter.calculateBonus(dndCharacter.getDexterity()) + 2);
				weaponList.get(i).setDmgBonus(statSetter.calculateBonus(dndCharacter.getDexterity()));
			}else {
				weaponList.get(i).setAtkBonus(statSetter.calculateBonus(dndCharacter.getStrength())+2);
				weaponList.get(i).setDmgBonus(statSetter.calculateBonus(dndCharacter.getStrength()));
			}
		}
		return weaponList;
	}
	
	public List<Spell> getAllClassSpellsByLevel(DndCharacter dndCharacter, Integer level){
		String charClass = dndCharacter.getClassDetail().getName();
		List<Spell> allSpells = apiService.getAllSpells();
		List<Spell> mySpells = new ArrayList<>();
		for(int i=0;i<allSpells.size();i++) {
			List<ClassListItem> classItems = allSpells.get(i).getClasses();
			List<String> classes = new ArrayList<>();
			for(int j=0;j<classItems.size();j++) {classes.add(classItems.get(j).getName());}
			if(allSpells.get(i).getLevel()==level && classes.contains(charClass)) {
				mySpells.add(allSpells.get(i));
			}
		}
		return mySpells;
	}
	public List<Spell> chooseCantrips(DndCharacter dndCharacter){
		Random rand = new Random();
		List<Spell> classCantrips = getAllClassSpellsByLevel(dndCharacter, 0);
		List<Spell> myCantrips = new ArrayList<>();
		if(dndCharacter.getClassDetail().getIndex()==2) {
			for(int i=0;i<2;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==3) {
			for(int i=0;i<3;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==4) {
			for(int i=0;i<2;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==10) {
			for(int i=0;i<4;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==11) {
			for(int i=0;i<2;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==12) {
			for(int i=0;i<3;i++) {
				int selection = rand.nextInt(classCantrips.size());
				myCantrips.add(classCantrips.get(selection));
				classCantrips.remove(selection);
			}
		}
		else {
			Spell noSpell = new Spell();
			noSpell.setName("none");
			myCantrips.add(noSpell);
		}
		return myCantrips;
	}
	
	public List<Spell> chooseFirstLevelSpells(DndCharacter dndCharacter){
		Random rand = new Random();
		List<Spell> classFirstLvls = getAllClassSpellsByLevel(dndCharacter, 1);
		List<Spell> myFirstLvls = new ArrayList<>();
		if(dndCharacter.getClassDetail().getIndex()==2) {
			for(int i=0;i<4;i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==3) {
			for(int i=0;i<(1+statSetter.calculateBonus(dndCharacter.getWisdom()));i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==4) {
			for(int i=0;i<(1+statSetter.calculateBonus(dndCharacter.getWisdom()));i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==10) {
			for(int i=0;i<2;i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==11) {
			for(int i=0;i<2;i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else if(dndCharacter.getClassDetail().getIndex()==12) {
			for(int i=0;i<6;i++) {
				int selection = rand.nextInt(classFirstLvls.size());
				myFirstLvls.add(classFirstLvls.get(selection));
				classFirstLvls.remove(selection);
			}
		}
		else {
			Spell noSpell = new Spell();
			noSpell.setName("none");
			myFirstLvls.add(noSpell);
		}
		return myFirstLvls;
	}
	
	public SpellInfo getSpellcastingInfo(DndCharacter dndCharacter) {
		SpellInfo spellInfo = new SpellInfo();
		if(dndCharacter.getClassDetail().getIndex()==2) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setSpellcastingAbility("CHA");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setFirstLevelSlots(2);
		}
		else if(dndCharacter.getClassDetail().getIndex()==3) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getWisdom()));
			spellInfo.setSpellcastingAbility("WIS");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getWisdom()));
			spellInfo.setFirstLevelSlots(2);
		}
		else if(dndCharacter.getClassDetail().getIndex()==4) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getWisdom()));
			spellInfo.setSpellcastingAbility("WIS");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getWisdom()));
			spellInfo.setFirstLevelSlots(2);
		}
		else if(dndCharacter.getClassDetail().getIndex()==10) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setSpellcastingAbility("CHA");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setFirstLevelSlots(2);
		}
		else if(dndCharacter.getClassDetail().getIndex()==11) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setSpellcastingAbility("CHA");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getCharisma()));
			spellInfo.setFirstLevelSlots(1);
		}
		else if(dndCharacter.getClassDetail().getIndex()==12) {
			spellInfo.setSpellAttackModifier(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));
			spellInfo.setSpellcastingAbility("INT");
			spellInfo.setSpellSaveDc(8+2+statSetter.calculateBonus(dndCharacter.getIntelligence()));
			spellInfo.setFirstLevelSlots(2);
		}
		else {
			spellInfo.setSpellAttackModifier(0);
			spellInfo.setSpellcastingAbility("N/A");
			spellInfo.setSpellSaveDc(0);
			spellInfo.setFirstLevelSlots(0);
		}
		
		return spellInfo;
	}
	
}
