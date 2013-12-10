package edu.asu.ser215.pathfinder;

import java.io.File;
import java.util.Arrays;

import edu.asu.ser215.pathfinder.character.*;
import edu.asu.ser215.pathfinder.character.ScoreType.NoMapException;

public class TestCharacterPackage
{
	public static final String[] skillNames = {"testSkill"};
	public static void main(String[] args) throws NoMapException
	{
		testLoadingScoreTypes("");
		System.out.println("Results Unverified\n");
		
		testSkillType("");
		System.out.println("Results Unverified\n");
		
		testSkillScoreList("");
		System.out.println("Results Unverified\n");
	}
	
	public static void testLoadingScoreTypes(String outputPrefix)
	{
		String abilityXML = "C:\\Users\\monsoon300\\Desktop\\abilities.xml";
		
		System.out.println(outputPrefix + "Begin test: LoadScoreTypes");
		
		if (Ability.loadAbilities(new File(abilityXML)))
			System.out.println(outputPrefix + "\tAbilities loaded successfully: " + Arrays.toString(Ability.getScoreTypes()));
		
		System.out.println(outputPrefix + "\tNumber of abilities: " + Ability.getNumberOfAbilityTypes());
	}
	
	public static void testSkillType(String outputPrefix) throws NoMapException
	{
		System.out.println(outputPrefix + "Begin test: SkillType");
		Skill.constructSkillType(skillNames[0]);
		if (Skill.getScoreTypes().length > 0)
			System.out.println(outputPrefix + "Tentative success");
		System.out.println(outputPrefix + Arrays.toString(Skill.getDefaultScores()));
	}
	
	public static ScoreList<Skill> testSkillScoreList(String outputPrefix) throws NoMapException
	{
		ScoreList<Skill> skillList = null;
		System.out.println(outputPrefix + "Begin test: ScoreList<SkillType>");
		
		try
		{
			skillList = new ScoreList<>(Skill.class);
			System.out.println(outputPrefix + "\tsuccess: ScoreList<SkillType> constructor");
			System.out.println(outputPrefix + "\tskillList length: " + skillList.size());
			System.out.println(outputPrefix + "\t" + skillNames[0] + " value: " + skillList.getScore(skillNames[0]).getModifiedScore());
			
			System.out.println(outputPrefix + "Tentative success");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return skillList;
	}

}
