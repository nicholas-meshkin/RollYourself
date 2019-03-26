package rollYourself.RollYourself.citygenmodel;
import java.util.List;

public class Family {

	private List<Person> members;
	private Integer size;
	private Boolean isNoble;
	private Integer affluenceRating;
	
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
