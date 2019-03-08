package rollYourself.RollYourself.model;

public class Cost {

	private Integer quantity;
	private String unit;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Cost [quantity=" + quantity + ", unit=" + unit + "]";
	}
	
}
