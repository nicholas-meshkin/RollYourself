package rollYourself.RollYourself.citygenmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Species {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer famAvg;
	private Integer famStDev;
	private Integer ageStDev;
	private Integer ageMean;
	private Integer fertAge;
	private Integer popPct;
	
	public Integer getPopPct() {
		return popPct;
	}
	public void setPopPct(Integer popPct) {
		this.popPct = popPct;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFamAvg() {
		return famAvg;
	}
	public void setFamAvg(Integer famAvg) {
		this.famAvg = famAvg;
	}
	public Integer getFamStDev() {
		return famStDev;
	}
	public void setFamStDev(Integer famStDev) {
		this.famStDev = famStDev;
	}
	public Integer getAgeStDev() {
		return ageStDev;
	}
	public void setAgeStDev(Integer ageStDev) {
		this.ageStDev = ageStDev;
	}
	public Integer getAgeMean() {
		return ageMean;
	}
	public void setAgeMean(Integer ageMean) {
		this.ageMean = ageMean;
	}
	public Integer getFertAge() {
		return fertAge;
	}
	public void setFertAge(Integer fertAge) {
		this.fertAge = fertAge;
	}
	
}
