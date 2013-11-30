package edu.asu.ser215.pathfinder.character;

/**
 * Represents a multi-component score (for tabletop RPG). Each score has
 * an associated rawValue, bonusValue, and calculates a modified score, and
 * a modifier value, based on the score value it is assigned.
 * 
 * The rawScore and scoreBonus are independent, and can be modified. However,
 * the modifiedScore and modifier are dependent, and cannot be modified outside
 * of the Score class, or subclasses thereof.
 * 
 * @author Zach Moore
 *
 */
public abstract class Score 
{
	protected int rawScore;
	protected int scoreBonus;
	protected int modifiedScore;
	protected int modifier;
	
	protected abstract int recalculateModifier();
	
	protected final int recalculateModifiedScore()
	{
		this.modifiedScore = this.rawScore + this.scoreBonus;
		return this.modifiedScore;
	}
	
	protected Score(int initialScore, int initialBonus, boolean calculateDependentValues)
	{
		this.rawScore = initialScore;
		this.scoreBonus = initialBonus;
		if (calculateDependentValues)
			calculateDependentValues();
	}
	
	protected void calculateDependentValues()
	{
		recalculateModifiedScore();
		recalculateModifier();
	}
	
	public int increaseScoreBonus()
	{
		return increaseScoreBonus(1);
	}
	
	public int increaseScoreBonus(int incrementAmount)
	{
		this.scoreBonus += incrementAmount;
		return this.scoreBonus;
	}
	
	public int increaseScore()
	{
		return increaseScore(1);
	}
	
	public int increaseScore(int incrementAmount)
	{
		this.rawScore += incrementAmount;
		return this.rawScore;
	}
	
	public int getRawScore() 
	{
		return rawScore;
	}
	
	public void setRawScore(int rawScore) 
	{
		this.rawScore = rawScore;
		recalculateModifiedScore();
		recalculateModifier();
	}
	
	public int getScoreBonus() 
	{
		return scoreBonus;
	}
	
	public void setScoreBonus(int scoreBonus) 
	{
		this.scoreBonus = scoreBonus;
		recalculateModifiedScore();
		recalculateModifier();
	}
	
	public int getModifiedScore() 
	{
		return modifiedScore;
	}
	
	public int getModifier() 
	{
		return modifier;
	}
	
	
}
