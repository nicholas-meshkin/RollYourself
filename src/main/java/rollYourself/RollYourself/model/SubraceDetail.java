package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubraceDetail {
	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	private RaceItem race;
	private String desc;
	@JsonProperty("ability_bonuses")
	private List<Integer> abilityBonuses;
	@JsonProperty("starting_proficiencies")
	private List<ProficiencyItem> startingProficiencies;
	//spot for language list but is empty
	@JsonProperty("racial_traits")
	private List<TraitItem> racialTraits;
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
	public RaceItem getRace() {
		return race;
	}
	public void setRace(RaceItem race) {
		this.race = race;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Integer> getAbilityBonuses() {
		return abilityBonuses;
	}
	public void setAbilityBonuses(List<Integer> abilityBonuses) {
		this.abilityBonuses = abilityBonuses;
	}
	public List<ProficiencyItem> getStartingProficiencies() {
		return startingProficiencies;
	}
	public void setStartingProficiencies(List<ProficiencyItem> startingProficiencies) {
		this.startingProficiencies = startingProficiencies;
	}
	public List<TraitItem> getRacialTraits() {
		return racialTraits;
	}
	public void setRacialTraits(List<TraitItem> racialTraits) {
		this.racialTraits = racialTraits;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "SubraceDetail [id=" + id + ", index=" + index + ", name=" + name + ", race=" + race + ", desc=" + desc
				+ ", abilityBonuses=" + abilityBonuses + ", startingProficiencies=" + startingProficiencies
				+ ", racialTraits=" + racialTraits + ", url=" + url + "]";
	}

}
