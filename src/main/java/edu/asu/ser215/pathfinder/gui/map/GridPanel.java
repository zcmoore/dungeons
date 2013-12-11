package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

public class GridPanel extends JPanel
{
	private static final long serialVersionUID = -6066282519842952391L;
	protected Image backgroundImage;
	protected Tile[][] gridTiles;
	protected Dimension buttonSize;
	protected boolean gridIsVisible;
	protected int gridWidth; //in pixels
	protected int gridHeight; //in pixels
	
	/**
	 * Determine number of rows and columns based on provided gridSize and 
	 * buttonSize. Resize backgroundImage to match grid dimension.
	 * 
	 * @param gridSize
	 * @param buttonSize
	 * @param backgroundImage
	 */
	public GridPanel(Dimension gridSize, Dimension buttonSize, Image backgroundImage)
	{
		super();
		this.buttonSize = buttonSize;
		
		// Calculate number of rows and columns based on image size
		int rows = gridSize.height / buttonSize.height;
		int columns = gridSize.width / buttonSize.height;
		
		// Initialize variables
		this.gridTiles = new Tile[rows][columns];
		calculateGridDimensions(rows, columns, buttonSize);
		this.backgroundImage = resizeImage(backgroundImage);
		
		// Format panel
		this.setLayout(new GridLayout(rows, columns, -1, -1));
		
		// Populate
		populateGrid(MapPanel.DEFAULT_GRID_COLOR, MapPanel.DEFAULT_GRID_OPACITY);
	}

	/**
	 * Determine number of rows and columns based on image size.
	 * 
	 * @param buttonSize
	 * @param backgroundImage
	 */
	public GridPanel(Dimension buttonSize, Image backgroundImage)
	{
		super();
		this.buttonSize = buttonSize;
		
		// Calculate number of rows and columns based on image size
		int rows = backgroundImage.getHeight(null) / buttonSize.height;
		int columns = backgroundImage.getHeight(null) / buttonSize.height;
		
		// Initialize variables
		this.gridTiles = new Tile[rows][columns];
		calculateGridDimensions(rows, columns, buttonSize);
		this.backgroundImage = resizeImage(backgroundImage);
		
		// Format panel
		this.setLayout(new GridLayout(rows, columns, -1, -1));
		
		// Populate
		populateGrid(MapPanel.DEFAULT_GRID_COLOR, MapPanel.DEFAULT_GRID_OPACITY);
	}
	
	/**
	 * Resizes the backgroundImage to fit the specified rows, 
	 * columns and dimension
	 * 
	 * @param rows
	 * @param columns
	 * @param buttonSize
	 * @param backgroundImage
	 */
	public GridPanel(int rows, int columns, Dimension buttonSize, Image backgroundImage)
	{
		super();
		this.buttonSize = buttonSize;
		this.gridTiles = new Tile[rows][columns];
		calculateGridDimensions(rows, columns, buttonSize);
		this.backgroundImage = resizeImage(backgroundImage);
		this.setLayout(new GridLayout(rows, columns, -1, -1));
		
		// Populate
		populateGrid(MapPanel.DEFAULT_GRID_COLOR, MapPanel.DEFAULT_GRID_OPACITY);
	}
	
	private Image resizeImage(Dimension newSize, Image baseImage)
	{
		// Ensure that current dimensions are accurate
		// Replace with variables
		calculateGridDimensions(gridTiles.length, gridTiles[0].length, buttonSize);
		
		return baseImage.getScaledInstance(newSize.width, newSize.height, Image.SCALE_SMOOTH);
	}
	
	/**
	 * Returns a resized copy of the given image at the current resolution 
	 * of this GridPanel.
	 * 
	 * @param baseImage
	 * @return
	 * @see #resizeImage(Dimension, Image)
	 */
	private Image resizeImage(Image baseImage)
	{
		return resizeImage(new Dimension(gridWidth, gridHeight), baseImage);
	}
	
	private void populateGrid(Color gridColor, float gridOpacity)
	{
		gridIsVisible = Tile.DEFAULT_GRID_PAINTED;
		
		// 
		for (int row = 0; row < gridTiles.length; row++)
		{
			for (int column = 0; column < gridTiles[0].length; column++)
			{
				Tile tile = new Tile(this, new Point(row, column), gridColor, gridOpacity);
				tile.setPreferredSize(buttonSize);
				this.add(tile);
			}
		}
	}
	
	private Dimension calculateGridDimensions(int rows, int columns,
			Dimension buttonSize) {
		// Calculate base dimensions
		this.gridWidth = columns * buttonSize.width;
		this.gridHeight = rows * buttonSize.height;
		
		// Account for borders
		this.gridWidth += columns + 1;
		this.gridHeight += rows + 1;
		
		return new Dimension(gridWidth, gridHeight);
	}
	
	public void paintComponent(Graphics graphics)
	{
	    super.paintComponent(graphics);
	    
	    if (backgroundImage != null)
	    	graphics.drawImage(backgroundImage, 0, 0, null);
	}
	
	public void fitBackgroundImage()
	{
		this.backgroundImage = backgroundImage.getScaledInstance
				(this.getGridWidth(), this.getGridHeight(), Image.SCALE_SMOOTH);
	}
	
	public void enableGrid()
	{
		setGridVisability(true);
	}
	
	public void disableGrid()
	{
		setGridVisability(false);
	}
	
	public void setGridVisability(boolean isGridVisible)
	{
		for (Tile[] tiles : gridTiles)
		{
			for (Tile tile : tiles)
			{
				tile.setBorderPainted(isGridVisible);
			}
		}
		
		gridIsVisible = isGridVisible;
	}
	
	public void toggleGridVisability()
	{
		this.setGridVisability(!gridIsVisible);
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public Tile[][] getGridTiles() {
		return gridTiles;
	}

	public Dimension getButtonSize() {
		return buttonSize;
	}
	
	public boolean isGridVisible()
	{
		return this.gridIsVisible;
	}
	
	
}
