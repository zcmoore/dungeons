package edu.asu.ser215.pathfinder.inventory;
import java.util.HashMap;

/**
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.inventory.ItemData
 * @see edu.asu.ser215.pathfinder.inventory.Armour
 *
 */
public class ArmourData extends ItemData
{
	private static HashMap<String, ArmourData> armourDataMap; //the item's name is used as a key
	
	private final int armourBonus;
	private final int armourCheckPenalty; //penalty applied to all DEX or STR rolls
	private final int maxDexBonus; //limits a players DEX bonus when calculating her/his Armour Class
	private final double arcaneFailureChance; //armour limits a player's ability to cast spells. This is the chance she/he will fail if wearing this armour. Value is represented in decimal (e.g. 0.9 = 90%)
	private final int speedLimitation20; //max speed (in ft/round) for a character with a base speed of 20ft/round
	private final int speedLimitation30; //max speed (in ft/round) for a character with a base speed of 30ft/round
	
	/**
	 * Protected constructor to prevent unmapped or duplicate instantiations.
	 */
	protected ArmourData(String name, String type, int cost, int weight, String description, 
			int armourBonus, int armourCheckPenalty, int maxDexBonus, 
			double arcaneFailureChance, int speedLimitation20, 
			int speedLimitation30) 
	{
		super(name, type, cost, weight, description);
		this.armourBonus = armourBonus;
		this.armourCheckPenalty = armourCheckPenalty;
		this.maxDexBonus = maxDexBonus;
		this.arcaneFailureChance = arcaneFailureChance;
		this.speedLimitation20 = speedLimitation20;
		this.speedLimitation30 = speedLimitation30;
	}
	
	/**
	 * Allows the retrieval of ArmourData objects.
	 * 
	 * @param cost		cost of the item in copper pieces
	 * @param weight 	weight of the item in pounds
	 * @param speedLimitation20 
	 * 		speed limitation for characters that can move 20ft under normal circumstances
	 * @param speedLimitation30 
	 * 		speed limitation for characters that can move 30ft under normal circumstances
	 * @return ArmourData object created based on the provided parameters
	 * 
	 * @see edu.asu.ser215.pathfinder.inventory.ItemData#constructItemData(Class, HashMap, String, Object...)
	 */
	@SuppressWarnings("unchecked")
	public static ArmourData constructArmourData(String name, String type, int cost, int weight,
			String description, int armourBonus, int armourCheckPenalty,
			int maxDexBonus, double arcaneFailureChance, int speedLimitation20,
			int speedLimitation30)
	{
		String key = name;
		ArmourData matchingData; //This will be returned
		
		if (armourDataMap == null)
			armourDataMap = new HashMap<>();
		
		matchingData = ItemData.constructItemData(ArmourData.class, armourDataMap, key, 
				name, type, cost, weight, description, armourBonus, armourCheckPenalty, //given parameters
				maxDexBonus, arcaneFailureChance, speedLimitation20, speedLimitation30); //given parameters
		
		return matchingData;
	}
	
	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.inventory.ItemData#toString()
	 */
	@Override
	public String toString() {
		return "ArmourData [armourBonus=" + armourBonus
				+ ", armourCheckPenalty=" + armourCheckPenalty
				+ ", maxDexBonus=" + maxDexBonus + ", arcaneFailureChance="
				+ arcaneFailureChance + ", speedLimitation20="
				+ speedLimitation20 + ", speedLimitation30="
				+ speedLimitation30 + ", name=" + name + ", type=" + type
				+ ", cost=" + baseCost + ", weight=" + weight + ", description="
				+ description + "]";
	}
	
	
	//------------------------------------------------------------------------------------------------------------
	//------------------------------------------Accessors [NO MUTATORS]-------------------------------------------
	//------------------------------------------------------------------------------------------------------------
	public int getArmourBonus() {
		return armourBonus;
	}

	public int getArmourCheckPenalty() {
		return armourCheckPenalty;
	}

	public int getMaxDexBonus() {
		return maxDexBonus;
	}

	public double getArcaneFailureChance() {
		return arcaneFailureChance;
	}

	public int getSpeedLimitation20() {
		return speedLimitation20;
	}

	public int getSpeedLimitation30() {
		return speedLimitation30;
	}
	
	
}
