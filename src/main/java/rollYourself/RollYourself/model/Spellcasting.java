package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Spellcasting {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	private Integer level;
	@JsonProperty("spellcasting_ability")
	private AbilityScoreItem spellcastingAbility;
	private List<DescriptionItem> info;
	private String url;
	@JsonProperty("class")
	private ClassListItem charClass;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public AbilityScoreItem getSpellcastingAbility() {
		return spellcastingAbility;
	}
	public void setSpellcastingAbility(AbilityScoreItem spellcastingAbility) {
		this.spellcastingAbility = spellcastingAbility;
	}
	public List<DescriptionItem> getInfo() {
		return info;
	}
	public void setInfo(List<DescriptionItem> info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ClassListItem getCharClass() {
		return charClass;
	}
	public void setCharClass(ClassListItem charClass) {
		this.charClass = charClass;
	}
	@Override
	public String toString() {
		return "Spellcasting [id=" + id + ", index=" + index + ", level=" + level + ", spellcastingAbility="
				+ spellcastingAbility + ", info=" + info + ", url=" + url + ", charClass=" + charClass + "]";
	}
	
}
