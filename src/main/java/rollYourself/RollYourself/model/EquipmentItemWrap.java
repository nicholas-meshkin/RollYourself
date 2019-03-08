package rollYourself.RollYourself.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentItemWrap {

	private Integer quantity;
	@JsonProperty("item")
	private EquipmentItem EquipmentItem;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public EquipmentItem getEquipmentItem() {
		return EquipmentItem;
	}
	public void setEquipmentItem(EquipmentItem EquipmentItem) {
		this.EquipmentItem = EquipmentItem;
	}
	@Override
	public String toString() {
		return "EquipmentItemWrap [quantity=" + quantity + ", EquipmentItem=" + EquipmentItem
				+ "]";
	}
	
}
