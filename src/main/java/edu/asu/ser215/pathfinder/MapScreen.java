package edu.asu.ser215.pathfinder;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.asu.ser215.pathfinder.map.MapData;

public class MapScreen extends BasicGameState
{
	public static final int ID = 2;
	public static final MapData DEFAULT_MAP_DATA = new MapData.EmptyMapData();
	protected static MapData mapData = DEFAULT_MAP_DATA;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException 
	{
		//TODO
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException 
	{
		mapData.render(container, game, g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException 
	{
		mapData.update(container, game, delta);
	}

	@Override
	public int getID()
	{
		return ID;
	}
	
	public static void setMapData(MapData mapData)
	{
		MapScreen.mapData = mapData;
	}
	
	public static void reset()
	{
		mapData = DEFAULT_MAP_DATA;
	}
}
