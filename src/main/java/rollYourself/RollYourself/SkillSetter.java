package rollYourself.RollYourself;

//import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.model.ProficiencyItem;

//import rollYourself.RollYourself.model.ProficiencyItem;

@Component
public class SkillSetter {

	@Autowired
	StatSetter statSetter;
	
	@Autowired
	DecisionTree decisionTree;
	
//	public List<ProficiencyItem> rollClassSkillProfs(DndCharacter dndCharacter){
//		List<ProficiencyItem> choices = dndCharacter.getClassDetail().getProfChoiceByIndex(0).getFrom();
//		List<ProficiencyItem> chosen = new ArrayList<>();
//		Integer numChoices = dndCharacter.getClassDetail().getProfChoiceByIndex(0).getChoose();
//		Random rand = new Random();
//		for(int i=0; i<numChoices;i++) {
//			int roll = rand.nextInt(choices.size());
//			chosen.add(choices.get(roll));
//			choices.remove(roll);
//		}
//		return chosen;
//	}
	
//	public List<ProficiencyItem> getProfChoices(DndCharacter dndCharacter){
//		List<ProficiencyItem> chosen = decisionTree.chooseProfs(dndCharacter);
//		return chosen;
//	}
	
	public List<Integer> setSkills(DndCharacter dndCharacter){
		
		List<String> profNames = decisionTree.chooseProfs(dndCharacter);
		List<Integer> skills = new ArrayList<>();
		if(profNames.contains("Acrobatics")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Animal Handling")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Arcana")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Athletics")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getStrength()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getStrength()));}
		if(profNames.contains("Deception")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("History")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Insight")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Intimidation")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Investigation")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Medicine")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Nature")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Perception")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Performance")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Persuasion")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Religion")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Sleight of Hand")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Stealth")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Survival")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		return skills;
	}
}
