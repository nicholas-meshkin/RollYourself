package rollYourself.RollYourself.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArmorClass {

	private Integer base;
	@JsonProperty("dex_bonus")
	private Boolean dexBonus;
	@JsonProperty("max_bonus")
	private Integer maxBonus;
	public Integer getBase() {
		return base;
	}
	public void setBase(Integer base) {
		this.base = base;
	}
	public Boolean getDexBonus() {
		return dexBonus;
	}
	public void setDexBonus(Boolean dexBonus) {
		this.dexBonus = dexBonus;
	}
	public Integer getMaxBonus() {
		return maxBonus;
	}
	public void setMaxBonus(Integer maxBonus) {
		this.maxBonus = maxBonus;
	}
	@Override
	public String toString() {
		return "ArmorClass [base=" + base + ", dexBonus=" + dexBonus + ", maxBonus=" + maxBonus + "]";
	}
	
}
