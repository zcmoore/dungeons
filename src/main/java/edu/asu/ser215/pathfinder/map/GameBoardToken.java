package edu.asu.ser215.pathfinder.map;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class GameBoardToken extends LinkedButton
{

	public GameBoardToken(GameContainer container, StateBasedGame game, Image icon,
			Point coordinates, UserDisplay link) 
	{
		super(container, game, icon, coordinates, link);
	}
	
	protected void act()
	{
		
	}
}
