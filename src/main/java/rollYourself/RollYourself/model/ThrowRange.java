package rollYourself.RollYourself.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ThrowRange {

	private Integer normal;
	@JsonProperty("long")
	private Integer longR;
	public Integer getNormal() {
		return normal;
	}
	public void setNormal(Integer normal) {
		this.normal = normal;
	}
	public Integer getLongR() {
		return longR;
	}
	public void setLongR(Integer longR) {
		this.longR = longR;
	}
	@Override
	public String toString() {
		return "ThrowRange [normal=" + normal + ", longR=" + longR + "]";
	}
	
}
