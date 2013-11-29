package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;
import edu.asu.ser215.pathfinder.character.AbilityType.UnmappedException;

public class AbilityScoreList 
{
	protected AbilityScore[] abilityScores;
	
	public AbilityScoreList()
	{
		AbilityType[] abilities = AbilityType.getAbilityTypes();
		int numberOfAbilities = abilities.length;
		this.abilityScores = new AbilityScore[numberOfAbilities];
		
		//populate abilityScores array with default scores
		for (int index = 0; index < numberOfAbilities; index++)
		{
			this.abilityScores[index] = new AbilityScore(abilities[index]);
		}
	}
	
	public AbilityScoreList(AbilityScore... abilitiyScoreValues)
	{
		this();
		
		//TODO eliminate double loop; optimize
		for (AbilityScore abilityScore : abilitiyScoreValues)
		{
			int index = abilityScore.getAbilityType().getIndex();
			this.abilityScores[index] = abilityScore;
		}
	}
	
	/**
	 * @see #AbilityScoreList(AbilityScore...)
	 */
	public AbilityScoreList(ArrayList<AbilityScore> abilityScoreValues)
	{
		this(abilityScoreValues.toArray(new AbilityScore[abilityScoreValues.size()]));
	}
	
	public AbilityScore getAbilityScoreAt(int index)
	{
		return abilityScores[index];
	}
	
	public AbilityScore getAbilityScore(String abilityName) throws UnmappedException
	{
		return getAbilityScoreAt(AbilityType.indexOf(abilityName));
	}
	
	public AbilityScore getAbilityScore(AbilityType type)
	{
		return abilityScores[type.index];
	}
}
