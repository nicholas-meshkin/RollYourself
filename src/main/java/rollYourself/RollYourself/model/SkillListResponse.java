package rollYourself.RollYourself.model;

import java.util.List;

public class SkillListResponse {

	private Integer count;
	private List<SkillItem> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<SkillItem> getResults() {
		return results;
	}
	public void setResults(List<SkillItem> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "SkillListResponse [count=" + count + ", results=" + results + "]";
	}
	
}
