package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JPanel;

public class MapPanel extends JPanel
{
	private static final long serialVersionUID = -5815553248180040761L;
	public static final float DEFAULT_GRID_OPACITY = 0.2F;

	private GridPanel gridPanel;
	
	/**
	 * Constructs a MapPanel object with the specified background image and
	 * grid size.
	 * 
	 * @param backgroundImage	Image to display underneath the grid
	 * @param width				Width of the grid in tiles
	 * @param height			Height of the grid in tiles
	 */
	public MapPanel(Image backgroundImage, Dimension mapPanelDimension, Dimension buttonSize)
	{
		// Construct this panel with default layout // Preferred sizes are respected
		super();
		
		// Construct grid to be the size of mapPanelDimension, with tiles
		// resolved at buttonSize.
		this.gridPanel = new GridPanel(mapPanelDimension, buttonSize, backgroundImage);
		
		//TODO remove test
		getGridTiles()[5][5].setToken(new GameBoardToken(GameBoardToken.DefaultIcons.playerToken));
		getGridTiles()[5][6].setToken(new GameBoardToken(GameBoardToken.DefaultIcons.playerToken));
		
		this.add(gridPanel);
		gridPanel.enableGrid();
		gridPanel.disableGrid();
	}

	public Tile[][] getGridTiles()
	{
		return gridPanel.getGridTiles();
	}
	
	
}
