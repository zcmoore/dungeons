package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;
import edu.asu.ser215.pathfinder.character.AbilityType.UnmappedException;

//TODO combine SkillScoreList and AbilityScoreList
public class SkillScoreList 
{
	protected SkillScore[] skillScores;
	
	public SkillScoreList()
	{
		SkillType[] skills = SkillType.getSkillTypes();
		int numberOfAbilities = skills.length;
		this.skillScores = new SkillScore[numberOfAbilities];
		
		//populate skillScores array with default scores
		for (int index = 0; index < numberOfAbilities; index++)
		{
			this.skillScores[index] = new SkillScore(skills[index]);
		}
	}
	
	public SkillScoreList(SkillScore... skillScoreValues)
	{
		this();
		
		//TODO eliminate double loop; optimize
		for (SkillScore skillScore : skillScoreValues)
		{
			int index = skillScore.getSkillType().getIndex();
			this.skillScores[index] = skillScore;
		}
	}
	
	/**
	 * @see #SkillScoreList(SkillScore...)
	 */
	public SkillScoreList(ArrayList<SkillScore> skillScoreValues)
	{
		this(skillScoreValues.toArray(new SkillScore[skillScoreValues.size()]));
	}
	
	public SkillScore getSkillScoreAt(int index)
	{
		return skillScores[index];
	}
	
	public SkillScore getAbilityScore(String abilityName) throws UnmappedException
	{
		return getSkillScoreAt(AbilityType.indexOf(abilityName));
	}
	
	public SkillScore getSkillScore(SkillType type)
	{
		return skillScores[type.index];
	}
}
