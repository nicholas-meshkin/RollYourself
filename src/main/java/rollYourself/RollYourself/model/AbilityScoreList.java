package rollYourself.RollYourself.model;

import java.util.List;

public class AbilityScoreList {

	private Integer count;
	private List<AbilityScoreItem> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<AbilityScoreItem> getResults() {
		return results;
	}
	public void setResults(List<AbilityScoreItem> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "AbilityScoreList [count=" + count + ", results=" + results + "]";
	}
	
}
