package rollYourself.RollYourself;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="spellsdetails")
public class SpellsDetails {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("index")
	private Long id;
	private String name;
	private Integer level;
	private String classes;
	
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "SpellsDetails [id=" + id + ", name=" + name + ", level=" + level + ", classes=" + classes + "]";
	}
	
}