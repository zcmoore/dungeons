package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;
import java.awt.Image;

public class BattleMapData extends MapData
{
	private static final long serialVersionUID = 1L;
	protected Grid gridOverlay;
	
	public BattleMapData(Image mapBackground, String name)
	{
		this(mapBackground, name, null);
		int mapWidth = mapBackground.getWidth(null); //TODO
		int mapHeight = mapBackground.getHeight(null); //TODO
		Dimension gridSize = new Dimension(mapWidth, mapHeight);
		this.gridOverlay = new Grid(gridSize);
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

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

}
