package edu.asu.ser215.pathfinder;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
	public static final int ID = 0;

	private Image demo;
	private int demoX = 200, demoY = 200;
	private int delta = 1;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException 
	{
		demo = new Image("res/resourcepacks/default/img/orc.png");
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawImage(demo, demoX, demoY);
		g.fillOval(75, 100, 100, 100);
		g.drawString("Play Now", 80, 80);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();
		int xpos = Mouse.getX();
		int ypos = Main.WINDOW_HEIGHT - Mouse.getY();
		if ((xpos > 75 && xpos < 175) && (ypos > 100 && ypos < 200)) {
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				game.enterState(GameBoard.ID);
			}
		}
	}

	@Override
	public int getID() {
		return MainMenu.ID;
	}

}
