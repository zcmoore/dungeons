package edu.asu.ser215.pathfinder.core;

import java.util.HashMap;
import java.util.Random;

/**
 * Represents a type of dice (e.g. a 20-sided dice, or a 10-sided dice). This
 * class contains specifics about the dice, and calculates the rolls thereof.
 * 
 * Each dice is named using d20 convention. In other words, the name of each
 * dice begins with a "D" and is suffixed by the number of sides the dice has.
 * 
 * All Dice objects are mapped upon instantiation. Additionally, any two Dice
 * objects that hold the same values will reference the same location in memory.
 * 
 * Direct instantiation of Dice objects are not allowed. The constructDice
 * method must be used instead.
 * 
 * @author Zach Moore
 * 
 */
public class Dice {
	public static final int DEFAULT_NUMBERING_OFFSET = 1;
	public static final String REPRESENTATION = "d";

	/**
	 * Contains information representing commonly used special dice in
	 * tabletop-RPGs.
	 * 
	 * @author Zach Moore
	 * 
	 */
	private enum DefaultDice {
		D4(4, 1),
		D6(6, 1),
		D8(8, 1),
		D10(10, 0),
		D12(12, 1),
		D20(20, 1),
		D100(100, 1);

		private final int numberOfSides;
		private final int numberingOffset; 	// e.g. a 10-sided dice starts its
											// numbering at 0, so the offset
											// is 0. A d20 starts at 1, so
											// offset = 1, etc.

		private DefaultDice(int numberOfSides, int numberingOffset) {
			this.numberOfSides = numberOfSides;
			this.numberingOffset = numberingOffset;
		}
	}

	// holds all Dice objects the object's name serves as the key
	private static HashMap<String, Dice> diceMap;

	private final String name;
	private final int numberOfSides;
	private final int numberingOffset; 	// e.g. a 10-sided dice starts its
										// numbering

	// at 0, so the offset is 0. A d20 starts
	// at 1, so offset = 1, etc.

	/**
	 * Private constructor to prevent unmapped or duplicate dice.
	 */
	private Dice(int numberOfSides, int numberingOffset) {
		this.numberOfSides = numberOfSides;
		this.numberingOffset = numberingOffset;
		this.name = Dice.generateName(numberOfSides);
	}

	/**
	 * Allows the instantiation of Dice objects outside of this class. New Dice
	 * will be mapped by this method.
	 * 
	 * @param numberOfSides numberOfSides the dice has
	 * @param numberingOffset e.g. a 10-sided dice starts its numbering at 0, so
	 *        the offset is 0. A d20 starts at 1, so offset = 1, etc.
	 * @return Dice object created based on the given parameters
	 */
	public static Dice constructDice(int numberOfSides, int numberingOffset) {
		if (numberOfSides < 2) {
			throw new IllegalArgumentException(
					"Expected number of sides to be greater than 1, got "
							+ numberOfSides);
		}
		if (numberingOffset < 0) {
			throw new IllegalArgumentException(
					"Expected numbering offset to be greater than 1 and less than "
							+ numberOfSides + "(numberOfSides), got "
							+ numberingOffset);
		}

		Dice returnDice;

		if (Dice.diceMap == null) {
			Dice.diceMap = new HashMap<>();
			returnDice = null;
		} else {
			// return reference to existing dice object
			returnDice = Dice.diceMap.get(Dice.generateName(numberOfSides));
		}

		if (returnDice == null) {
			// create new Dice object and map it accordingly
			returnDice = new Dice(numberOfSides, numberingOffset);
			Dice.diceMap.put(returnDice.name, returnDice);
		}

		return returnDice;
	}

	/**
	 * Determines the name of a dice in d20 notation
	 * 
	 * @param numberOfSides numberOfSides the dice has
	 * @return the name of the dice in d20 notation
	 */
	public static String generateName(int numberOfSides) {
		return Dice.REPRESENTATION + numberOfSides;
	}

	/**
	 * Generates a random roll based on the specifics of the dice object.
	 * 
	 * @return an integer representing the value of one roll of this dice
	 */
	public int roll() {
		Random random = new Random();
		int roll = random.nextInt(this.numberOfSides) + this.numberingOffset;

		return roll;
	}

	/**
	 * Returns a new Dice object based on the provided string (in d20 notation).
	 * The numbering offset will be set to the defaults.
	 * 
	 * @param dice a string representing the Dice object (e.g. d20 or D10)
	 * @return a Dice object representative of the string notation
	 */
	public static Dice parseDice(String dice) {
		String diceName = dice.toUpperCase();
		DefaultDice defaultDice;
		Dice returnDice = null;

		// determine if this dice is represented as a default
		try {
			defaultDice = DefaultDice.valueOf(diceName);
		} catch (Exception e) {
			defaultDice = null;
		}

		try {
			if (defaultDice == null) // dice is not a default dice
			{
				// construct dice using default numbering offset
				String[] tokens = diceName.split(Dice.REPRESENTATION
						.toUpperCase());
				int numberOfSides = Integer.parseInt(tokens[1]);
				returnDice = Dice.constructDice(numberOfSides,
						Dice.DEFAULT_NUMBERING_OFFSET);
			} else // dice is a default dice
			{
				// construct dice using defaultDice parameters
				returnDice = Dice.constructDice(defaultDice.numberOfSides,
						defaultDice.numberingOffset);
			}
		} catch (Exception e) {
			returnDice = null;
		}

		return returnDice;

	}

	/**
	 * Get the display name of the dice
	 * 
	 * @return Display name of dice
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * A list of all available dice.
	 * 
	 * @return String listing all available dice. One dice per line
	 */
	public static String listDice() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Dice dice : Dice.diceMap.values()) {
			stringBuilder.append(dice.getName() + "\n");
		}
		return stringBuilder.toString();
	}

}
