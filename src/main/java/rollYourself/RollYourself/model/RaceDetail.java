package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RaceDetail {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	private Integer speed;
	@JsonProperty("ability_bonuses")
	private List<Integer> abilityBonuses;
	private String age;
	private String alignment;
	private String size;
	@JsonProperty("size_description")
	private String sizeDescription;
	@JsonProperty("starting_proficiencies")
	private List<ProficiencyItem> startingProficiencies;
	private List<LanguageItem> languages;
	@JsonProperty("language_desc")
	private String languageDescription;
	private List<TraitItem> traits;
	private List<SubraceItem> subraces;
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
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public List<Integer> getAbilityBonuses() {
		return abilityBonuses;
	}
	public void setAbilityBonuses(List<Integer> abilityBonuses) {
		this.abilityBonuses = abilityBonuses;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSizeDescription() {
		return sizeDescription;
	}
	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}
	public List<ProficiencyItem> getStartingProficiencies() {
		return startingProficiencies;
	}
	public void setStartingProficiencies(List<ProficiencyItem> startingProficiencies) {
		this.startingProficiencies = startingProficiencies;
	}
	public List<LanguageItem> getLanguages() {
		return languages;
	}
	public void setLanguages(List<LanguageItem> languages) {
		this.languages = languages;
	}
	public String getLanguageDescription() {
		return languageDescription;
	}
	public void setLanguageDescription(String languageDescription) {
		this.languageDescription = languageDescription;
	}
	public List<TraitItem> getTraits() {
		return traits;
	}
	public void setTraits(List<TraitItem> traits) {
		this.traits = traits;
	}
	public List<SubraceItem> getSubraces() {
		return subraces;
	}
	public void setSubraces(List<SubraceItem> subraces) {
		this.subraces = subraces;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "RaceDetail [id=" + id + ", index=" + index + ", name=" + name + ", speed=" + speed + ", abilityBonuses="
				+ abilityBonuses + ", age=" + age + ", alignment=" + alignment + ", size=" + size + ", sizeDescription="
				+ sizeDescription + ", startingProficiencies=" + startingProficiencies + ", languages=" + languages
				+ ", languageDescription=" + languageDescription + ", traits=" + traits + ", subraces=" + subraces
				+ ", url=" + url + "]";
	}
	
	
}
