package edu.asu.ser215.pathfinder.inventory;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Zach Moore
 * @see <ahref="http://paizo.com/prd/equipment.html">Pathfinder equipment guide</a>
 */
public enum DamageType 
{
	BLUDGEONING,
	GRAPPLING,
	PIERCING,
	RAY,
	SLASHING,
	UNARMED;
	
	private static HashMap<String, DamageType> damageMap;
	
	public static DamageType[] parseDamageTypes(String string)
	{
		String[] keys = string.split(",");
		ArrayList<DamageType> damageTypes = new ArrayList<>();
		
		//list all damage types represented by the string
		for (String key : keys)
		{
			DamageType type = getDamageType(key);
			if (!(type == null))
				damageTypes.add(type);
		}
		
		//return list of damage types as array
		return damageTypes.toArray(new DamageType[damageTypes.size()]);
	}
	
	/**
	 * Takes an abbreviation of a damage type and returns the corresponding
	 * DamageType enum.
	 * 
	 * @param key	abbreviation of the DamageType
	 * @return		DamageType represented by the string
	 */
	private static DamageType getDamageType(String key)
	{
		if (damageMap == null)
			initializeDamageMap();
		
		return damageMap.get(key);
	}
	
	private static void initializeDamageMap()
	{
		damageMap = new HashMap<>();
		damageMap.put("B", BLUDGEONING);
		damageMap.put("G", GRAPPLING);
		damageMap.put("P", PIERCING);
		damageMap.put("R", RAY);
		damageMap.put("S", SLASHING);
		damageMap.put("U", UNARMED);
	}
}
