package rollYourself.RollYourself.model;

public class AbScoreJoin {

	private Integer score;
	private Integer bonus;
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "AbScoreJoin [score=" + score + ", bonus=" + bonus + "]";
	}
	
}
