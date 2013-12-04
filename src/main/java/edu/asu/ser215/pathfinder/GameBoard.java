package edu.asu.ser215.pathfinder;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameBoard extends BasicGameState implements ComponentListener {
	public static final int ID = 1;

	private TextField field;
	private Font font;
	private String message = "Default message";

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		//font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC, 26));
		font = new AngelCodeFont("res/resourcepacks/default/font.fnt","res/resourcepacks/default/font.png");
		field = new TextField(container, font, 150, 150, 500, 35,
				new ComponentListener() {
					public void componentActivated(AbstractComponent source) {
						message = "Entered1: " + field.getText();
					}
				});
		field.setText("WTF");
		field.setFocus(true);
		field.setConsumeEvents(true);
	}

	/**
	 * @see org.newdawn.slick.BasicGameState#keyPressed(int, char)
	 */
	public void keyPressed(int key, char c) {
	}
	

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		field.render(container, g);
		g.setFont(font);
		g.drawString(message, 50, 50);

	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException
	{

	}

	/**
	 * @see org.newdawn.slick.gui.ComponentListener#componentActivated(org.newdawn.slick.gui.AbstractComponent)
	 */
	public void componentActivated(AbstractComponent source) {
		System.out.println("ACTIVL : " + source);
	}

	@Override
	public int getID() {
		return ID;
	}

}
