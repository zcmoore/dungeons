package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import edu.asu.ser215.pathfinder.Game;

public class Tile extends JButton
{
	public static final String DEFAULT_HIGHLIGHT_OVERLAY_PATH = "res/resourcepacks/default/img/defaultHighlightOverlay.png";
	
	private static final long serialVersionUID = 2912498800341073089L;
	private static Tile selectedTile;
	private static Image highlightOverlay = defaultHighlightOverlay(); //overlay this image onto a tile if it is currently highlighted
	private static Image baseImage = null; //base image for all tiles //default is none
	
	protected final GridPanel associatedPanel;
	protected final Point gridLocation; //coordinates on the associated grid of this tile
	protected boolean highlighted; //should this tile be highlighted
	protected GameBoardToken token; //token that currently occupies this square //null for an empty tile
	
	public Tile(GridPanel associatedPanel, Point gridLocation, Color gridColor, float gridOpacity)
	{
		this(associatedPanel, gridLocation, null, gridColor, gridOpacity);
	}
	
	public Tile(GridPanel associatedPanel, Point gridLocation, GameBoardToken token, Color gridColor, float gridOpacity)
	{
		this(associatedPanel, gridLocation, token, false, gridColor, gridOpacity, null);
	}
	
	public Tile(GridPanel associatedPanel, Point gridLocation, GameBoardToken token, 
			boolean highlighted, Color gridColor, float gridOpacity, 
			ActionListener buttonListener)
	{
		// Initialize variables
		this.token = token;
		this.highlighted = false;
		this.associatedPanel = associatedPanel;
		this.gridLocation = gridLocation;
		
		this.associatedPanel.getGridTiles()[gridLocation.x][gridLocation.y] = this;

        // Make button invisible
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setFocusPainted(false);
		
        // Set border
        Color modifiedGridColor = new Color(gridColor.getRed(), gridColor.getGreen(), gridColor.getBlue(), (int) (gridOpacity*255));
        Border gridLines = BorderFactory.createLineBorder(modifiedGridColor);
        this.setBorder(gridLines);
        this.setBorderPainted(true);
        
        // Set icon based on the current token and baseImage values
        updateIcon();
  		
        // If listener is null, add the default listener
        if (buttonListener == null)
        	this.addActionListener(new TileListener(this));
        else
        	this.addActionListener(buttonListener);
	}
	
	public void paintComponent(Graphics graphics)
	{
	    super.paintComponent(graphics);
	    
	    if (highlighted && (highlightOverlay != null))
	    	graphics.drawImage(highlightOverlay, 0, 0, null);
	}
	
	public void updateIcon()
	{
		//Token takes precedence over based image
		if (!(token == null))
          	super.setIcon(token.getIcon());
        else if (!(baseImage == null))
          	super.setIcon(new ImageIcon(baseImage));
        else
        	super.setIcon(null);
		
	}
	
