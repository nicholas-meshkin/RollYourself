package rollYourself.RollYourself.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipment {
	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	@JsonProperty("equipment_category")
	private String equipmentCategory;
	@JsonProperty("weapon_category")
	private String weaponCategory;
	@JsonProperty("weapon_range")
	private String weaponRange;
	@JsonProperty("category_range")
	private String categoryRange;
	@JsonProperty("armor_category")
	private String armorCategory;
	@JsonProperty("armor_class")
	private ArmorClass armorClass;
	@JsonProperty("str_minimum")
	private Integer strMin;
	@JsonProperty("stealth_disadvantage")
	private Boolean stealthDisadvantage;
	private Integer weight;
	private Cost cost;
	private Damage damage;
	private Range range;
	private List<PropertyItem> properties;
	@JsonProperty("throw_range")
	private ThrowRange throwRange;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEquipmentCategory() {
		return equipmentCategory;
	}
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
	public String getWeaponCategory() {
		return weaponCategory;
	}
	public void setWeaponCategory(String weaponCategory) {
		this.weaponCategory = weaponCategory;
	}
	public String getWeaponRange() {
		return weaponRange;
	}
	public void setWeaponRange(String weaponRange) {
		this.weaponRange = weaponRange;
	}
	public String getCategoryRange() {
		return categoryRange;
	}
	public void setCategoryRange(String categoryRange) {
		this.categoryRange = categoryRange;
	}
	public String getArmorCategory() {
		return armorCategory;
	}
	public void setArmorCategory(String armorCategory) {
		this.armorCategory = armorCategory;
	}
	public ArmorClass getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(ArmorClass armorClass) {
		this.armorClass = armorClass;
	}
	public Integer getStrMin() {
		return strMin;
	}
	public void setStrMin(Integer strMin) {
		this.strMin = strMin;
	}
	public Boolean getStealthDisadvantage() {
		return stealthDisadvantage;
	}
	public void setStealthDisadvantage(Boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public Damage getDamage() {
		return damage;
	}
	public void setDamage(Damage damage) {
		this.damage = damage;
	}
	public Range getRange() {
		return range;
	}
	public void setRange(Range range) {
		this.range = range;
	}
	public List<PropertyItem> getProperties() {
		return properties;
	}
	public void setProperties(List<PropertyItem> properties) {
		this.properties = properties;
	}
	public ThrowRange getThrowRange() {
		return throwRange;
	}
	public void setThrowRange(ThrowRange throwRange) {
		this.throwRange = throwRange;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", index=" + index + ", name=" + name + ", equipmentCategory="
				+ equipmentCategory + ", weaponCategory=" + weaponCategory + ", weaponRange=" + weaponRange
				+ ", categoryRange=" + categoryRange + ", armorCategory=" + armorCategory + ", armorClass=" + armorClass
				+ ", strMin=" + strMin + ", stealthDisadvantage=" + stealthDisadvantage + ", weight=" + weight
				+ ", cost=" + cost + ", damage=" + damage + ", range=" + range + ", properties=" + properties
				+ ", throwRange=" + throwRange + ", url=" + url + "]";
	}

}
