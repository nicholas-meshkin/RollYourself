package rollYourself.RollYourself.model;

public class ProficiencyItem {

	private String name;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ProficiencyItem [name=" + name + ", url=" + url + "]";
	}
	
}
