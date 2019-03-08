package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skill {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	private List<String> desc;
	@JsonProperty("ability_score")
	private AbilityScoreItem abilityScore;
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
	public List<String> getDesc() {
		return desc;
	}
	public void setDesc(List<String> desc) {
		this.desc = desc;
	}
	public AbilityScoreItem getAbilityScore() {
		return abilityScore;
	}
	public void setAbilityScore(AbilityScoreItem abilityScore) {
		this.abilityScore = abilityScore;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", index=" + index + ", name=" + name + ", desc=" + desc + ", abilityScore="
				+ abilityScore + ", url=" + url + "]";
	}
	
}
