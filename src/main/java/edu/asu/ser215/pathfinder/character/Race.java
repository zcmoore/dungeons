package edu.asu.ser215.pathfinder.character;

import java.util.HashMap;

/**
 * A singleton class that represents all the available races in the game.
 * 
 * @author Moon, Seth
 * 
 */
public class Race 
{
	private static HashMap<String, Race> raceMap;

	private String name;
	private ScoreList<AbilityType> abilities;
	private Race.Size size;
	private int ac_modifier; // Armor class modifier
	private double space; // Amount of space on the board
	private int natural_reach; // How far the race can naturally reach

	/**
	 * Different sizes for each race as well as some sane defaults for armor
	 * class modifiers, space on board, and natural reach (assumes tall).
	 * 
	 * @author Moon, Seth
	 * 
	 */
	public static enum Size {
		FINE(8, .5, 0),
		DIMINUTIVE(4, 2, 0),
		TINY(2, 2.5, 0),
		SMALL(1, 5, 5),
		MEDIUM(0, 5, 5),
		LARGE(-1, 10, 10),
		HUGE(-2, 15, 15),
		GARGANTUAN(-4, 20, 20),
		COLOSSAL(-8, 30, 30);
		
		public final int ac_modifier; // Armor Class modifier
		public final double space; // space on board
		public final int natural_reach;

		private Size(int modifier, double space, int natural_reach) {
			this.ac_modifier = modifier;
			this.space = space;
			this.natural_reach = natural_reach;
		}
	}

	/**
	 * Creates a new race with the given attributes.
	 * @param name The name of the race
	 * @param abilities List of default abilities the race may have
	 * @param size The size of the race
	 * @param ac_modifier Armor class modifier
	 * @param space Amount of space on the board.
	 */
	private Race(
			String name, ScoreList<AbilityType> abilities, Race.Size size,
			int ac_modifier, double space, int natural_reach) {
		this.name = name;
		this.abilities = abilities;
		this.size = size;
		this.ac_modifier = ac_modifier;
		this.space = space;
		this.natural_reach = natural_reach;
	}
	
	/**
	 * Adds a new Race to the HashMap
	 * @param name The name of the race
	 * @param abilities List of default abilities the race may have
	 * @param size The size of the race
	 * @param ac_modifier Armor class modifier
	 * @param space Amount of space on the board.
	 * @param natural_reach How far the race can reach
	 */
	public static void add(
			String name, ScoreList<AbilityType> abilities, Race.Size size,
			int ac_modifier, double space, int natural_reach) {
		if(raceMap == null)
			raceMap = new HashMap<String, Race>();
		if(!raceMap.containsKey(name)) {
			Race race = new Race(name, abilities, size, ac_modifier, space, natural_reach);
			raceMap.put(name, race);
		}
	}
	
	/**
	 * Similar to the other add function except it uses the default armor class
	 * modifier, space, and natural reach from the size.
	 * @see Race#add(String, Ability, Size, int, double, int)
	 */
	public static void add(
			String name, ScoreList<AbilityType> abilities, Race.Size size) {
		Race.add(name, abilities, size, size.ac_modifier, size.space, size.natural_reach);
	}
	
	/**
	 * Retrieves a race from the raceMap
	 * @param race
	 * @return The Race
	 */
	public static Race get(String race) {
		if(raceMap == null)
			raceMap = new HashMap<String, Race>();
		if(raceMap.containsKey(race))
			return raceMap.get(race);
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public ScoreList<AbilityType> getAbilities() {
		return abilities;
	}
	
	public Race.Size getSize() {
		return size;
	}
	
	public int getACModifier() {
		return ac_modifier;
	}
	
	public double getSpace() {
		return space;
	}
	
	public int getNaturalReach() {
		return natural_reach;
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * Looking for setters? Well there aren't any as races are determined only once.
	 * We don't support the evolution of races attributes and abilities.
	 */
	
}
