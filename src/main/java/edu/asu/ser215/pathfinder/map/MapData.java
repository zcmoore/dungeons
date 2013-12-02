package edu.asu.ser215.pathfinder.map;

import java.awt.Point;
import java.io.Serializable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public abstract class MapData implements UserDisplay, Serializable
{
	public static class EmptyMapData extends MapData
	{
		private static final long serialVersionUID = 1L;
		
		public EmptyMapData()
		{
			
		}
		
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
		public void update(GameContainer container, StateBasedGame game,
				int delta)
		{
			// TODO Auto-generated method stub
			
		}
		
		public void render(GameContainer container, StateBasedGame game, Graphics g)
		{
			
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	
	protected Point backgroundOffset = new Point(0, 0);
	protected Image mapBackground;
	protected LinkedButton[] links;
	
	public abstract void update(GameContainer container, StateBasedGame game, int delta);
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
	{
		g.drawImage(mapBackground, backgroundOffset.x, backgroundOffset.y);
		for (LinkedButton link : links)
		{
			Point linkLocation = link.getCoordinates();
			g.drawImage(link.getIcon(), linkLocation.x, linkLocation.y);
		}
	}
}
