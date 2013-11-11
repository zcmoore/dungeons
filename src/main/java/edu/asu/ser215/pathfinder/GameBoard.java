package edu.asu.ser215.pathfinder;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameBoard extends BasicGameState {
	public static final int ID = 1;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		//System.out.println("Hello");
		
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Inside Game Board", 50, 50);
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return GameBoard.ID;
	}

}
