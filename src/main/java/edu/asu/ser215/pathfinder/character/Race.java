package edu.asu.ser215.pathfinder.character;

/**
 * A singleton class that represents all the available races in the game.
 * 
 * @author Moon, Seth
 * 
 */
public class Race {
	private static Race[] races;

	private String name;
	private Abilities abilities;
	private Race.Size size;

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
	 * Private constructor to prevent any external objects.
	 */
	private Race() {
	}
	
	public static int get(String race) {
		// TODO: Check if races has been initialized
		for(int i = 0; i < Race.races.length; i++) {
			if(Race.races[i].name.equalsIgnoreCase(race)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Given an array of names, abilities, and sizes, create a static array of
	 * races if none yet exists.
	 * 
	 * @param names Names of each race
	 * @param abilities Abilities of each race
	 * @param sizes Sizes of each race
	 */
	public static void setRaces(String[] names, Abilities[] abilities, Race.Size[] sizes) {
		if (Race.races == null) {
			if (names.length == abilities.length && abilities.length == sizes.length) {
				Race.races = new Race[names.length];
				for (int race = 0; race < names.length; race++) {
					Race.races[race].name = names[race];
					Race.races[race].abilities = abilities[race];
					Race.races[race].size = sizes[race];
				}
			}
		}
	}
}
