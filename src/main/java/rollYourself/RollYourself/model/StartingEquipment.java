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
}
