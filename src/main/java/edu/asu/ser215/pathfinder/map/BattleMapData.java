package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.asu.ser215.pathfinder.Main;
import edu.asu.ser215.pathfinder.MapScreen;

public class BattleMapData extends MapData
{
	private static final long serialVersionUID = 1L;
	protected Grid gridOverlay;
	
	public BattleMapData(Image mapBackground, String name)
	{
		this(mapBackground, name, null);
		try
		{
			int mapWidth = mapBackground.getWidth();
			int mapHeight = mapBackground.getHeight();
			Dimension gridSize = new Dimension(mapWidth, mapHeight);
			this.gridOverlay = new Grid(gridSize);
		} catch (SlickException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BattleMapData(Image mapBackground, String name, Grid gridOverlay)
	{
		this(mapBackground, name, "", gridOverlay);
	}

	public BattleMapData(Image mapBackground, String name, String notes,
			Grid gridOverlay)
	{
		super(mapBackground, name, notes);
		this.gridOverlay = gridOverlay;
	}

	/** 
	 * Sets the MapScreen to its default data
	 * 
	 * @see edu.asu.ser215.pathfinder.map.UserDisplay#close()
	 */
	@Override
	public void close()
	{
		MapScreen.reset();
	}

	/**
	 * Transitions the current game state to MapScreen using the data specified
	 * by this BattleMapData object
	 * 
	 * @see edu.asu.ser215.pathfinder.map.UserDisplay#open()
	 */
	@Override
	public void open()
	{
		MapScreen.setMapData(this);
		Main.getCurrentGame().enterState(MapScreen.ID);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		//TODO method body
		//check mouse collisions
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
	{
		//TODO method body
		//draw background, and menu buttons
		super.render(container, game, g);
		
		//draw grid
		gridOverlay.drawGrid(g);
		
		//draw tokens on grid
		
		
	}

}
