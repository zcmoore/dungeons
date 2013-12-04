package edu.asu.ser215.pathfinder.character;

/**
 * Represents a single score, corresponding to the given type. Each specified score
 * will have a default value, based on the given scoreType.
 * 
 * @see edu.asu.ser215.pathfinder.character.ScoreType
 * 
 * @author Zach Moore
 * @param <T> the type of score represented by this Score object.
 */
public class SpecifiedScore<T extends ScoreType> extends Score 
{
	protected T scoreType;
	
	public SpecifiedScore(int initialScore, int initialBonus, T scoreType)
	{
		this(initialScore, initialBonus, true, scoreType);
	}

	protected SpecifiedScore(int initialScore, int initialBonus,
			boolean calculateDependentValues, T scoreType)
	{
		super(initialScore, initialBonus, false);
		this.scoreType = scoreType;
		if (calculateDependentValues)
			calculateDependentValues();
	}

	@Override
	protected int recalculateModifier() 
	{
		this.modifier = scoreType.calculateModifier(this);
		return this.modifier;
	}

	public T getScoreType() {
		return scoreType;
	}
	
	

}
