package edu.asu.ser215.pathfinder.character;

/**
 * Any class that can be represented as a GameBoardToken should be a descendent
 * of this class.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.map.GameBoardToken
 *
 */
public class TokenEntity
{
	//name of the entity, to identify this token and be displayed to the user
	protected String name;

	public TokenEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
