package edu.asu.ser215.pathfinder.gui.map;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

public class GridPanel extends JPanel
{
	private static final long serialVersionUID = -6066282519842952391L;
	private Image backgroundImage;
	
	public GridPanel(int rows, int columns, Image backgroundImage)
	{
		super(new GridLayout(rows, columns));
		this.backgroundImage = backgroundImage;
	}
	
	public void paintComponent(Graphics graphics)
	{
	    super.paintComponent(graphics);
	    
	    if (backgroundImage != null)
	    	graphics.drawImage(backgroundImage, 0, 0, null);
	}
}
