package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentChoice {

	@JsonProperty("from")
	private List<EquipmentItemWrap> equipChoice;
	private String type;
	private Integer choose;
	public List<EquipmentItemWrap> getEquipChoice() {
		return equipChoice;
	}
	public void setEquipChoice(List<EquipmentItemWrap> equipChoice) {
		this.equipChoice = equipChoice;
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
		return "EquipmentChoice [equipChoice=" + equipChoice + ", type=" + type + ", choose=" + choose + "]";
	}
	
	
}
