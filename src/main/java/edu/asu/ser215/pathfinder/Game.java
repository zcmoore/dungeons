package edu.asu.ser215.pathfinder;

import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.asu.ser215.pathfinder.core.GameFrame;
import edu.asu.ser215.pathfinder.character.Ability;
import edu.asu.ser215.pathfinder.character.Skill;
import edu.asu.ser215.pathfinder.gui.MainMenu;
import edu.asu.ser215.pathfinder.gui.MainMenu.MainMenuListener;
import edu.asu.ser215.pathfinder.gui.MapScreen;
import edu.asu.ser215.pathfinder.gui.MapScreen.MapScreenListener;
import edu.asu.ser215.pathfinder.inventory.ItemData;
import edu.asu.ser215.pathfinder.inventory.Items;

public class Game extends GameFrame implements MainMenuListener,
		MapScreenListener {

	private static final long serialVersionUID = 1888995364766567859L;
	private static final Dimension PREFERRED_RESOLUTION = new Dimension(1280, 720);
	private static Game currentGame;
	
	private final Ability[] abilityTypes;
	private final Skill[] skillTypes;
	private final ItemData[] allItemData;

	private Game()
	{
		// Set and display game container
		this.changePanel(new MainMenu(this));
		
		// Load and store Abilities and Skills
		Ability.loadAbilities();
		Skill.loadSkills();
		this.abilityTypes = Ability.getScoreTypes();
		this.skillTypes = Skill.getScoreTypes();
		
		// Load and store ItemData
		this.allItemData = Items.loadAllItems();
		
		// Console update
		System.out.println("Game constructor complete.");
	}
	
	public static Game constructGame()
	{
		if (currentGame == null)
			currentGame = new Game();
		
		return currentGame;
	}
	
	public static Game getCurrentGame()
	{
		return constructGame();
	}

	public static void main(String[] args) {
		// Adds the native look and feel to the UI
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException
				| InstantiationException | IllegalAccessException ex) {
			System.out.println("Unable to load native look and feel");
			ex.printStackTrace();
			System.exit(1);
		}
		Game g = constructGame();
		g.setVisible(true);
	}	

	/**
	 * @return a copy of the current Preferred Resolution
	 */
	public static Dimension getPreferredResolution()
	{
		return new Dimension(PREFERRED_RESOLUTION);
	}

	public Ability[] getAbilityTypes() {
		return abilityTypes;
	}

	@Override
	public void startButton() {
		this.changePanel(new MapScreen(this));
	}

	@Override
	public void optionsButton() {
		System.out.println("Options button");
	}

	@Override
	public void characterInspect(String name) {
		// TODO Auto-generated method stub

	}

	public Skill[] getSkillTypes() {
		return skillTypes;
	}

	public ItemData[] getAllItemData() {
		return allItemData;
	}

}
