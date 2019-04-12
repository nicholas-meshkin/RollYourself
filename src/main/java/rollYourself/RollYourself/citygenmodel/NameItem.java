package rollYourself.RollYourself.citygenmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="names")
public class NameItem {
	@Id 
//	@Column(name="id")
	private Long id;	
	private String name;
	private String culture;
	private Integer cultureId;
	private String type;
	private String region;
	private Integer regionId;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public Integer getCultureId() {
		return cultureId;
	}
	public void setCultureId(Integer cultureId) {
		this.cultureId = cultureId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "NameItem [id=" + id + ", name=" + name + ", culture=" + culture + ", cultureId=" + cultureId + ", type="
				+ type + ", region=" + region + ", regionId=" + regionId + ", gender=" + gender + "]";
	}

}
