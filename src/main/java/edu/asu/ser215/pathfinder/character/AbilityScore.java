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
	protected AbilityType abilityType;

	public AbilityScore(int initialScore, int initialBonus,
			AbilityType abilityType) 
	{
		super(initialScore, initialBonus, false);
		this.abilityType = abilityType;
		calculateDependentValues();
	}

	@Override
	protected int recalculateModifiedScore() 
	{
		return (this.rawScore + this.scoreBonus);
	}

	@Override
	protected int recalculateModifier() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
