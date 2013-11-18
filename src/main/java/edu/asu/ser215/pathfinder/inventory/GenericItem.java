package edu.asu.ser215.pathfinder.inventory;

/**
 * GenericItem objects can be altered by the user, unlike GenericItemData objects.
 * 
 * @author Zach Moore
 *
 */
public class GenericItem extends Item
{
	/**
	 * @see edu.asu.ser215.pathfinder.inventory.Item#Item(ItemData, String, int, boolean)
	 */
	private GenericItem(ItemData itemData, String notes, int quantity, boolean masterwork) 
	{
		super(itemData, notes, quantity, masterwork);
	}
	
	public GenericItemData getGenericItemData()
	{
		return (GenericItemData)this.itemData;
	}

	@SuppressWarnings("unchecked")
	public <T extends ItemData> T getData()
	{
		GenericItemData returnData = (GenericItemData)this.itemData;
		return (T)returnData;
	}
	
	public void setName(String name)
	{
		GenericItemData data = getData();
		
		this.itemData = GenericItemData.constructGenericItemData(
				name, data.getType(), data.getCost(), 
				data.getWeight(), data.getDescription());
	}

	public void setType(String type)
	{
		GenericItemData data = getData();
		
		this.itemData = GenericItemData.constructGenericItemData(
				data.getName(), type, data.getCost(), 
				data.getWeight(), data.getDescription());
	}

	public void setCost(int cost)
	{
		GenericItemData data = getData();
		
		this.itemData = GenericItemData.constructGenericItemData(
				data.getName(), data.getType(), cost, 
				data.getWeight(), data.getDescription());
	}

	public void setWeight(int weight)
	{
		GenericItemData data = getData();
		
		this.itemData = GenericItemData.constructGenericItemData(
				data.getName(), data.getType(), data.getCost(), 
				weight, data.getDescription());
	}

	public void setDescription(String description)
	{
		GenericItemData data = getData();
		
		this.itemData = GenericItemData.constructGenericItemData(
				data.getName(), data.getType(), data.getCost(), 
				data.getWeight(), description);
	}
}
