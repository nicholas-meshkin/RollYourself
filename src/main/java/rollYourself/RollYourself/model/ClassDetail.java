package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassDetail {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	@JsonProperty("hit_die")
	private Integer hitDie;
	@JsonProperty("proficiency_choices")
	private List<ProficiencyChoices> proficiencyChoices;
	private List<ProficiencyItem> proficiencies;
	@JsonProperty("saving_throws")
	private List<AbilityScoreItem> savingThrows;
	@JsonProperty("starting_equipment")
	private StartingEquipment startingEquipment;
	@JsonProperty("class_levels")
	private ClassLevels classLevels;
	private List<SubclassItem> subclasses;
	private SpellcastingItem spellcasting;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHitDie() {
		return hitDie;
	}
	public void setHitDie(Integer hitDie) {
		this.hitDie = hitDie;
	}
	public List<ProficiencyChoices> getProficiencyChoices() {
		return proficiencyChoices;
	}
	public void setProficiencyChoices(List<ProficiencyChoices> proficiencyChoices) {
		this.proficiencyChoices = proficiencyChoices;
	}
	public List<ProficiencyItem> getProficiencies() {
		return proficiencies;
	}
	public void setProficiencies(List<ProficiencyItem> proficiencies) {
		this.proficiencies = proficiencies;
	}
	public List<AbilityScoreItem> getSavingThrows() {
		return savingThrows;
	}
	public void setSavingThrows(List<AbilityScoreItem> savingThrows) {
		this.savingThrows = savingThrows;
	}
	public StartingEquipment getStartingEquipment() {
		return startingEquipment;
	}
	public void setStartingEquipment(StartingEquipment startingEquipment) {
		this.startingEquipment = startingEquipment;
	}
	public ClassLevels getClassLevels() {
		return classLevels;
	}
	public void setClassLevels(ClassLevels classLevels) {
		this.classLevels = classLevels;
	}
	public List<SubclassItem> getSubclasses() {
		return subclasses;
	}
	public void setSubclasses(List<SubclassItem> subclasses) {
		this.subclasses = subclasses;
	}
	public SpellcastingItem getSpellcasting() {
		return spellcasting;
	}
	public void setSpellcasting(SpellcastingItem spellcasting) {
		this.spellcasting = spellcasting;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ClassDetail [id=" + id + ", index=" + index + ", name=" + name + ", hitDie=" + hitDie
				+ ", proficiencyChoices=" + proficiencyChoices + ", proficiencies=" + proficiencies + ", savingThrows="
				+ savingThrows + ", startingEquipment=" + startingEquipment + ", classLevels=" + classLevels
				+ ", subclasses=" + subclasses + ", spellcasting=" + spellcasting + ", url=" + url + "]";
	}
	
}
