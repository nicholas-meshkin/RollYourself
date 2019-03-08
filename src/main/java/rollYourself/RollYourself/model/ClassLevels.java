package rollYourself.RollYourself.model;

public class ClassLevels {

	private String url;
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
		return "ClassLevels [url=" + url + ", charClass=" + charClass + "]";
	}
	
}
