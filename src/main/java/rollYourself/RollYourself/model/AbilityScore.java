package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityScore {

	@JsonProperty
	private String id;
	private Integer index;
	private String name;
	@JsonProperty("full_name")
	private String fullName;
	private List<String> desc;
	private List<SkillItem> skills;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<String> getDesc() {
		return desc;
	}
	public void setDesc(List<String> desc) {
		this.desc = desc;
	}
	public List<SkillItem> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillItem> skills) {
		this.skills = skills;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "AbilityScore [id=" + id + ", index=" + index + ", name=" + name + ", fullName=" + fullName + ", desc="
				+ desc + ", skills=" + skills + ", url=" + url + "]";
	}
	
}
