package rollYourself.RollYourself.model;

public class SpellItem {

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
		return "SpellItem [name=" + name + ", url=" + url + "]";
	}
	
}
