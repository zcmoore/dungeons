package edu.asu.ser215.pathfinder.map;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class LinkedButton extends Button
{
	protected UserDisplay link;

	public LinkedButton(GameContainer container, StateBasedGame game, 
			Image icon, Point coordinates, UserDisplay link) 
	{
		super(container, game, icon, coordinates);
		this.link = link;
	}
	
	protected void act()
	{
		
	}

	public UserDisplay getLink() {
		return link;
	}

	public void setLink(UserDisplay link) {
		this.link = link;
	}
	
	
}
