package edu.asu.ser215.pathfinder.character;

public class SkillScore extends SpecifiedScore<Skill> implements Modified
{
	public static final int TRAINED_BONUS = 3;
	public static final boolean DEFAULT_TRAINED_STATUS = false;
	protected SpecifiedScore<Ability> modifyingAbility;
	protected boolean trained;
	
	public SkillScore(Skill scoreType, SpecifiedScore<Ability> modifyingAbility)
	{
		this(Skill.DEFAULT_SCORE, Skill.DEFAULT_BONUS, scoreType, 
				modifyingAbility, DEFAULT_TRAINED_STATUS);
	}

	public SkillScore(int initialScore, int initialBonus, Skill scoreType,
			SpecifiedScore<Ability> modifyingAbility, boolean trained)
	{
		super(initialScore, initialBonus, false, scoreType);
		this.modifyingAbility = modifyingAbility;
		this.trained = trained;
		
		calculateDependentValues();
	}

	public Skill getSkillType() {
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
