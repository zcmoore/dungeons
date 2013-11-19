package edu.asu.ser215.pathfinder.inventory;

/**
 * Armour objects can be altered by the user, unlike ArmourData objects.
 * 
 * @author Zach Moore
 *
 */
public class Armour extends Item
{	
	/**
	 * @see edu.asu.ser215.pathfinder.inventory.Item#Item(ItemData, String, int, boolean)
	 */
	public Armour(ItemData itemData, String notes, int quantity, boolean masterwork) 
	{
		super(itemData, notes, quantity, masterwork);
	}

	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.inventory.Item#getData()
	 */
	@SuppressWarnings("unchecked")
	public <T extends ItemData> T getData()
	{
		ArmourData returnData = (ArmourData)this.itemData;
		return (T)returnData;
	}
	
	public ArmourData getArmourData()
	{
		return (ArmourData)this.itemData;
	}
	
	//-------------------------------------------------------------------------
	//-------------------------ItemData Mutators-------------------------------
	//-------------------------------------------------------------------------
	public void setName(String name)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(name, data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setType(String type)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), type, 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setCost(int cost)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				cost, data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setWeight(int weight)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), weight, data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setDescription(String description)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), description, 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}
	
	public void setArmourBonus(int armourBonus)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				armourBonus, data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setArmourCheckPenalty(int armourCheckPenalty)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), armourCheckPenalty, 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setMaxDexBonus(int maxDexBonus)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				maxDexBonus, data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setArcaneFailureChance(double arcaneFailureChance)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), arcaneFailureChance, 
				data.getSpeedLimitation20(), data.getSpeedLimitation30());
	}

	public void setSpeedLimitation20(int speedLimitation20)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				speedLimitation20, data.getSpeedLimitation30());
	}

	public void setSpeedLimitation30(int speedLimitation30)
	{
		ArmourData data = getData();
		
		this.itemData = ArmourData.constructArmourData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getArmourBonus(), data.getArmourCheckPenalty(), 
				data.getMaxDexBonus(), data.getArcaneFailureChance(), 
				data.getSpeedLimitation20(), speedLimitation30);
	}
}
