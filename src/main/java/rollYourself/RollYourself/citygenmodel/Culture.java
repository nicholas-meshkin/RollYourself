package rollYourself.RollYourself.citygenmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Culture {
	@Id
	private Long id;
	private String culture;
	private Long regionId;
	private Integer namingConvention;
	
	public Integer getNamingConvention() {
		return namingConvention;
	}
	public void setNamingConvention(Integer namingConvention) {
		this.namingConvention = namingConvention;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	@Override
	public String toString() {
		return "Culture [id=" + id + ", culture=" + culture + ", regionId=" + regionId + ", namingConvention="
				+ namingConvention + "]";
	}
	
	
}