	private static Image defaultHighlightOverlay()
	{
		BufferedImage image = null;
		
		try
		{
			image = ImageIO.read(new File(DEFAULT_HIGHLIGHT_OVERLAY_PATH));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
	}
	
	public static Image getBaseImage()
	{
		return baseImage;
	}

	public static void setBaseImage(Image baseImage)
	{
		//TODO update all Tiles
		Tile.baseImage = baseImage;
	}

	public static Image getHighlightOverlay()
	{
		return highlightOverlay;
	}

	public static void setHighlightOverlay(Image highlightOverlay)
	{
		//TODO update all Tiles
		Tile.highlightOverlay = highlightOverlay;
	}

	public boolean isHighlighted()
	{
		return highlighted;
	}

	public void setHighlighted(boolean highlighted)
	{
		this.highlighted = highlighted;
	}

	public GameBoardToken getToken() {
		return token;
	}

	public void setToken(GameBoardToken token)
	{
		this.token = token;
		
		// update icon
		updateIcon();
	}
	
	public static Tile getSelectedTile()
	{
		return selectedTile;
	}
	
	public void alterHighlightOfSurroundingTiles(boolean highlighted)
	{
		if (this.hasToken())
		{
			Tile[][] grid = this.associatedPanel.getGridTiles();
			int range = token.getHighlightRange();
			
			// Boundaries of the potential range area
			// Minimums and Maximums are INCLUSIVE
			int maxRow = gridLocation.x + range;
			int minRow = gridLocation.x - range;
			int maxColumn = gridLocation.y + range;
			int minColumn = gridLocation.y - range;
			
			// Adjust boundaries to ensure they are within the grid
			if (maxColumn >= grid[0].length)
				maxColumn = grid[0].length - 1;
			if (minColumn < 0)
				minColumn = 0;
			if (maxRow >= grid.length)
				maxRow = grid.length - 1;
			if (minRow < 0)
				minRow = 0;
			
			//TODO optimize to check only grid squares outside of the inner PHI square
			for (int row = minRow; row <= maxRow; row++)
			{
				for (int column = minColumn; column <= maxColumn; column++)
				{
					if (roundedDistance(this.gridLocation, row, column) <= range)
						grid[row][column].setHighlighted(highlighted);
				}
			}
		}
	}
	
	public static int roundedDistance(Point pointA, int x2, int y2)
	{
		return (int) Math.round(Math.sqrt(Math.pow((pointA.x - x2), 2) + Math.pow((pointA.y - y2), 2)));
	}
	
	public void toggleHighlight()
	{
		this.setHighlighted(!isHighlighted());
	}
	
	public boolean hasToken()
	{
		return (this.token != null);
	}

	/**
	 * @return a copy of this tile's grid location
	 */
	public Point getGridLocation()
	{
		return new Point(gridLocation);
	}
	
	public static void transferToken(Tile source, Tile target) throws TileIsFullException
	{
		if ((source != null) && (target != null))
		{
			if (source.token != null)
			{
				if (target.token == null)
				{
					target.setToken(source.token);
					source.setToken(null);
				}
				else
				{
					System.out.println("TileIsFullException Thrown");
					throw new TileIsFullException("Cannot move token: Target tile is already ocupied");
				}
			}
		}
	}
	
	public static void clearSlelectedTile()
	{
		// Clear highlighting from all tiles within the movement radius of the selected tile's token
		Tile.selectedTile.alterHighlightOfSurroundingTiles(false);
		
		// Deselect the tile
		Tile.selectedTile = null;
		
		// Display changes
		Game.getCurrentGame().repaint();
	}

	public static class TileListener implements ActionListener
	{
		Tile tileReference; //the tile that this is listening to
		
		public TileListener(Tile tileReference)
		{
			this.tileReference = tileReference;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Update console
			System.out.println("Tile Clicked");
			
			// Act differently depending on the current state of the tile
			if (tileReference.hasToken())
				actOnToken();
			else
				actOnEmptyTile();
		}
		
		private void actOnEmptyTile()
		{
			if (tileReference.isHighlighted() && (Tile.selectedTile != null))
			{
				// Clear highlighting from all tiles within the movement radius of the selected tile's token
				Tile.selectedTile.alterHighlightOfSurroundingTiles(false);
				
				// Move selected token to this tile
				try
				{
					Tile.transferToken(Tile.selectedTile, tileReference);
				}
				catch (TileIsFullException e)
				{
					System.out.println("Did not move token: " + e.getMessage());
				}
				
				// Deselect the tile
				Tile.selectedTile = null;
				
				// Display changes
				Game.getCurrentGame().repaint();
				
				//TODO make inventory tokens immobile
			}
			
			// There is a selected tile, but this tile is out of range
			else if ((Tile.selectedTile != null))
			{
				Tile.clearSlelectedTile();
			}
		}
		
		private void actOnToken()
		{
			// No tile is currently selected
			if (Tile.selectedTile == null)
			{
				tileReference.toggleHighlight();
				
				// Highlight all tiles within the movement radius of this tile's token
				tileReference.alterHighlightOfSurroundingTiles(true);
				
				// Select this tile
				Tile.selectedTile = tileReference;
				
				// Display changes
				Game.getCurrentGame().repaint();
			}
			
			// This tile is currently selected
			else if(Tile.selectedTile == this.tileReference)
			{
				Tile.clearSlelectedTile();
			}
			
			// A different tile is currently selected, and within range
			else if (tileReference.isHighlighted())
			{
				//TODO add support for player trade, looting, and combat
				Tile.clearSlelectedTile();
			}
			
			// A different tile is currently selected, and out of range
			else
			{
				// Update console
				System.out.println("Target is out of range");
				
				Tile.clearSlelectedTile();
			}
			
		}
	}
	
	public static class TileIsFullException extends Exception
	{
		private static final long serialVersionUID = -5912135337755484604L;
		
		public TileIsFullException()
		{
			super("Tile is full.");
		}
		
		public TileIsFullException(String message)
		{
			super(message);
		}
	}
}
