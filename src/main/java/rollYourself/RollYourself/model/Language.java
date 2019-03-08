package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	private String type;
	@JsonProperty("typical_speakers")
	private List<String> typicalSpeakers;
	private String script;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getTypicalSpeakers() {
		return typicalSpeakers;
	}
	public void setTypicalSpeakers(List<String> typicalSpeakers) {
		this.typicalSpeakers = typicalSpeakers;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", index=" + index + ", name=" + name + ", type=" + type + ", typicalSpeakers="
				+ typicalSpeakers + ", script=" + script + ", url=" + url + "]";
	}
	
}
