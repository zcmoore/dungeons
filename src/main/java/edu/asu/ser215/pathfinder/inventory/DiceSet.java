package edu.asu.ser215.pathfinder.inventory;
import java.util.HashMap;

/**
 * Represents a set of Dice (i.e. multiple dice of a single type).
 * 
 * Each dice set is named using d20 notation: a "D" prefixed with the number of
 * dice and suffixed with the number of sides on the dice.
 * 
 * All DiceSet objects are mapped upon instantiation. Additionally, any two
 * DiceSet objects that hold the same values will reference the same
 * location in memory.
 * 
 * Direct instantiation of DiceSet objects are not allowed. The constructDiceSet 
 * method must be used instead.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.inventory.Dice
 */
public class DiceSet 
{
	private static HashMap<String, DiceSet> diceMap;
	private final int numberOfDice; //(e.g. 2d10 = 2 dice)
	private final Dice dice;
	
	/**
	 * Private constructor to prevent unmapped or duplicate diceSets.
	 */
	private DiceSet(int numberOfDice, Dice dice) 
	{
		this.numberOfDice = numberOfDice;
		this.dice = dice;
	}
	
	/**
	 * Returns a new DiceSet object based on the provided string (in d20 notation).
	 * 
	 * @param string	a string representing the DiceSet (e.g. 1d20 or 2D10)
	 * @return 			a Dice object representative of the string notation
	 */
	public static DiceSet parseDiceSet(String string)
	{
		//split into two numbers (e.g. 2d6 becomes {2, 6}
		String[] tokens = string.split("d");
		int numberOfDice;
		String diceString;
		
		//the first number represents the number of dice
		numberOfDice = Integer.parseInt(tokens[0]);
		//the second number represents the type of dice
		diceString = "D" + Integer.parseInt(tokens[1]);
		
		return constructDiceSet(numberOfDice, Dice.parseDice(diceString));
	}
	
	/**
	 * Allows the instantiation of DiceSet objects outside of this class.
	 * New DiceSet will be mapped by this method.
	 * 
	 * @return 	DiceSet object created based on the given parameters
	 */
	public static DiceSet constructDiceSet(int numberOfDice, Dice dice)
	{
		String key = calculateKey(numberOfDice, dice);
		DiceSet matchingDiceSet;
		
		if (dice == null)
			return null;
		
		if (DiceSet.diceMap == null)
			DiceSet.diceMap = new HashMap<>();
		
		
		matchingDiceSet = DiceSet.diceMap.get(key);
		if (matchingDiceSet == null)
		{
			matchingDiceSet = new DiceSet(numberOfDice, dice);
			DiceSet.diceMap.put(key, matchingDiceSet);
		}
		
		return matchingDiceSet;
	}
	
	/**
	 * Determines the name of a diceSet in d20 notation
	 * 
	 * @return	the name of the diceSet in d20 notation
	 */
	public static String calculateKey(int numberOfDice, Dice dice)
	{
		StringBuilder key = new StringBuilder();
		
		key.append(numberOfDice);
		key.append(dice.getName());
		
		return key.toString();
	}
	
	
	/**
	 * Rolls this set of dice a number of times, and returns the sum of all rolls.
	 * 
	 * @param numberOfTimes		how many times to roll this dice set
	 * @return					the sum of all rolls of this dice set
	 */
	public int roll(int numberOfTimes)
	{
		int sum = 0;
		
		//roll the set of dice a number of times
		for (int rollNumber = 0; rollNumber < numberOfTimes; rollNumber++)
		{
			//roll each dice in this set
			for (int diceNumber = 0; diceNumber < this.numberOfDice; diceNumber++)
			{
				sum += this.dice.roll();
			}
		}
		
		return sum;
	}
	
	
	/**
	 * Rolls this set once and returns the result. This call is equivallent to
	 * diceSet.roll(1)
	 */
	public int roll()
	{
		return roll(1);
	}
	
	@Override
	public String toString()
	{
		return calculateKey(this.numberOfDice, this.dice);
	}

	
	//------------------------------------------------------------------------------------------------------------
	//--------------------------------------------Accessors & Mutators--------------------------------------------
	//------------------------------------------------------------------------------------------------------------
	public int getNumberOfDice() {
		return numberOfDice;
	}

	public Dice getDice() {
		return dice;
	}

	
}
