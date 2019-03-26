package rollYourself.RollYourself.citygenmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DefaultSV {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String townType;
	private Integer sv;
	private String title;
	private Boolean famjob;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSv() {
		return sv;
	}
	public void setSv(Integer sv) {
		this.sv = sv;
	}
	public String getTownType() {
		return townType;
	}
	public void setTownType(String townType) {
		this.townType = townType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getFamjob() {
		return famjob;
	}
	public void setFamjob(Boolean famjob) {
		this.famjob = famjob;
	}
	@Override
	public String toString() {
		return "DefaultSV [id=" + id + ", sv=" + sv + ", title=" + title + "]";
	}
	
}
