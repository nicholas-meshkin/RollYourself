package rollYourself.RollYourself;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rollYourself.RollYourself.model.ProficiencyItem;

@Component
public class SkillSetter {

	@Autowired
	StatSetter statSetter;
	
	public List<ProficiencyItem> rollClassSkillProfs(DndCharacter dndCharacter){
		List<ProficiencyItem> choices = dndCharacter.getClassDetail().getProfChoiceByIndex(0).getFrom();
		List<ProficiencyItem> chosen = new ArrayList<>();
		Integer numChoices = dndCharacter.getClassDetail().getProfChoiceByIndex(0).getChoose();
		Random rand = new Random();
		for(int i=0; i<numChoices;i++) {
			int roll = rand.nextInt(choices.size());
			chosen.add(choices.get(roll));
			choices.remove(roll);
		}
		return chosen;
	}
	
	public List<Integer> setSkills(DndCharacter dndCharacter){
		List<ProficiencyItem> profs = rollClassSkillProfs(dndCharacter);
		List<String> profNames = new ArrayList<>();
		for(ProficiencyItem item: profs) {
			profNames.add(item.getName());
		}
		List<Integer> skills = new ArrayList<>();
		if(profNames.contains("Skill: Acrobatics")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Skill: Animal Handling")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Skill: Arcana")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Skill: Athletics")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getStrength()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getStrength()));}
		if(profNames.contains("Skill: Deception")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Skill: History")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Skill: Insight")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Skill: Intimidation")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Skill: Investigation")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Skill: Medicine")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Skill: Nature")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Skill: Perception")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		if(profNames.contains("Skill: Performance")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Skill: Persuasion")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getCharisma()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getCharisma()));}
		if(profNames.contains("Skill: Religion")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getIntelligence()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getIntelligence()));}
		if(profNames.contains("Skill: Sleight of Hand")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Skill: Stealth")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getDexterity()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getDexterity()));}
		if(profNames.contains("Skill: Survival")) {skills.add(2+statSetter.calculateBonus(dndCharacter.getWisdom()));}else {skills.add(statSetter.calculateBonus(dndCharacter.getWisdom()));}
		return skills;
	}
}
