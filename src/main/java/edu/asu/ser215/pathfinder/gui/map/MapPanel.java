package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

public class MapPanel extends JPanel
{
	private static final long serialVersionUID = -5815553248180040761L;
	protected Image backgroundImage;
	protected Tile[][] gridTiles;
	protected Dimension buttonSize;
	
	/**
	 * Constructs a MapPanel object with the specified background image and
	 * grid size.
	 * 
	 * @param backgroundImage	Image to display underneath the grid
	 * @param width				Width of the grid in tiles
	 * @param height			Height of the grid in tiles
	 */
	public MapPanel(Image backgroundImage, int rows, int columns, Dimension buttonSize)
	{
		// Construct this panel with a grid layout
		super();
		this.backgroundImage = backgroundImage;
		this.buttonSize = buttonSize;
		this.gridTiles = new Tile[rows][columns];
		JPanel innerPanel = new GridPanel(rows, columns, backgroundImage);
		
		// Tiles
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				Tile tile = new Tile(this, new Point(row, column));
				//TODO move sizing code to Tile class
				tile.setPreferredSize(buttonSize);
				innerPanel.add(tile);
			}
		}
		
		//TODO remove test
		gridTiles[5][5].setToken(new GameBoardToken(GameBoardToken.DefaultIcons.playerToken));
		gridTiles[10][5].setToken(new GameBoardToken(GameBoardToken.DefaultIcons.playerToken));
		
		this.add(innerPanel);
	}

	public Tile[][] getGridTiles()
	{
		return gridTiles;
	}
	
	
}
