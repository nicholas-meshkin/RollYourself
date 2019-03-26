package rollYourself.RollYourself.citygenmodel;
import java.util.List;

public class Town {

	private List<Person> population;
	private String name;
	private Integer size;
	private List<String> establishments;
	private Integer affluenceRating;
	private Boolean rural;
	private Boolean coastal;
	private Boolean mountainous;
	private Climate climate;
	
	public Climate getClimate() {
		return climate;
	}
	public void setClimate(Climate climate) {
		this.climate = climate;
	}
	public Boolean getMountainous() {
		return mountainous;
	}
	public void setMountainous(Boolean mountainous) {
		this.mountainous = mountainous;
	}
	public List<Person> getPopulation() {
		return population;
	}
	public void setPopulation(List<Person> population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<String> getEstablishments() {
		return establishments;
	}
	public void setEstablishments(List<String> establishments) {
		this.establishments = establishments;
	}
	public Integer getAffluenceRating() {
		return affluenceRating;
	}
	public void setAffluenceRating(Integer affluenceRating) {
		this.affluenceRating = affluenceRating;
	}
	public Boolean getRural() {
		return rural;
	}
	public void setRural(Boolean rural) {
		this.rural = rural;
	}
	public Boolean getCoastal() {
		return coastal;
	}
	public void setCoastal(Boolean coastal) {
		this.coastal = coastal;
	}
	
}
