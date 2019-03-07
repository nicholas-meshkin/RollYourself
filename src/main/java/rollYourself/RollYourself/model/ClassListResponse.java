package rollYourself.RollYourself.model;

import java.util.List;

public class ClassListResponse {

	private Integer count;
	private List<ClassListItem> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<ClassListItem> getResults() {
		return results;
	}
	public void setResults(List<ClassListItem> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ClassListResponse [count=" + count + ", results=" + results + "]";
	}
	
}
