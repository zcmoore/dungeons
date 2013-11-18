package edu.asu.ser215.pathfinder.inventory;
import java.util.ArrayList;

public class Inventory 
{
	public static final int DEFAULT_WEIGHT_CAPACITY = 50;
	
	protected String name; //name of inventory
	protected String description;
	protected String notes; //notes the GM has placed on this inventory
	protected ArrayList<GenericItem> genericItems;
	protected ArrayList<Armour> armours;
	protected ArrayList<Weapon> weapons;
	protected int copperPieces; //how much money is stored in this inventory currently
	protected int weightCapacity;
	protected int weightUsed; //minimum is 0, cannot be directly set
	
	
	/**
	 * Creates an empty inventory object named "Item Container" 
	 * Capacities are set to their default values.
	 */
	public Inventory() 
	{
		this.name = "Item Container";
		this.description = null;
		this.notes = null;
		this.genericItems = new ArrayList<>();
		this.armours = new ArrayList<>();
		this.weapons = new ArrayList<>();
		this.copperPieces = 0;
		this.weightCapacity = DEFAULT_WEIGHT_CAPACITY;
		this.weightUsed = 0;
	}
	
	/**
	 * Creates an Inventory with the given contents and details.
	 * weightUsed will be calculated based on the provided contents.
	 * Note: it is possible to initialize an inventory that is over the
	 * weight capacity. As such, the inventory should be checked after it
	 * is initialized, using the isInGoodStanding() method.
	 * 
	 * @param name 				arbitrary name of the inventory
	 * @param description 		arbitrary description of the inventory
	 * @param notes 			notes made by the GM
	 * @param genericItems 		initial inventory contents
	 * @param armours 			initial inventory contents
	 * @param weapons 			initial inventory contents
	 * @param copperPieces		initial monetary contents
	 * @param volumeCapacity
	 * @param weightCapacity
	 */
	public Inventory(String name, String description, String notes,
			ArrayList<GenericItem> genericItems, ArrayList<Armour> armours,
			ArrayList<Weapon> weapons, int copperPieces, int weightCapacity) 
	{
		this.name = name;
		this.description = description;
		this.notes = notes;
		this.genericItems = genericItems;
		this.armours = armours;
		this.weapons = weapons;
		this.copperPieces = copperPieces;
		this.weightCapacity = weightCapacity;
		this.weightUsed = Items.calculateWeight(getAllItems());
	}

	/**
	 * Returns a array of all items contained in this inventory. 
	 * Result is achieved by combining all content lists 
	 * (i.e. weapons, armours, and genericItems).
	 * 
	 * @return	an array of all items currently contained in this inventory
	 */
	public Item[] getAllItems()
	{
		int numberOfGenericItems = this.genericItems.size();
		int numberOfArmours = this.armours.size();
		int numberOfWeapons = this.weapons.size();
		Item[] allItems = new Item[numberOfGenericItems + numberOfArmours + numberOfWeapons];
		int currentIndex = 0;
		
		System.arraycopy(getGenericItems(), 0, allItems, currentIndex, numberOfGenericItems);
		System.arraycopy(getArmours(), 0, allItems, currentIndex, numberOfArmours);
		System.arraycopy(getWeapons(), 0, allItems, currentIndex, numberOfWeapons);
		
		return allItems;
	}
	
	/**
	 * Returns true if item was added successfully. Will not add item if the 
	 * addition would exceed the weight capacity; recalculates weight after 
	 * adding the item.
	 * 
	 * @param item
	 * @return	boolean indicatig whether the add was successful.
	 */
	public boolean addItem(Item item)
	{
		boolean itemAdded = true;
		
		if (canHoldItem(item))
		{
			if (item instanceof GenericItem)
				this.genericItems.add((GenericItem)item);
			else if (item instanceof Armour)
				this.armours.add((Armour)item);
			else if (item instanceof Weapon)
				this.weapons.add((Weapon)item);
			else
				itemAdded = false;
			
			recalculateDependentVariables();
		}
		else
			itemAdded = false;
		
		
		return itemAdded;
	}
	
