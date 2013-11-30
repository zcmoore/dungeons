package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;

public class Grid 
{
	public static final int DEFAULT_GRID_WIDTH = 20; //in pixels
	public static final Dimension DEFAULT_TOP_LEFT_CORNER = new Dimension(0, 0);
	
	private int gridWidth; //in pixels
	private Dimension topLeftOffset; //location of the topleft corner of the 
						//grid in relation to the topleft corner of the screen
	private Dimension bottomRightOffset; //location of the bottomright corner 
						//of the grid in relation to the bottomright 
						//corner of the screen
	
	public Grid(Dimension screenSize)
	{
		this.topLeftOffset = Grid.DEFAULT_TOP_LEFT_CORNER;
		this.bottomRightOffset = screenSize;
		this.gridWidth = Grid.DEFAULT_GRID_WIDTH;
	}
	
	public Grid(int gridWidth, Dimension screenSize)
	{
		this.topLeftOffset = Grid.DEFAULT_TOP_LEFT_CORNER;
		this.bottomRightOffset = screenSize;
		this.gridWidth = gridWidth;
	}
	
	public Grid(int gridWidth, Dimension topLeftOffset,
			Dimension bottomRightOffset) {
		super();
		this.gridWidth = gridWidth;
		this.topLeftOffset = topLeftOffset;
		this.bottomRightOffset = bottomRightOffset;
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public Dimension getTopLeftOffset() {
		return topLeftOffset;
	}

	public void setTopLeftOffset(Dimension topLeftOffset) {
		this.topLeftOffset = topLeftOffset;
	}

	public Dimension getBottomRightOffset() {
		return bottomRightOffset;
	}

	public void setBottomRightOffset(Dimension bottomRightOffset) {
		this.bottomRightOffset = bottomRightOffset;
	}

	public static int getDefaultGridWidth() {
		return DEFAULT_GRID_WIDTH;
	}

	public static Dimension getDefaultTopLeftCorner() {
		return DEFAULT_TOP_LEFT_CORNER;
	}
	
	
}
