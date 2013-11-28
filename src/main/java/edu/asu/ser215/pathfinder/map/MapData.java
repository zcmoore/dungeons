package edu.asu.ser215.pathfinder.map;

import java.io.Serializable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public abstract class MapData implements UserDisplay, Serializable
{
	/**
	 * Corresponds to dev-version 1
	 */
	private static final long serialVersionUID = 1L;
	
	protected Image mapBackground;
	protected LinkedButton[] links;
	
	public abstract void update(GameContainer container, StateBasedGame game, int delta);
}
