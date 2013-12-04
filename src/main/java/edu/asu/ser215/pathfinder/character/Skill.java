package edu.asu.ser215.pathfinder.character;

import java.util.HashMap;

/**
 * Each Skill is mapped upon instantiation, and will be unique. This class
 * contains a map of all Skill types that are available. Each Skill is
 * associated with an index (which is unique to each instance), which will be
 * used to reference the value of each skill in ScoreList<Skill>, and all other
 * classes which have a value for each Skill type.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinderSkillScoreList
 * @see edu.asu.ser215.pathfinder.SkillScore
 * @see <a 
 *      href="http://paizo.com/PRD/skillDescriptions.html">
 *      Pathfinders guide on Skills</a>
 *
 */
public class Skill extends ScoreType
{
	public static SpecifiedScore<Ability> DEFAULT_MODIFYING_ABILITY = createDefaultModifyingAbility();
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_BONUS = 0;
	
	/**Maps all skill types using name as the key*/
	private static HashMap<String, Skill> skillTypeMap = new HashMap<>();
	private static int currentIndex = 0; /*Represents the current number of 
										SkillType objects in abilityTypeMap*/
	
	private static SpecifiedScore<Ability> createDefaultModifyingAbility()
	{
		return new SpecifiedScore<Ability>(Ability.DEFAULT_SCORE, Ability.DEFAULT_BONUS, 
				Ability.constructAbilityType("Default"));
	}
	
	/**
	 * Private constructor to prevent unmapped and/or duplicate instances.
	 * The current index will be assigned to the new object, and the index will
	 * be incremented.
	 */
	private Skill(String name)
	{
		super(name, currentIndex);
		currentIndex++;
	}
	
	/**
	 * Returns a SkillType based on the given name. If the name refers to
	 * a pre-existing SkillType, then the pre-existing object will be returned.
	 * 
	 * @param name	name of the desired skill
	 */
	public static Skill constructSkillType(String name)
	{
		//fetch skill from skillMap
		Skill returnObject = skillTypeMap.get(name);
		
		//if map did not contain the skill, create and map the skill
		if (returnObject == null)
		{
			//create new SkillType
			returnObject = new Skill(name);
			
			//map the new object using its name as a key
			skillTypeMap.put(name, returnObject);
		}
		
		return returnObject;
	}
	
	/**
	 * Returns a sorted list of skillTypes, in order of their index
	 * 
	 * @return sorted array of all SkillType objects
	 */
	@SuppressWarnings("unchecked")
	public static Skill[] getScoreTypes()
	{
		return ScoreType.getScoreTypes(skillTypeMap, new Skill[skillTypeMap.size()]);
	}
	
	/**
	 * @return	an array of SpecifiedScores representing the default SkillScores
	 */
	@SuppressWarnings("unchecked")
	public static <T extends SpecifiedScore<?>> T[] getDefaultScores()
	{
		Skill[] skillTypes = getScoreTypes();
		SkillScore[] defaultScores = new SkillScore[skillTypes.length];
		
		for (int index = 0; index < defaultScores.length; index++)
		{
			//TODO add support for null modifyingType in SkillScore
			defaultScores[index] = new SkillScore(skillTypes[index], DEFAULT_MODIFYING_ABILITY);
		}
		
		return (T[]) defaultScores;
	}
	
	public static int indexOf(String skillName) throws UnmappedException 
	{
		System.out.println("indexOf called from SkillType");
		return ScoreType.indexOf(skillTypeMap, skillName);
	}
	
	public static int getNumberOfSkillTypes()
	{
		return currentIndex;
	}
	
	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.character.ScoreType#calculateModifier(edu.asu.ser215.pathfinder.character.SpecifiedScore)
	 */
	@Override
	public int calculateModifier(SpecifiedScore<?> score) throws IllegalArgumentException
	{
		SkillScore castedScore;
		
		//SkillType can only calculate SkillScore. If the given parameter is not
		//a SkillScore, throw an exception.
		if ((score instanceof SkillScore))
			castedScore = (SkillScore) score;
		else
			throw new IllegalArgumentException();
		
		int newModifier = ModifiedScore.calculateModifier(castedScore);
		
		//if this skill is trained and has at least one rank, it receives a bonus
		if (castedScore.trained && (castedScore.rawScore > 0))
			newModifier += SkillScore.TRAINED_BONUS;
		
		return newModifier;
	}
}