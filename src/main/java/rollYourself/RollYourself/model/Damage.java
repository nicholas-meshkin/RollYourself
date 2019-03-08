package rollYourself.RollYourself.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Damage {

	@JsonProperty("dice_count")
	private Integer diceCount;
	@JsonProperty("dice_value")
	private Integer diceValue;
	private DamageTypeItem damageTypeItem;
	public Integer getDiceCount() {
		return diceCount;
	}
	public void setDiceCount(Integer diceCount) {
		this.diceCount = diceCount;
	}
	public Integer getDiceValue() {
		return diceValue;
	}
	public void setDiceValue(Integer diceValue) {
		this.diceValue = diceValue;
	}
	public DamageTypeItem getDamageTypeItem() {
		return damageTypeItem;
	}
	public void setDamageTypeItem(DamageTypeItem damageTypeItem) {
		this.damageTypeItem = damageTypeItem;
	}
	@Override
	public String toString() {
		return "Damage [diceCount=" + diceCount + ", diceValue=" + diceValue + ", damageTypeItem=" + damageTypeItem
				+ "]";
	}
	
}
