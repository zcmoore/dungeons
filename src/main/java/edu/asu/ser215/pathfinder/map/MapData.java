package edu.asu.ser215.pathfinder.map;

import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;

public abstract class MapData implements UserDisplay, Serializable
{
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
		//TODO
		return null;
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