	/**
	 * Removes an item from this inventory and recalculates all dependent
	 * variables (e.g. weight).
	 * 
	 * @param item the item to be removed from this inventory
	 */
	public void removeItem(Item item)
	{
		try
		{
			if (item instanceof GenericItem)
				this.genericItems.remove((GenericItem)item);
			else if (item instanceof Armour)
				this.armours.remove((Armour)item);
			else if (item instanceof Weapon)
				this.weapons.remove((Weapon)item);
			
			recalculateDependentVariables();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns true if the inventory is capable of holding the given item. This
	 * will not add the item to the Inventory.
	 * 
	 * @return
	 */
	public boolean canHoldItem(Item item)
	{
		int potentialWeight = this.weightUsed + item.getData().getWeight();
		boolean acceptableWeight = (potentialWeight <= this.weightCapacity);
		
		return (acceptableWeight);
	}
	
	/**
	 * Recalculated the weight used based on the 
	 * current items contained in this inventory.
	 */
	public void recalculateWeightUsed() 
	{
		this.weightUsed = Items.calculateWeight(getAllItems());;
	}
	
	/**
	 * Recalculated all dependent variables (e.g. weight) based on the 
	 * current items contained in this inventory.
	 */
	public void recalculateDependentVariables()
	{
		recalculateWeightUsed();
	}
	
	/**
	 * Recalculate dependent variables (e.g. weight) and return true if 
	 * inventory is within capacity.
	 * 
	 * @return	whether or not the inventory is within capacity
	 */
	public boolean verifyGoodStanding()
	{
		recalculateDependentVariables();
		return isInGoodStanding();
	}
	
	/**
	 * Returns true if the inventory is within capacity (e.g. within weight limit)
	 * 
	 * @return	whether or not the inventory is within capacity
	 */
	public boolean isInGoodStanding()
	{
		return !isWeightOverCapacity();
	}
	
	/**
	 * Returns true if the inventory is within its weight capacity.
	 * 
	 * @return	whether or not the inventory is within weight capacity
	 */
	public boolean isWeightOverCapacity()
	{
		return (this.weightUsed <= this.weightCapacity);
	}
	
	public void addCopperPieces(int copperPieces)
	{
		this.copperPieces += copperPieces;
	}
	
//---------------------------------------------------------------------------\\
//-----------------Verifiable Accessors & Mutators---------------------------\\
//---------------------------------------------------------------------------\\
	/* These methods could make the inventory exceed its capacity 
	 * (i.e. weightUsed > weightCapacity) As such, these methods 
	 * should be accompanied by checks using the returned boolean values
	 */

	/**
	 * Sets the given list, and recalculates dependent values (e.g. weight)
	 * to match the new contents. This method returns true if the inventory is 
	 * within capacity after the content change.
	 * 
	 * NOTE: This method could make the inventory exceed its capacity. As such,
	 * code that uses this method should take appropriate action, and check that
	 * the inventory is still within capacity using the returned boolean value.
	 * 
	 * @param genericItems	this will replace the current list of genericItems.
	 * @return	whether or not the inventory is within capacity after the change.
	 */
	public boolean setGenericItems(ArrayList<GenericItem> genericItems) 
	{
		this.genericItems = genericItems;
		return verifyGoodStanding();
	}
	
	/**
	 * @see edu.asu.ser215.pathfinder.inventory.Inventory#setGenericItems(ArrayList)
	 * 
	 * @param armours	this will replace the current list of armours.
	 * @return	whether or not the inventory is within capacity after the change.
	 */
	public boolean setArmours(ArrayList<Armour> armours) 
	{
		this.armours = armours;
		return verifyGoodStanding();
	}
	
	/**
	 * @see edu.asu.ser215.pathfinder.inventory.Inventory#setGenericItems(ArrayList)
	 * 
	 * @param weapons	this will replace the current list of weapons.
	 * @return	whether or not the inventory is within capacity after the change.
	 */
	public boolean setWeapons(ArrayList<Weapon> weapons) 
	{
		this.weapons = weapons;
		return verifyGoodStanding();
	}
	
	/**
	 * @see edu.asu.ser215.pathfinder.inventory.Inventory#setGenericItems(ArrayList)
	 */
	public boolean setWeightCapacity(int weightCapacity) 
	{
		this.weightCapacity = weightCapacity;
		return !isWeightOverCapacity();
	}
	
//---------------------------------------------------------------------------\\
//-------------------Standard Accessors & Mutators---------------------------\\
//---------------------------------------------------------------------------\\
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCopperPieces() {
		return copperPieces;
	}

	public void setCopperPieces(int copperPieces) {
		this.copperPieces = copperPieces;
	}

	public GenericItem[] getGenericItems() {
		return genericItems.toArray(new GenericItem[genericItems.size()]);
	}
	
	public Armour[] getArmours() {
		return armours.toArray(new Armour[armours.size()]);
	}
	
	public Weapon[] getWeapons() {
		return weapons.toArray(new Weapon[weapons.size()]);
	}
	
	public int getWeightCapacity() {
		return weightCapacity;
	}
	
	public int getWeightUsed() {
		return weightUsed;
	}
	
}
