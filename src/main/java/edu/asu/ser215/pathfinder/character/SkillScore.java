package edu.asu.ser215.pathfinder.character;

public class SkillScore extends SpecifiedScore<SkillType> implements Modified
{
	public static final int TRAINED_BONUS = 3;
	protected SpecifiedScore<AbilityType> modifyingAbility;
	protected boolean trained;

	public SkillScore(int initialScore, int initialBonus, SkillType scoreType,
			SpecifiedScore<AbilityType> modifyingAbility, boolean trained)
	{
		super(initialScore, initialBonus, false, scoreType);
		this.modifyingAbility = modifyingAbility;
		this.trained = trained;
		
		calculateDependentValues();
	}

	public SkillType getSkillType() {
		return this.scoreType;
	}

	public boolean isTrained() {
		return trained;
	}

	@Override
	public Score getModifyingScore()
	{
		return modifyingAbility;
	}
	
	
}
