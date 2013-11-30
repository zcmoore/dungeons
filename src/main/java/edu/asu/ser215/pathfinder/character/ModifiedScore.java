package edu.asu.ser215.pathfinder.character;

public class ModifiedScore extends Score implements Modified
{
	protected SpecifiedScore<?> modifyingScore;
	
	public ModifiedScore(int initialScore, int initialBonus, 
			SpecifiedScore<?> modifyingAbility) 
	{
		super(initialScore, initialBonus, false);
		this.modifyingScore = modifyingAbility;
		calculateDependentValues();
	}

	@Override
	protected int recalculateModifier()
	{
		this.modifier = calculateModifier(this);
		return this.modifier;
	}
	
	public static <T extends Score & Modified> int calculateModifier(T score)
	{
		return score.modifiedScore +  score.getModifyingScore().getModifier();
	}
	
	public int getValue()
	{
		return this.modifier;
	}

	@Override
	public Score getModifyingScore()
	{
		return modifyingScore;
	}
}
