package edu.asu.ser215.pathfinder.inventory;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zach Moore
 * @see	edu.asu.ser215.pathfinder.inventory.ItemData
 * @see	edu.asu.ser215.pathfinder.inventory.Weapon
 */
public class WeaponData extends ItemData
{
	private static HashMap<String, WeaponData> weaponDataMap; //the item's name is used as a key
	public static final int MAXIMUM_CRITICAL_ROLL = 20;
	public static final int IMPOSSIBLE_CRIT = MAXIMUM_CRITICAL_ROLL + 1;
	
	private final int range; //expressed in feet
	private final DiceSet damagePotentialSmall;
	private final DiceSet damagePotentialMedium;
	private final int critMultiplier; //if a critical hit is made, the damage dealt will be multiplied by this number
	private final int minimumCritRoll; //set to IMPOSSIBLE_CRIT if it is impossible to obtain a critical hit with this weapon
	private final DamageType[] damageTypes; //what types of damage can this weapon inflict
	
	/**
	 * Protected constructor to prevent unmapped or duplicate instantiations.
	 */
	protected WeaponData(String name, String type, int cost, int weight, String description, 
			int range, DiceSet damagePotentialSmall, DiceSet damagePotentialMedium, 
			int critMultiplier, int minimumCritRoll, DamageType... damageTypes)
	{
		super(name, type, cost, weight, description);
		this.range = range;
		this.damagePotentialSmall = damagePotentialSmall;
		this.damagePotentialMedium = damagePotentialMedium;
		this.critMultiplier = critMultiplier;
		this.minimumCritRoll = minimumCritRoll;
		this.damageTypes = damageTypes;
	}
	
	
	/**
	 * Allows public instantiation of WeaponData objects. This method will
	 * map all new objects, and ensure that any objects holding the same data
	 * will reference the same memory.
	 * 
	 * @param cost		cost of weapon in copper pieces
	 * @param weight	weight in pounds
	 * @param range		range in ft. 0 for immediate range
	 * @param damagePotentialSmall		damage inflicted by a small user
	 * @param damagePotentialMedium		damage inflicted by a medium user
	 * @return			WeaponData object representing the given parameters.
	 * 
	 * @see	edu.asu.ser215.pathfinder.inventory.ItemData#constructItemData
	 * (Class, HashMap, String, Object...)
	 */
	public static WeaponData constructWeaponData(String name, String type, int cost, int weight,
			String description, int range, DiceSet damagePotentialSmall, 
			DiceSet damagePotentialMedium, int critMultiplier, 
			int minimumCritRoll, DamageType... damageTypes)
	{
		String key = name;
		WeaponData matchingData;
		
		if (weaponDataMap == null)
			weaponDataMap = new HashMap<>();
		
		matchingData = ItemData.constructItemData(WeaponData.class, 
				weaponDataMap, key, name, type, cost, weight, description,
				range, damagePotentialSmall, damagePotentialMedium, 
				critMultiplier, minimumCritRoll, damageTypes);
		
		return matchingData;
	}
	
	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.inventory.ItemData#toString()
	 */
	@Override
	public String toString() {
		return "WeaponData [range=" + range + ", damagePotentialSmall="
				+ damagePotentialSmall + ", damagePotentialMedium="
				+ damagePotentialMedium + ", critMultiplier=" + critMultiplier
				+ ", minimumCritRoll=" + minimumCritRoll + ", damageTypes="
				+ Arrays.toString(damageTypes) + ", name=" + name + ", type="
				+ type + ", cost=" + cost + ", weight=" + weight
				+ ", description=" + description + "]";
	}
	
	
	//-------------------------------------------------------------------------
	//--------------------------Accessors--------------------------------------
	//-------------------------------------------------------------------------
	public int getRange() {
		return range;
	}
	
	public int getCritMultiplier() {
		return critMultiplier;
	}

	public DiceSet getDamagePotentialSmall() {
		return damagePotentialSmall;
	}

	public DiceSet getDamagePotentialMedium() {
		return damagePotentialMedium;
	}

	public int getMinimumCritRoll() {
		return minimumCritRoll;
	}

	public DamageType[] getDamageTypes() {
		return damageTypes;
	}
	
	
}
