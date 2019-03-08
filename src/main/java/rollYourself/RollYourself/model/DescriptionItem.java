package rollYourself.RollYourself.model;

import java.util.List;

public class DescriptionItem {

	//there are multiple strings in the list returned by the json separated by commas
	private List <String> desc;
	private String name;
	public List<String> getDesc() {
		return desc;
	}
	public void setDesc(List<String> desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DescriptionItem [desc=" + desc + ", name=" + name + "]";
	}
	
}
