package edu.asu.ser215.pathfinder.character;

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
		super(initialScore, initialBonus, calculateDependentValues);
		this.scoreType = scoreType;
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
