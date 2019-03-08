package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartingEquipment {

	@JsonProperty("_id")
	private String id;
	private Integer index;
	@JsonProperty("starting_equipment")
	private List<EquipmentItemWrap> startingEquipment;
	@JsonProperty("choices_to_make")
	private Integer choicesToMake;
	@JsonProperty
	("choice_1")
	private List<EquipmentChoice> choice1;
	@JsonProperty
	("choice_2")
	private List<EquipmentChoice> choice2;
	@JsonProperty
	("choice_3")
	private List<EquipmentChoice> choice3;
	private String url;
	@JsonProperty("class")
	private ClassListItem classListItem;
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
	public List<EquipmentItemWrap> getStartingEquipment() {
		return startingEquipment;
	}
	public void setStartingEquipment(List<EquipmentItemWrap> startingEquipment) {
		this.startingEquipment = startingEquipment;
	}
	public Integer getChoicesToMake() {
		return choicesToMake;
	}
	public void setChoicesToMake(Integer choicesToMake) {
		this.choicesToMake = choicesToMake;
	}
	public List<EquipmentChoice> getChoice1() {
		return choice1;
	}
	public void setChoice1(List<EquipmentChoice> choice1) {
		this.choice1 = choice1;
	}
	public List<EquipmentChoice> getChoice2() {
		return choice2;
	}
	public void setChoice2(List<EquipmentChoice> choice2) {
		this.choice2 = choice2;
	}
	public List<EquipmentChoice> getChoice3() {
		return choice3;
	}
	public void setChoice3(List<EquipmentChoice> choice3) {
		this.choice3 = choice3;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ClassListItem getClassListItem() {
		return classListItem;
	}
	public void setClassListItem(ClassListItem classListItem) {
		this.classListItem = classListItem;
	}
	@Override
	public String toString() {
		return "StartingEquipment [id=" + id + ", index=" + index + ", startingEquipment=" + startingEquipment
				+ ", choicesToMake=" + choicesToMake + ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3="
				+ choice3 + ", url=" + url + ", classListItem=" + classListItem + "]";
	}
	
}
