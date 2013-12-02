package edu.asu.ser215.pathfinder.inventory;

public class Item<T extends ItemData>
{
	protected final Class<T> typeParameterClass;
	protected T itemData;
	protected String notes;
	protected int quantity;
	protected boolean masterwork;
	
	public Item(Class<T> typeParameterClass, T itemData, String notes, 
			int quantity, boolean masterwork)
	{
		this.typeParameterClass = typeParameterClass;
		this.itemData = itemData;
		this.notes = notes;
		this.quantity = quantity;
		this.masterwork = masterwork;
	}
	
	//-------------------------------------------------------------------------
	//-----------------------Accessors & Mutators------------------------------
	//-------------------------------------------------------------------------

	public T getData() {
		return itemData;
	}

	public void setItemData(T itemData) {
		this.itemData = itemData;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isMasterwork() {
		return masterwork;
	}

	public void setMasterwork(boolean masterwork) {
		this.masterwork = masterwork;
	}

	public Class<T> getTypeParameterClass() {
		return typeParameterClass;
	}
	
	
	
}
