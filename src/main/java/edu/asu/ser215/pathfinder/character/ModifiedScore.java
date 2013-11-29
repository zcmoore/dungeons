package edu.asu.ser215.pathfinder.character;

public class ModifiedScore extends Score 
{
	protected AbilityScore modifyingAbility;
	
	public ModifiedScore(int initialScore, int initialBonus, 
			AbilityScore modifyingAbility) 
	{
		super(initialScore, initialBonus, false);
		this.modifyingAbility = modifyingAbility;
		calculateDependentValues();
	}

	@Override
	protected int recalculateModifiedScore()
	{
		this.modifiedScore = this.rawScore + this.scoreBonus;
		return this.modifiedScore;
	}

	@Override
	protected int recalculateModifier()
	{
		this.modifier = this.modifiedScore + this.modifyingAbility.getModifier();
		return this.modifier;
	}

	public AbilityScore getModifyingAbility()
	{
		return modifyingAbility;
	}
}
