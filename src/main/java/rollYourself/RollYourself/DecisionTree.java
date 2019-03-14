package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.dao.QuestionResponsesDao;
import rollYourself.RollYourself.dao.SpellsDao;
import rollYourself.RollYourself.model.ClassListItem;
import rollYourself.RollYourself.model.DescriptionItem;
import rollYourself.RollYourself.model.Equipment;
import rollYourself.RollYourself.model.ProficiencyItem;
import rollYourself.RollYourself.model.PropertyItem;
import rollYourself.RollYourself.model.QuestionResponses;
import rollYourself.RollYourself.model.SkillItem;
import rollYourself.RollYourself.model.Spell;
import rollYourself.RollYourself.model.SpellInfo;
import rollYourself.RollYourself.model.Spellcasting;

@Component
public class DecisionTree {

	@Autowired 
	private ApiService apiService;
	
	@Autowired
	private StatSetter statSetter;
	
	@Autowired
	private SpellsDao spellsDao;
	
	@Autowired
	QuestionResponsesDao questionResponsesDao;
	
	public Integer selectRace(DndCharacter dndCharacter) {
		Integer raceSelection = 0;
		
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 1;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 2;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 4;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (dndCharacter.getQ1Response() == 3) && (dndCharacter.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (dndCharacter.getQ1Response() == 1) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 8;}
		if ( (dndCharacter.getQ1Response() == 2) && (dndCharacter.getQ2Response() == 1) ) {raceSelection = 9;}
		return raceSelection;
	}
	
