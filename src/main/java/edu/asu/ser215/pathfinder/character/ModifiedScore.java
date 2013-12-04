package edu.asu.ser215.pathfinder.character;

/**
 * Represents a score that gains additional modifier(s) dependent on another
 * score object. An example of a ModifiedScore is a character skill, which gains
 * a bonus based on the character's attribute scores.
 * 
 * Note: not all ModifiedScores are able to inherit this class. However, all
 * modified scores should implement Modified. Any class that inherits from Score
 * and implements Modified will be able to make static calls to ModifiedScore.
 * 
 * Additionally, all static methods in this class that take a modified score as
 * a parameter will instead accept any class: <T extends Score & Modified>
 * 
 * @see <a 
 *      href="http://paizo.com/PRD/skillDescriptions.html">
 *      Pathfinder guide on Skills</a>
 * @author Zach Moore
 */
public class ModifiedScore extends Score implements Modified
{
	protected Score modifyingScore;
	
	public ModifiedScore(int initialScore, int initialBonus, 
			Score modifyingAbility) 
	{
		super(initialScore, initialBonus, false);
		this.modifyingScore = modifyingAbility;
		calculateDependentValues();
	}

	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.character.Score#recalculateModifier()
	 */
	@Override
	protected int recalculateModifier()
	{
		this.modifier = calculateModifier(this);
		return this.modifier;
	}
	
	/**
	 * Static method to calculate the modifier of any score that is modified
	 * (some modified scores may not inherit from ModifiedScore).
	 * 
	 * @param score	the score for which to calculate the modifier
	 * @return 		the modified score of the given object
	 */
	public static <T extends Score & Modified> int calculateModifier(T score)
	{
		return score.modifiedScore +  score.getModifyingScore().getModifier();
	}
	
	/**
	 * Identical to a getModifier() call. This method name is more appropriate
	 * in some cases, and is used only for readability improvements.
	 * 
	 * @return	this score's modifier value
	 * @see #getModifier()
	 */
	public int getValue()
	{
		return this.modifier;
	}

	/* (non-Javadoc)
	 * Returns the score object that modifies this score
	 * @see edu.asu.ser215.pathfinder.character.Modified#getModifyingScore()
	 */
	@Override
	public Score getModifyingScore()
	{
		return modifyingScore;
	}
}
