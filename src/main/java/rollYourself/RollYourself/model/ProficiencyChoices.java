package rollYourself.RollYourself.model;

import java.util.List;

public class ProficiencyChoices {

	private List<ProficiencyItem> from;
	private String type;
	private Integer choose;
	public List<ProficiencyItem> getFrom() {
		return from;
	}
	public void setFrom(List<ProficiencyItem> from) {
		this.from = from;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getChoose() {
		return choose;
	}
	public void setChoose(Integer choose) {
		this.choose = choose;
	}
	@Override
	public String toString() {
		return "ProficiencyChoices [from=" + from + ", type=" + type + ", choose=" + choose + "]";
	}
	
}
