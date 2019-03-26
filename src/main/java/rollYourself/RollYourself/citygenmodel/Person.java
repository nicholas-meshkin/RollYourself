package rollYourself.RollYourself.citygenmodel;
import java.util.List;

public class Person {

	private Integer age;
	private Species species;
	private String job;
	private List<Person> family;
	private Integer affluenceRating;
	private String lastName;
	private String firstName;
	private List<String> qualities;
	private String gender;
	private Boolean isNoble;
	private Boolean isOrphan;
	
	public Boolean getIsOrphan() {
		return isOrphan;
	}
	public void setIsOrphan(Boolean isOrphan) {
		this.isOrphan = isOrphan;
	}
	public Boolean getIsNoble() {
		return isNoble;
	}
	public void setIsNoble(Boolean isNoble) {
		this.isNoble = isNoble;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public List<Person> getFamily() {
		return family;
	}
	public void setFamily(List<Person> family) {
		this.family = family;
	}
	public Integer getAffluenceRating() {
		return affluenceRating;
	}
	public void setAffluenceRating(Integer affluenceRating) {
		this.affluenceRating = affluenceRating;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<String> getQualities() {
		return qualities;
	}
	public void setQualities(List<String> qualities) {
		this.qualities = qualities;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}