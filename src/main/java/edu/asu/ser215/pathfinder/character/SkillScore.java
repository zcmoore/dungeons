package edu.asu.ser215.pathfinder.character;

public class SkillScore extends ModifiedScore 
{
	public static final int TRAINED_BONUS = 3;
	protected SkillType skillType;
	protected boolean trained;
	
	public SkillScore(SkillType skillType, boolean trained, int initialScore, 
			int initialBonus, AbilityScore modifyingAbility) 
	{
		super(initialScore, initialBonus, modifyingAbility);
		this.skillType = skillType;
		this.trained = trained;
	}
	
	@Override
	protected int recalculateModifier()
	{
		this.modifier = super.recalculateModifier();
		
		//if this skill is trained and has at least one rank, it receives a bonus
		if (trained && (this.rawScore > 0))
				this.modifier += TRAINED_BONUS;
		
		return this.modifier;
	}
}
