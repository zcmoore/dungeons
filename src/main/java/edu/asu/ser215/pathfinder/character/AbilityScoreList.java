package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

import edu.asu.ser215.pathfinder.character.ScoreType.UnmappedException;

//TODO combine SkillScoreList and AbilityScoreList
public class AbilityScoreList 
{
	protected SpecifiedScore<AbilityType>[] abilityScores;
	
	@SuppressWarnings("unchecked")
	public AbilityScoreList()
	{
		AbilityType[] abilities = AbilityType.getAbilityTypes();
		int numberOfAbilities = abilities.length;
		this.abilityScores = new SpecifiedScore[numberOfAbilities];
		
		//populate abilityScores array with default scores
		for (int index = 0; index < numberOfAbilities; index++)
		{
			this.abilityScores[index] = new SpecifiedScore<AbilityType>(AbilityType.DEFAULT_SCORE, 0, abilities[index]);
		}
	}
	
	@SafeVarargs
	public AbilityScoreList(SpecifiedScore<AbilityType>... abilitiyScoreValues)
	{
		this();
		
		//TODO eliminate double loop; optimize
		for (SpecifiedScore<AbilityType> abilityScore : abilitiyScoreValues)
		{
			int index = abilityScore.getScoreType().getIndex();
			this.abilityScores[index] = abilityScore;
		}
	}
	
	/**
	 * @see #AbilityScoreList(AbilityScore...)
	 */
	@SuppressWarnings("unchecked")
	public AbilityScoreList(ArrayList<SpecifiedScore<AbilityType>> abilityScoreValues)
	{
		this(abilityScoreValues.toArray(new SpecifiedScore[abilityScoreValues.size()]));
	}
	
	public SpecifiedScore<AbilityType> getAbilityScoreAt(int index)
	{
		return abilityScores[index];
	}
	
	public SpecifiedScore<AbilityType> getAbilityScore(String abilityName) throws UnmappedException
	{
		return getAbilityScoreAt(AbilityType.search(abilityName));
	}
	
	public SpecifiedScore<AbilityType> getAbilityScore(AbilityType type)
	{
		return abilityScores[type.index];
	}
}
