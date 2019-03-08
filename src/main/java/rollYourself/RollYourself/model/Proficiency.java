package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Proficiency {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String type;
	private String name;
	private List<ClassListItem> classes;
	//Has a races field but can't find any that aren't empty
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ClassListItem> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassListItem> classes) {
		this.classes = classes;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Proficiency [id=" + id + ", index=" + index + ", type=" + type + ", name=" + name + ", classes="
				+ classes + ", url=" + url + "]";
	}
	
}
