package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Spell {
	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	private List<String> desc;
	private String page;
	private String range;
	private List<String> components;
	private String ritual;
	private String duration;
	private String concentration;
	@JsonProperty("casting_time")
	private String castingTime;
	private Integer level;
	private SchoolItem school;
	private List<ClassListItem> classes;
	private List<SubclassItem> subclasses;
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public List<String> getComponents() {
		return components;
	}
	public void setComponents(List<String> components) {
		this.components = components;
	}
	public String getRitual() {
		return ritual;
	}
	public void setRitual(String ritual) {
		this.ritual = ritual;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getCastingTime() {
		return castingTime;
	}
	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public SchoolItem getSchool() {
		return school;
	}
	public void setSchool(SchoolItem school) {
		this.school = school;
	}
	public List<ClassListItem> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassListItem> classes) {
		this.classes = classes;
	}
	public List<SubclassItem> getSubclasses() {
		return subclasses;
	}
	public void setSubclasses(List<SubclassItem> subclasses) {
		this.subclasses = subclasses;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Spell [id=" + id + ", index=" + index + ", name=" + name + ", desc=" + desc + ", page=" + page
				+ ", range=" + range + ", components=" + components + ", ritual=" + ritual + ", duration=" + duration
				+ ", concentration=" + concentration + ", castingTime=" + castingTime + ", level=" + level + ", school="
				+ school + ", classes=" + classes + ", subclasses=" + subclasses + ", url=" + url + "]";
	}

}
