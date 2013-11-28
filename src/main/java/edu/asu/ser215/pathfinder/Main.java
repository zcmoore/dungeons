package edu.asu.ser215.pathfinder;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Hello world!
 * 
 */
public class Main extends StateBasedGame {
	public static final int WINDOW_WIDTH = 1280;
	public static final int WINDOW_HEIGHT = 720;
	public static final String GAME_TITLE = "Dungeon";
	// List of Game States that should be initialized
	// NOTE: These states MUST be added in the constructor first
	// TODO: Class loading
	public static final int[] GAME_STATES = { MainMenu.ID, GameBoard.ID };
	// Default Game State to enter upon launching the application
	public static final int DEFAULT_GAME_STATE = MainMenu.ID;

	public Main() {
		super(GAME_TITLE);
		this.addState(new MainMenu());
		this.addState(new GameBoard());
		System.out.println("Constructor finished.");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer game = new AppGameContainer(new Main());
		// app.setShowFPS(false);
		game.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
		game.setForceExit(false);
		game.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// Initialize all the game states
		for (int state : Main.GAME_STATES) {
			this.getState(state).init(container, this);
		}
		// Move to the default game state
		this.enterState(Main.DEFAULT_GAME_STATE);
	}
}
