package edu.asu.ser215.pathfinder.inventory;

public abstract class Item
{
	protected ItemData itemData;
	protected String notes;
	protected int quantity;
	protected boolean masterwork;
	
	protected Item(ItemData itemData, String notes, int quantity, boolean masterwork)
	{
		this.itemData = itemData;
		this.notes = notes;
		this.quantity = quantity;
		this.masterwork = masterwork;
	}
	
	//-------------------------------------------------------------------------
	//-----------------------Accessors & Mutators------------------------------
	//-------------------------------------------------------------------------
	public abstract <T extends ItemData> T getData();

	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public boolean isMasterwork() {
		return masterwork;
	}
	
	public void setMasterwork(boolean masterwork) {
		this.masterwork = masterwork;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItemData(ItemData itemData) {
		this.itemData = itemData;
	}
	
	//-------------------------------------------------------------------------
	//-------------------------ItemData Mutators-------------------------------
	//-------------------------------------------------------------------------
	public abstract void setName(String name);

	public abstract void setType(String type);

	public abstract void setCost(int cost);

	public abstract void setWeight(int weight);

	public abstract void setDescription(String description);
}
