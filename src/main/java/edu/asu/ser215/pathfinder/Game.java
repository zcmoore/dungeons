package edu.asu.ser215.pathfinder;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.asu.ser215.pathfinder.gui.MainMenu;
import edu.asu.ser215.pathfinder.gui.MainMenu.MainMenuListener;
import edu.asu.ser215.pathfinder.gui.MapScreen;
import edu.asu.ser215.pathfinder.gui.MapScreen.MapScreenListener;

public class Game extends JFrame implements MainMenuListener, MapScreenListener {

	private static final long serialVersionUID = 1888995364766567859L;

	public Game() {
		this.setContentPane(new MainMenu(this));
		this.pack();
	}

	public static void main(String[] args) {
		// Adds the native look and feel to the UI
		try {
		    UIManager.setLookAndFeel(
		        UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
		  System.out.println("Unable to load native look and feel");
		}
		Game g = new Game();
		g.setVisible(true);
	}

	@Override
	public void startButton() {
		System.out.println("Start Button pressed");
		this.setContentPane(new MapScreen(this));
		this.pack();
		this.repaint();
	}

	@Override
	public void optionsButton() {
		System.out.println("Options button");
	}

}
