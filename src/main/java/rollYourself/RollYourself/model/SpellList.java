package rollYourself.RollYourself.model;

import java.util.List;

public class SpellList {
	private Integer count;
	private List<SpellItem> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<SpellItem> getResults() {
		return results;
	}
	public void setResults(List<SpellItem> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "SpellList [count=" + count + ", results=" + results + "]";
	}

}
