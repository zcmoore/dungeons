package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.asu.ser215.pathfinder.Game;

public class Tile extends JButton
{
	public static final String DEFAULT_HIGHLIGHT_OVERLAY_PATH = "res/resourcepacks/default/img/defaultHighlightOverlay.png";
	
	private static final long serialVersionUID = 2912498800341073089L;
	private static Tile selectedTile;
	private static Image highlightOverlay = defaultHighlightOverlay(); //overlay this image onto a tile if it is currently highlighted
	private static Image baseImage = null; //base image for all tiles //default is none
	
	protected MapPanel associatedPanel;
	protected Point gridLocation; //coordinates on the associated grid of this tile
	protected boolean highlighted; //should this tile be highlighted
	protected GameBoardToken token; //token that currently occupies this square //null for an empty tile
	
	public Tile(MapPanel associatedPanel, Point gridLocation)
	{
		this(associatedPanel, gridLocation, null);
	}
	
	public Tile(MapPanel associatedPanel, Point gridLocation, GameBoardToken token)
	{
		this(associatedPanel, gridLocation, token, false, null);
  		
	}
	
	public Tile(MapPanel associatedPanel, Point gridLocation, GameBoardToken token, 
			boolean highlighted, ActionListener buttonListener)
	{
		// Initialize variables
		this.token = token;
		this.highlighted = false;
		this.associatedPanel = associatedPanel;
		this.gridLocation = gridLocation;
		
		this.associatedPanel.gridTiles[gridLocation.x][gridLocation.y] = this;
		
		// Make button invisible
		this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setFocusPainted(false);
        
        // Set icon based on the current token and baseImage values
        updateIcon();
  		
        // If listener is null, add the default listener
        	//Default is TokenListener if this tile contains a token; null otherwise
        if ((buttonListener == null) && (token != null))
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
		Game.getCurrentGame().repaint();
	}

	public GameBoardToken getToken() {
		return token;
	}

	public void setToken(GameBoardToken token)
	{
		this.token = token;
		
		// update icon
		updateIcon();
		
		// add TokenListener
		if (token != null)
			this.addActionListener(new TileListener(this));
		else
			//TODO account for multiple listeners
			this.removeActionListener(this.getActionListeners()[0]);
	}
	
	public static Tile getSelectedTile()
	{
		return selectedTile;
	}
	
	public void alterHighlightOfSurroundingTiles(boolean highlighted)
	{
		if (this.token != null)
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
		return (int) Math.round(Math.sqrt(Math.pow((pointA.x - x2) + (pointA.y - y2), 2)));
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
			// TODO Auto-generated method stub
			System.out.println("Tile with Token Clicked");
			if (Tile.selectedTile == null)
			{
				tileReference.setHighlighted(true);
				tileReference.alterHighlightOfSurroundingTiles(true);
				Tile.selectedTile = tileReference;
			}
			
			if (tileReference.isHighlighted())
				tileReference.setHighlighted(false);
			else
				tileReference.setHighlighted(true);
		}
	}
}
