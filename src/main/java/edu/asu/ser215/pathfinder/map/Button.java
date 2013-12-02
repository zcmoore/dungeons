package edu.asu.ser215.pathfinder.map;

import java.awt.Dimension;
import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;

/**
 * Abstract class to provide the functionality of a button. Each button object
 * will be associated with an image and a position on the screen. All implementations
 * of button should define what happens when the button is clicked in the act method.
 * 
 * Button provides the implementation for checkClicked() which determines if the
 * button was clicked, and calls the act method if it was. Note: it is the responsibility
 * of the container class of Button objects to call the checkClicked method every frame.
 * 
 * @author Zach Moore
 *
 */
public abstract class Button 
{
	private int width; //in pixels
	private int height; //in pixels
	protected GameContainer container; //container holding this button
	protected StateBasedGame game; //game associated with this button
	protected Image icon;
	protected Point coordinates; //coordinates at which to display //in pixels
	
	/**
	 * Button is abstract, and should therefore only be instantiated by subclasses
	 * of Button.
	 * 
	 * @param container		the container this button is held in
	 * @param game			the game associated with this button
	 * @param icon			how this button should appear to the user
	 * @param coordinates	the coordinates of this button in pixels
	 */
	protected Button(GameContainer container, StateBasedGame game, 
			Image icon, Point coordinates) 
	{
		super();
		this.icon = icon;
		this.coordinates = coordinates;
		this.width = icon.getWidth();
		this.height = icon.getHeight();
	}

	protected abstract void act();
	
	/**
	 * Determines if the button was clicked based on the current Mouse location,
	 * and runs this buttons act() method if the button was clicked. Will return
	 * true if this button was clicked; false otherwise.
	 * 
	 * @return whether or not this button was clicked, and ran its act method.
	 */
	public boolean checkClicked()
	{
		boolean wasClicked;
		
		wasClicked = Mouse.getX() 	>= (this.coordinates.x) 				&& 
					 Mouse.getX() 	<= (this.coordinates.x + this.width) 	&& 
					 Mouse.getY() 	<= (this.coordinates.y + this.height) 	&& 
					 Mouse.getY() 	>= (this.coordinates.y);
					 
		if (wasClicked)
			act();
		
		return wasClicked;
	}

	public Image getIcon() 
	{
		return icon;
	}

	/**
	 * This method will recalculate the width and height of the button to match
	 * the new icon specifications.
	 * 
	 * @param icon 		new icon
	 */
	public void setIcon(Image icon) 
	{
		this.icon = icon;
		
		//reset height and width to match new width and height
		this.width = icon.getWidth();
		this.height = icon.getHeight();
	}

	public Point getCoordinates() 
	{
		return coordinates;
	}

	public void setCoordinates(Point coordinates) 
	{
		this.coordinates = coordinates;
	}
	
	public Dimension getButtonDimension()
	{
		return new Dimension(this.width, this.height);
	}
	
	
}
