package edu.asu.ser215.pathfinder.character;

public class SkillScore extends ModifiedScore 
{
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
		//TODO add handling for trained skills
		this.modifier = super.recalculateModifier();
		return this.modifier;
	}
}
