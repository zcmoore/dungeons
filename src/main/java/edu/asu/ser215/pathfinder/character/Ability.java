package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;

/**
 * 
 * @author Moon, Seth
 * @see <a
 *      href="http://paizo.com/pathfinderRPG/prd/gettingStarted.html#strength">Pathfinders
 *      guide on Abilities</a>
 */
public class Ability 
{
	public static int SCORE = 0;
	public static int MODIFIER = 1;

	private int[][] abilities;

	public Ability() 
	{
		//TODO rewrite
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
	public void set(/*Ability.Ability ability, int score, int modifier*/)
	{
		//TODO rewrite
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
	public void alter(/*Ability.Ability ability, int score, int modifier*/)
	{
		//TODO rewrite
	}

	/**
	 * Retrieves the score of a given ability.
	 * 
	 * @param ability
	 * @return The ability score
	 * @see #getAbility(Ability)
	 */
	public int getScore(/*Ability.Ability ability*/)
	{
		//TODO rewrite
		return 0;
	}

	/**
	 * Retrieves the modifier of a given ability.
	 * 
	 * @param ability
	 * @return The ability modifier
	 * @see #getAbility(Ability)
	 */
	public int getModifier(/*Ability.Ability ability*/)
	{
		//TODO rewrite
		return 0;
	}

	/**
	 * Retrieves both the value and modifier of a given ability.
	 * 
	 * @param ability
	 * @return
	 */
	public int[] getAbility(/*Ability.Ability ability*/)
	{
		//TODO rewrite
		return null; //abilities[Ability.indexOf(ability)];
	}

	/**
	 * Returns all the abilities in a two dimensional integer array. Each array
	 * corresponds to that index in the Abilities.Ability enumeration. Inside
	 * each ability array, the first value is the score, where as the second is
	 * the modifier.
	 * 
	 * @return All the attribute scores and modifiers.
	 */
	public int[][] getAbilities()
	{
		//TODO rewrite
		return abilities;
	}

	/**
	 * Find the index of a given Ability.
	 * 
	 * @param ability
	 * @return The index of that ability, or -1 if does not exist.
	 * @see Arrays#binarySearch(byte[], byte)
	 */
	public static int indexOf(/*Ability.Ability ability*/)
	{
		//TODO rewrite
		return 0; //Arrays.binarySearch(Ability.Ability.values(), ability);
	}

	/**
	 * Returns a list of all the abilities, their scores, and their modifiers.
	 */
	@Override
	public String toString() 
	{
		//TODO rewrite
		// Example: "charisma: 3 (8)" where 3 is the score and 8 is the
		// modifier
		return "";
	}

}
