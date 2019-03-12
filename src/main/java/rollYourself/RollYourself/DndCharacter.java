package rollYourself.RollYourself;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import rollYourself.RollYourself.model.ClassDetail;
import rollYourself.RollYourself.model.RaceDetail;
import rollYourself.RollYourself.model.SubraceDetail;

//Mark all entity classes with @Entity so that Hibernate knows about them.
@Entity
@Table(name="dndcharacters")
public class DndCharacter {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String name;
	private String characterClass;
	private String race;
	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	@Transient
	private RaceDetail raceDetail;
	@Transient
	private SubraceDetail subraceDetail;
	@Transient
	private ClassDetail classDetail;
//	private final String characteristicSTR = "Strength";
//	private final String characteristicDEX = "Dexterity";
//	private final String characteristicCON = "Constitution";
//	private final String characteristicINT = "Intelligence";
//	private final String characteristicWIS = "Wisdom";
//	private final String characteristicCHA = "Charisma";
	
	private Integer q1Response;
	private Integer q2Response;
	private Integer q3Response;
	private Integer q4Response;
	private Integer q5Response;
	private Integer q6Response;

	

	public DndCharacter() {	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
//	public String getCharacteristicSTR() {
//		return characteristicSTR;
//	}
//	public String getCharacteristicDEX() {
//		return characteristicDEX;
//	}
//	public String getCharacteristicCON() {
//		return characteristicCON;
//	}
//	public String getCharacteristicINT() {
//		return characteristicINT;
//	}
//	public String getCharacteristicWIS() {
//		return characteristicWIS;
//	}
//	public String getCharacteristicCHA() {
//		return characteristicCHA;
//	}
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
	
	
	public Integer getQ1Response() {
		return q1Response;
	}
	public void setQ1Response(Integer q1Response) {
		this.q1Response = q1Response;
	}
	
	public Integer getQ2Response() {
		return q2Response;
	}
	public void setQ2Response(Integer q2Response) {
		this.q2Response = q2Response;
	}
	
	public Integer getQ3Response() {
		return q3Response;
	}
	public void setQ3Response(Integer q3Response) {
		this.q3Response = q3Response;
	}
	
	public Integer getQ4Response() {
		return q4Response;
	}
	public void setQ4Response(Integer q4Response) {
		this.q4Response = q4Response;
	}
	
	public Integer getQ5Response() {
		return q5Response;
	}
	public void setQ5Response(Integer q5Response) {
		this.q5Response = q5Response;
	}
	
	public Integer getQ6Response() {
		return q6Response;
	}
	public void setQ6Response(Integer q6Response) {
		this.q6Response = q6Response;
	}
	
	
}