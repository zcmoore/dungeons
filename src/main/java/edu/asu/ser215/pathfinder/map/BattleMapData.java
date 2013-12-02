package edu.asu.ser215.pathfinder.map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class BattleMapData extends MapData
{
	private static final long serialVersionUID = 1L;
	protected Grid gridOverlay;

	@Override
	public void close()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void open()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		// TODO Auto-generated method stub

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
