package rollYourself.RollYourself.model;

public class SpellInfo {

	private Integer spellSaveDc;
	private Integer spellAttackModifier;
	private String spellcastingAbility;
	private Integer firstLevelSlots;
	public Integer getSpellSaveDc() {
		return spellSaveDc;
	}
	public void setSpellSaveDc(Integer spellSaveDc) {
		this.spellSaveDc = spellSaveDc;
	}
	public Integer getSpellAttackModifier() {
		return spellAttackModifier;
	}
	public void setSpellAttackModifier(Integer spellAttackModifier) {
		this.spellAttackModifier = spellAttackModifier;
	}
	public String getSpellcastingAbility() {
		return spellcastingAbility;
	}
	public void setSpellcastingAbility(String spellcastingAbility) {
		this.spellcastingAbility = spellcastingAbility;
	}
	public Integer getFirstLevelSlots() {
		return firstLevelSlots;
	}
	public void setFirstLevelSlots(Integer firstLevelSlots) {
		this.firstLevelSlots = firstLevelSlots;
	}
	@Override
	public String toString() {
		return "SpellInfo [spellSaveDc=" + spellSaveDc + ", spellAttackModifier=" + spellAttackModifier
				+ ", spellcastingAbility=" + spellcastingAbility + ", firstLevelSlots=" + firstLevelSlots + "]";
	}
	
	
}
