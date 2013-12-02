package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;
import java.awt.Point;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Grid
{
	public static final int DEFAULT_SQUARE_WIDTH = 20; //in pixels
	public static final Point DEFAULT_TOP_LEFT_CORNER = new Point(0, 0);
	
	private Image gridImage;
	private Image tokenOverlay;
	private int squareWidth; //in pixels //width of one grid square
	private Point topLeftOffset; //location of the topleft corner of the 
						//grid relative to the topleft corner of the screen
	private Dimension gridSize; //size of the grid
	
	public Grid(int squareWidth, Point topLeftOffset, Dimension screenSize) throws SlickException
	{
		this.squareWidth = squareWidth;
		this.topLeftOffset = topLeftOffset;
		
		int gridWidth = screenSize.width - Math.abs(topLeftOffset.x);
		int gridHeight = screenSize.height - Math.abs(topLeftOffset.y);
		this.gridSize = new Dimension(gridWidth, gridHeight);
		
		drawGridImage();
	}
	
	public Grid(int squareWidth, Dimension gridSize) throws SlickException
	{
		this(squareWidth, DEFAULT_TOP_LEFT_CORNER, gridSize);
	}
	
	public Grid(Dimension gridSize) throws SlickException
	{
		this(DEFAULT_SQUARE_WIDTH, DEFAULT_TOP_LEFT_CORNER, gridSize);
	}
	
	private void drawGridImage() throws SlickException
	{
		this.gridImage = new Image(gridSize.width, gridSize.height);
		Point lineStart = new Point(0, 0);
		Point lineEnd = new Point(0, gridSize.height);
		
		//Draw vertical lines across the grid
		while (lineStart.x <= gridSize.width)
		{
			gridImage.getGraphics().drawLine(lineStart.x, lineStart.y, lineEnd.x, lineEnd.y);
			
			//set the next line to be drawn equidistant from the previous point
			lineStart.translate(this.squareWidth, 0);
			lineEnd.translate(this.squareWidth, 0);
		}
		
		//Draw horizontal lines across the grid
		lineStart = new Point(0, 0);
		lineEnd = new Point(gridSize.width, 0);
		while (lineStart.y <= gridSize.height)
		{
			gridImage.getGraphics().drawLine(lineStart.x, lineStart.y, lineEnd.x, lineEnd.y);
			
			//set the next line to be drawn equidistant from the previous point
			lineStart.translate(0, this.squareWidth);
			lineEnd.translate(0, this.squareWidth);
		}
	}
	
	private void drawTokenOverlay() throws SlickException
	{
		//TODO method body
	}
	
	public void snapTokensToGrid() throws SlickException
	{
		//TODO method body
	}
	
	public void drawGrid(Graphics g)
	{
		g.drawImage(this.gridImage, this.topLeftOffset.x, this.topLeftOffset.y);
	}
	
	public int getXOffset()
	{
		return this.topLeftOffset.x;
	}
	
	public int getYOffset()
	{
		return this.topLeftOffset.y;
	}

	public Image getGridImage() {
		return gridImage;
	}

	public int getSquareWidth() {
		return squareWidth;
	}

	public Point getTopLeftOffset() {
		return topLeftOffset;
	}

	public Dimension getGridSize() {
		return gridSize;
	}

	public Image getTokenOverlay() {
		return tokenOverlay;
	}
	
	
	
}
