package rollYourself.RollYourself.citygenmodel;
import java.util.List;

public class Family {

	private List<Person> members;
	private Integer size;
	private Boolean isNoble;
	private Integer affluenceRating;
	private Culture culture;
	private Species species;
	
	
	public Culture getCulture() {
		return culture;
	}
	public void setCulture(Culture culture) {
		this.culture = culture;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Boolean getIsNoble() {
		return isNoble;
	}
	public void setIsNoble(Boolean isNoble) {
		this.isNoble = isNoble;
	}
	public Integer getAffluenceRating() {
		return affluenceRating;
	}
	public void setAffluenceRating(Integer affluenceRating) {
		this.affluenceRating = affluenceRating;
	}
	public List<Person> getMembers() {
		return members;
	}
	public void setMembers(List<Person> members) {
		this.members = members;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
