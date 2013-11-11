package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;

/**
 * 
 * @author Moon, Seth
 * @see <a
 *      href="http://paizo.com/pathfinderRPG/prd/gettingStarted.html#strength">Pathfinders
 *      guide on Abilities</a>
 */
public class Abilities {
	public static int SCORE = 0;
	public static int MODIFIER = 1;

	public static enum Ability {
		CHARISMA("CHA"), CONSTITUTION("CON"), DEXTERITY("DEX"), INTELLIGENCE(
				"INT"), STRENGTH("STR"), WISDOM("WIS");

		public final String abbr;

		private Ability(String abbreviation) {
			this.abbr = abbreviation;
		}
	}

	private int[][] abilities;

	public Abilities() {
		abilities = new int[Abilities.Ability.values().length][2];
	}

	/**
	 * Changes an ability to the new values specified.
	 * 
	 * @param ability
	 *            The ability to change
	 * @param score
	 *            The new score value for that ability
	 * @param modifier
	 *            The new modifier value for that ability
	 */
	public void set(Abilities.Ability ability, int score, int modifier) {
		int i = Abilities.indexOf(ability);
		abilities[i][SCORE] = score;
		abilities[i][MODIFIER] = modifier;
	}

	/**
	 * Changes an ability by adding on the new values and modifiers to the
	 * existing one.
	 * 
	 * @param ability
	 *            The ability to alter
	 * @param score
	 *            The amount to alter the score by (can be positive or negative)
	 * @param modifier
	 *            The amount to alter the modifier by (can be positive or
	 *            negative)
	 */
	public void alter(Abilities.Ability ability, int score, int modifier) {
		int i = Abilities.indexOf(ability);
		abilities[i][SCORE] += score;
		abilities[i][MODIFIER] += modifier;
	}

	/**
	 * Retrieves the score of a given ability.
	 * 
	 * @param ability
	 * @return The ability score
	 * @see #getAbility(Ability)
	 */
	public int getScore(Abilities.Ability ability) {
		return getAbility(ability)[SCORE];
	}

	/**
	 * Retrieves the modifier of a given ability.
	 * 
	 * @param ability
	 * @return The ability modifier
	 * @see #getAbility(Ability)
	 */
	public int getModifier(Abilities.Ability ability) {
		return getAbility(ability)[MODIFIER];
	}

	/**
	 * Retrieves both the value and modifier of a given ability.
	 * 
	 * @param ability
	 * @return
	 */
	public int[] getAbility(Abilities.Ability ability) {
		return abilities[Abilities.indexOf(ability)];
	}

	/**
	 * Returns all the abilities in a two dimensional integer array. Each array
	 * corresponds to that index in the Abilities.Ability enumeration. Inside
	 * each ability array, the first value is the score, where as the second is
	 * the modifier.
	 * 
	 * @return All the attribute scores and modifiers.
	 */
	public int[][] getAbilities() {
		return abilities;
	}

	/**
	 * Find the index of a given Ability.
	 * 
	 * @param ability
	 * @return The index of that ability, or -1 if does not exist.
	 * @see Arrays#binarySearch(byte[], byte)
	 */
	public static int indexOf(Abilities.Ability ability) {
		return Arrays.binarySearch(Abilities.Ability.values(), ability);
	}
	
	/**
	 * Merge 2 sets of abilities into one by altering the scores and modifiers.
	 * @param other
	 */
	public void merge(Abilities other) {
		for(Abilities.Ability ability : Abilities.Ability.values()) {
			int[] other_values = other.getAbility(ability);
			this.alter(ability, other_values[SCORE], other_values[MODIFIER]);
		}
	}

	/**
	 * Returns a list of all the abilities, their scores, and their modifiers.
	 */
	@Override
	public String toString() {
		String str = "";
		for (Abilities.Ability ability : Abilities.Ability.values()) {
			// Example: "charisma: 3 (8)" where 3 is the score and 8 is the
			// modifier
			str += String.format("%s: %d (%d)%n", ability.name().toLowerCase(),
					getScore(ability), getModifier(ability));
		}
		return str;
	}

}
