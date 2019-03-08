package rollYourself.RollYourself.model;

public class AbilityScoreItem {

	private String url;
	private String name;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AbilityScoreItem [url=" + url + ", name=" + name + "]";
	}
	
}
