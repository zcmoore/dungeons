package edu.asu.ser215.pathfinder.inventory;
import java.util.HashMap;

/**
 * @author Zach Moore
 * @see	edu.asu.ser215.pathfinder.inventory.ItemData.
 * @see	edu.asu.ser215.pathfinder.inventory.GenericItem
 */
public class GenericItemData extends ItemData
{
	private static HashMap<String, GenericItemData> genericItemDataMap; //the item's name is used as a key
	
	/**
	 * Protected constructor to prevent unmapped or duplicate instantiations.
	 */
	protected GenericItemData(String name, String type, int cost, 
								int weight, String description) 
	{
		super(name, type, cost, weight, description);
	}
	
	/**
	 * Allows the retrieval of GenericItemData objects.
	 * 
	 * @param cost		cost of the item in copper pieces
	 * @param weight 	weight of the item in pounds
	 * @return GenericItemData object created based on the provided parameters
	 * 
	 * @see ItemData#constructItemData(edu.asu.ser215.pathfinder.inventory.ItemData)
	 */
	@SuppressWarnings("unchecked")
	public static GenericItemData constructGenericItemData(String name, 
			String type, int cost, int weight, String description) 
	{
		String key = name;
		GenericItemData matchingData; //This will be returned
		
		if (genericItemDataMap == null)
			genericItemDataMap = new HashMap<>();
			
		matchingData = ItemData.constructItemData(GenericItemData.class, genericItemDataMap, key,
											name, type, cost, weight, description); //given parameters
		
		return matchingData;
	}
}
