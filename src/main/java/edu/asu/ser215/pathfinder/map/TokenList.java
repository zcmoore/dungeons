package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;
import java.util.ArrayList;

public class TokenList extends ArrayList<GameBoardToken> 
{
	private static final long serialVersionUID = 1L;
	private Dimension tokenSize;
	
	public TokenList(Dimension tokenSize)
	{
		super();
		this.tokenSize = tokenSize;
	}
	
	public boolean add(GameBoardToken token)
	{
		boolean canBeAdded = token.getButtonDimension().equals(this.tokenSize);
		
		if (canBeAdded)
			canBeAdded = super.add(token);
		
		return canBeAdded;
	}
}
