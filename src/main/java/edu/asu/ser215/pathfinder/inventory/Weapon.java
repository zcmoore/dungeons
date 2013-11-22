package edu.asu.ser215.pathfinder.inventory;

import edu.asu.ser215.pathfinder.core.DiceSet;

/**
 * @author 	Zach Moore
 * @see 	edu.asu.ser215.pathfinder.inventory.Item
 */
public class Weapon extends Item
{
	public Weapon(ItemData itemData, String notes, int quantity, boolean masterwork) 
	{
		super(itemData, notes, quantity, masterwork);
	}
	
	public WeaponData getWeaponData()
	{
		return (WeaponData)this.itemData;
	}

	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.inventory.Item#getData()
	 */
	@SuppressWarnings("unchecked")
	public <T extends ItemData> T getData()
	{
		WeaponData returnData = (WeaponData)this.itemData;
		return (T)returnData;
	}
	
	//-------------------------------------------------------------------------
	//-------------------------ItemData Mutators-------------------------------
	//-------------------------------------------------------------------------
	public void setName(String name)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(name, data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setType(String type)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), type, 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setCost(int cost)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				cost, data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setWeight(int weight)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), weight, data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setDescription(String description)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), description, 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}
	
	public void setRange(int range)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				range, data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}
	
	public void setCritMultiplier(int critMultiplier)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), critMultiplier, 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setDamagePotentialSmall(DiceSet damagePotentialSmall)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), damagePotentialSmall, 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setDamagePotentialMedium(DiceSet damagePotentialMedium)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				damagePotentialMedium, data.getCritMultiplier(), 
				data.getMinimumCritRoll(), data.getDamageTypes());
	}

	public void setMinimumCritRoll(int minimumCritRoll)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				minimumCritRoll, data.getDamageTypes());
	}

	public void setDamageTypes(DamageType[] damageTypes)
	{
		WeaponData data = getData();
		
		this.itemData = WeaponData.constructWeaponData(data.getName(), data.getType(), 
				data.getCost(), data.getWeight(), data.getDescription(), 
				data.getRange(), data.getDamagePotentialSmall(), 
				data.getDamagePotentialMedium(), data.getCritMultiplier(), 
				data.getMinimumCritRoll(), damageTypes);
	}
	
}
