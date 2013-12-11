package edu.asu.ser215.pathfinder;

import edu.asu.ser215.pathfinder.gui.map.GameBoardToken;
import edu.asu.ser215.pathfinder.inventory.Inventory;

/**
 * Any class that can be represented as a GameBoardToken should be a descendent
 * of this class. Indicates that an instance of a class can be represented as a 
 * token. All TokenEntities share common features (name, inventory, etc) and 
 * should be able to generate a Token object based on itself. 
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.map.GameBoardToken
 *
 */
public abstract class TokenEntity
{
	//name of the entity, to identify this token and be displayed to the user
	protected String name;
	protected boolean moveable;
	
	public abstract GameBoardToken<?> createToken();

	public abstract Inventory getInventory();

	public TokenEntity(String name, boolean moveable) {
		this.name = name;
		this.moveable = moveable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
}