	public Integer selectRace(Long id) {
		QuestionResponses questionResponses = questionResponsesDao.findById(id);
		Integer raceSelection = 0;
	
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 1;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 2;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 3;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 4;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 5;}
		if ( (questionResponses.getQ1Response() == 3) && (questionResponses.getQ2Response() == 3) ) {raceSelection = 6;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 2) ) {raceSelection = 7;}
		if ( (questionResponses.getQ1Response() == 1) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 8;}
		if ( (questionResponses.getQ1Response() == 2) && (questionResponses.getQ2Response() == 1) ) {raceSelection = 9;}
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
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 2;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 3;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 4;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 5;}
		if ( (dndCharacter.getQ3Response() == 1) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 6;}
		if ( (dndCharacter.getQ3Response() == 4) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 7;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 8;}
		if ( (dndCharacter.getQ3Response() == 2) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 9;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 1) ) {classSelection = 10;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 2) ) {classSelection = 11;}
		if ( (dndCharacter.getQ3Response() == 3) && (dndCharacter.getQ4Response() == 3) ) {classSelection = 12;}
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
//		List<Spell> allSpells = apiService.getAllSpells();
		List<SpellsDetails> list= spellsDao.findByClassAndLevel(charClass, level);
		List<Spell> mySpells = new ArrayList<>();
		for(SpellsDetails i : list) {
			mySpells.add(apiService.getSpellDetail(i.getId()));
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
	
	public Spellcasting getSpellcasting(DndCharacter dndCharacter) {
		Spellcasting spellcasting = new Spellcasting();
		if(dndCharacter.getClassDetail().getName().equals("Bard")) {spellcasting = apiService.getSpellcastingDetail(1);}
		else if(dndCharacter.getClassDetail().getName().equals("Cleric")) {spellcasting = apiService.getSpellcastingDetail(2);}
		else if(dndCharacter.getClassDetail().getName().equals("Druid")) {spellcasting = apiService.getSpellcastingDetail(3);}
		else if(dndCharacter.getClassDetail().getName().equals("Sorcerer")) {spellcasting = apiService.getSpellcastingDetail(6);}
		else if(dndCharacter.getClassDetail().getName().equals("Warlock")) {spellcasting = apiService.getSpellcastingDetail(7);}
		else if(dndCharacter.getClassDetail().getName().equals("Wizard")) {spellcasting = apiService.getSpellcastingDetail(8);}
		else {
			List<DescriptionItem> info = new ArrayList<>();
			List<String> noInfo = new ArrayList<>();
			DescriptionItem blank = new DescriptionItem();
			noInfo.add("N/A");
			blank.setDesc(noInfo);
			blank.setName("N/A");
			info.add(blank);info.add(blank);info.add(blank);info.add(blank);info.add(blank);info.add(blank);
			spellcasting.setInfo(info);
			}
		return spellcasting;
	}
	
	public List<String> chooseProfs(DndCharacter dndCharacter){
		List<String> chosen = new ArrayList<>();
		List<SkillItem> skills = apiService.getSkillList();
		if(dndCharacter.getClassDetail().getIndex()==1) {
			if((dndCharacter.getQ5Response() == 1)){
				chosen.add(skills.get(1).getName());
			}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(10).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(17).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(7).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(11).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==2) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(1).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(17).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(10).getName());}
			if((dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(11).getName());}
			if(((dndCharacter.getQ5Response() == 1) || (dndCharacter.getQ5Response() == 2)) && ((dndCharacter.getQ6Response() == 1) || (dndCharacter.getQ6Response() == 2))) {
				chosen.add(skills.get(16).getName());
			}
			if(((dndCharacter.getQ5Response() == 1) || (dndCharacter.getQ5Response() == 2)) && ((dndCharacter.getQ6Response() == 3) || (dndCharacter.getQ6Response() == 4))) {
				chosen.add(skills.get(4).getName());
			}
			if(((dndCharacter.getQ5Response() == 3) || (dndCharacter.getQ5Response() == 4)) && ((dndCharacter.getQ6Response() == 1) || (dndCharacter.getQ6Response() == 2))) {
				chosen.add(skills.get(13).getName());
			}
			if(((dndCharacter.getQ5Response() == 3) || (dndCharacter.getQ5Response() == 4)) && ((dndCharacter.getQ6Response() == 3) || (dndCharacter.getQ6Response() == 4))) {
				chosen.add(skills.get(12).getName());
			}
		}
		if(dndCharacter.getClassDetail().getIndex()==3) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(13).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(14).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==4) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(1).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(10).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(17).getName());}
			if((dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(2).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(11).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(14).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==5) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(7).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(11).getName());}
			if((dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(0).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(1).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(17).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==6) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(0).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(16).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(14).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==7) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(7).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(14).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==8) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(1).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(10).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(17).getName());}
			if((dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(8).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(11).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(16).getName());}
			if(((dndCharacter.getQ5Response() == 1) || (dndCharacter.getQ5Response() == 2)) && ((dndCharacter.getQ6Response() == 1) || (dndCharacter.getQ6Response() == 2))) {
				chosen.add(skills.get(17).getName());
			}
			if(((dndCharacter.getQ5Response() == 1) || (dndCharacter.getQ5Response() == 2)) && ((dndCharacter.getQ6Response() == 3) || (dndCharacter.getQ6Response() == 4))) {
				chosen.add(skills.get(9).getName());
			}
			if(((dndCharacter.getQ5Response() == 3) || (dndCharacter.getQ5Response() == 4)) && ((dndCharacter.getQ6Response() == 1) || (dndCharacter.getQ6Response() == 2))) {
				chosen.add(skills.get(16).getName());
			}
			if(((dndCharacter.getQ5Response() == 3) || (dndCharacter.getQ5Response() == 4)) && ((dndCharacter.getQ6Response() == 3) || (dndCharacter.getQ6Response() == 4))) {
				chosen.add(skills.get(11).getName());
			}
		}
		if(dndCharacter.getClassDetail().getIndex()==9) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(3).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(8).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(13).getName());}
			if((dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(0).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(4).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(11).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(8).getName());}
			if((dndCharacter.getQ5Response() == 1) || (dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(12).getName());}
			if((dndCharacter.getQ5Response() == 3) || (dndCharacter.getQ5Response() == 4)){chosen.add(skills.get(15).getName());}
			chosen.add(skills.get(16).getName());
		}
		if(dndCharacter.getClassDetail().getIndex()==10) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(7).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(13).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(2).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(14).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(4).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==11) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(7).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(10).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(2).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(4).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(14).getName());}
			if((dndCharacter.getQ6Response() == 4)){chosen.add(skills.get(8).getName());}
		}
		if(dndCharacter.getClassDetail().getIndex()==12) {
			if((dndCharacter.getQ5Response() == 1)){chosen.add(skills.get(6).getName());}
			if((dndCharacter.getQ5Response() == 2)){chosen.add(skills.get(5).getName());}
			if((dndCharacter.getQ5Response() == 3)){chosen.add(skills.get(9).getName());}
			if((dndCharacter.getQ6Response() == 1)){chosen.add(skills.get(2).getName());}
			if((dndCharacter.getQ6Response() == 2)){chosen.add(skills.get(14).getName());}
			if((dndCharacter.getQ6Response() == 3)){chosen.add(skills.get(8).getName());}
		}
		return chosen;
	}
	
	public String selectAlignment(DndCharacter dndCharacter) {
		String alignment = "";
		if(dndCharacter.getQ7Response() == 2 && (dndCharacter.getQ8Response() == 2)){
			alignment = "True Neutral";
			return alignment;
		}
		if(dndCharacter.getQ8Response() == 1) {alignment += "Lawful";
		}else if(dndCharacter.getQ8Response() == 2) {alignment += "Neutral";
		}else if(dndCharacter.getQ8Response() == 3) {alignment += "Chaotic";}
		
		if(dndCharacter.getQ7Response() == 1) {alignment += " Good";
		}else if(dndCharacter.getQ7Response() == 2) {alignment += " Neutral";
		}else if(dndCharacter.getQ7Response() == 3) {alignment += " Evil";}
		return alignment;
	}
	
	public String selectPage2(Integer classSelection){
		String page2 = "questionnaire-page-2-";
			if (classSelection == 1){page2 += "barbarian";}
			if (classSelection == 2){page2 += "bard";}
			if (classSelection == 3){page2 += "cleric";}
			if (classSelection == 4){page2 += "druid";}
			if (classSelection == 5){page2 += "fighter";}
			if (classSelection == 6){page2 += "monk";}
			if (classSelection == 7){page2 += "paladin";}
			if (classSelection == 8){page2 += "ranger";}
			if (classSelection == 9){page2 += "rogue";}
			if (classSelection == 10){page2 += "sorcerer";}
			if (classSelection == 11){page2 += "warlock";}
			if (classSelection == 12){page2 += "wizard";}
			return page2;
	}
	
	public void spellsDB() {
		List<Spell> allSpells = apiService.getAllSpells();
		for(Spell i : allSpells) {
			SpellsDetails x = new SpellsDetails();
			x.setLevel(i.getLevel());
			List<String> y = new ArrayList<>();
			List<ClassListItem> z = i.getClasses();
			String classes = "";
			for(int j=0;j<z.size();j++) {
				y.add(z.get(j).getName());
			}
			for(int h=0;h<y.size();h++) {
				classes += y.get(h) + " ";
			}
			x.setId(i.getIndex());
			x.setClasses(classes);
			x.setName(i.getName());
//			System.out.println(x);
			spellsDao.create(x);
		}
	}
}
