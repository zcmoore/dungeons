package edu.asu.ser215.pathfinder.map;

import java.awt.Point;
import java.io.Serializable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class MapData implements UserDisplay, Serializable
{
	public static class EmptyMapData extends MapData
	{
		private static final long serialVersionUID = 1L;
		
		public EmptyMapData()
		{
			super("EmptyMap");
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
	private static Image DEFAULT_BCKGROUND = null;
	
	protected Point backgroundOffset = new Point(0, 0);
	protected Image mapBackground;
	protected String name;
	protected String notes;
	protected LinkedButton[] links;
	
	
	
	private MapData(Image mapBackground, String name,
			String notes, LinkedButton[] links)
	{
		this.mapBackground = mapBackground;
		this.name = name;
		this.notes = notes;
		this.links = links;
	}

	protected MapData(Image mapBackground, String name, String notes)
	{
		this(mapBackground, name, notes, new LinkedButton[0]);
	}
	
	protected MapData(String name)
	{
		this(MapData.DEFAULT_BCKGROUND, name, "", new LinkedButton[0]);
	}
	
	private static Image constructDefaultBackground()
	{
		try
		{
			return(new Image("res/resourcepacks/default/img/whiteBackground.jpg"));
		} catch (SlickException e)
		{
			System.out.println("caught");
			e.printStackTrace();
			return null;
		}
	}

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

	public Point getBackgroundOffset() {
		return backgroundOffset;
	}

	public void setBackgroundOffset(Point backgroundOffset) {
		this.backgroundOffset = backgroundOffset;
	}

	public Image getMapBackground() {
		return mapBackground;
	}

	public void setMapBackground(Image mapBackground) {
		this.mapBackground = mapBackground;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LinkedButton[] getLinks() {
		return links;
	}
	
	
}
