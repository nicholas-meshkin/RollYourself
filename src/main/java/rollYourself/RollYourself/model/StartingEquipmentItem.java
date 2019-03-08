package rollYourself.RollYourself.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartingEquipmentItem {

	private String url;
	@JsonProperty("class")
	private String charClass;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCharClass() {
		return charClass;
	}
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}
	@Override
	public String toString() {
		return "StartingEquipment [url=" + url + ", charClass=" + charClass + "]";
	}
	
}
