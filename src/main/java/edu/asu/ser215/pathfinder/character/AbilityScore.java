package edu.asu.ser215.pathfinder.character;

/**
 * 
 * @author Zach Moore
 * @see <a
 *      href="http://paizo.com/pathfinderRPG/prd/gettingStarted.html#strength">Pathfinders
 *      guide on Abilities</a>
 */
public class AbilityScore extends Score
{
	public static final int DEFAULT_VALUE = 10;
	public static final int BASE_VALUE = 10; //the value at which the modifier obtained will be 0
	public static final int DELTA_VALUE = 2; //modifier = (modifiedValue - baseValue)/delta
	
	protected AbilityType abilityType;
	
	public AbilityScore(AbilityType abilityType)
	{
		this(DEFAULT_VALUE, 0, abilityType);
	}

	public AbilityScore(int initialScore, int initialBonus,
			AbilityType abilityType) 
	{
		super(initialScore, initialBonus, true); //calculate dependent values in super
		this.abilityType = abilityType;
	}

	@Override
	protected int recalculateModifiedScore() 
	{
		this.modifiedScore = (this.rawScore + this.scoreBonus);
		return this.modifiedScore;
	}

	@Override
	protected int recalculateModifier() 
	{
		//Example: if baseValue = 10, and deltaValue = 2
		//if modifiedScore = 10 or 11, return 0
		//if modifiedScore = 12 or 13, return 1
		//return 2 for 14 or 15; 3 for 16 or 17, etc.
		//9 and 8 return -1; 7 returns -2
		int newModifier = this.modifiedScore - BASE_VALUE;
		if (newModifier < 0)
			newModifier -= (DELTA_VALUE - 1);
		
		this.modifier = newModifier / DELTA_VALUE;
		return this.modifier;
	}

	public AbilityType getAbilityType() {
		return abilityType;
	}

	public void setAbilityType(AbilityType abilityType) {
		this.abilityType = abilityType;
	}
	
	
}
