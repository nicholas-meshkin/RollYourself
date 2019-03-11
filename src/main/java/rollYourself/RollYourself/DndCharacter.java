package rollYourself.RollYourself;

import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.SubraceDetail;

public class DndCharacter {
	private String name;
	private String characterClass;
	private String race;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private RaceDetail raceDetail;
	private SubraceDetail subraceDetail;
	private ClassDetail classDetail;
	private final String characteristicSTR = "Strength";
	private final String characteristicDEX = "Dexterity";
	private final String characteristicCON = "Constitution";
	private final String characteristicINT = "Intelligence";
	private final String characteristicWIS = "Wisdom";
	private final String characteristicCHA = "Charisma";
	
	public DndCharacter() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCharacteristicSTR() {
		return characteristicSTR;
	}
	public String getCharacteristicDEX() {
		return characteristicDEX;
	}
	public String getCharacteristicCON() {
		return characteristicCON;
	}
	public String getCharacteristicINT() {
		return characteristicINT;
	}
	public String getCharacteristicWIS() {
		return characteristicWIS;
	}
	public String getCharacteristicCHA() {
		return characteristicCHA;
	}
	public RaceDetail getRaceDetail() {
		return raceDetail;
	}
	public void setRaceDetail(RaceDetail raceDetail) {
		this.raceDetail = raceDetail;
	}
	public ClassDetail getClassDetail() {
		return classDetail;
	}
	public void setClassDetail(ClassDetail classDetail) {
		this.classDetail = classDetail;
	}
	public SubraceDetail getSubraceDetail() {
		return subraceDetail;
	}
	public void setSubraceDetail(SubraceDetail subraceDetail) {
		this.subraceDetail = subraceDetail;
	}	
}