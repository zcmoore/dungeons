package edu.asu.ser215.pathfinder.character;

import java.util.HashMap;
import edu.asu.ser215.pathfinder.character.AbilityType.UnmappedException;

/**
 * Each SkillType is mapped upon instantiation, and will be unique. This class
 * contains a map of all SkillTypes that are available. Each SkillType is
 * associated with an index (which is unique to each instance), which will be
 * used to reference the value of each skill in SkillScoreList, and all other
 * classes which have a value for each SkillType
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinderSkillScoreList
 * @see edu.asu.ser215.pathfinder.SkillScore
 * @see <a 
 *      href="http://paizo.com/PRD/skillDescriptions.html">
 *      Pathfinders guide on Skills</a>
 *
 */
public class SkillType extends ScoreType
{
	/**Maps all skill types using name as the key*/
	private static HashMap<String, SkillType> skillTypeMap = new HashMap<>();
	private static int currentIndex = 0; /*Represents the current number of 
										SkillType objects in abilityTypeMap*/
	
	/**
	 * Private constructor to prevent unmapped and/or duplicate instances.
	 * The current index will be assigned to the new object, and the index will
	 * be incremented.
	 */
	private SkillType(String name)
	{
		this.name = name;
		this.index = currentIndex;
		currentIndex++;
	}
	
	/**
	 * Returns a SkillType based on the given name. If the name refers to
	 * a pre-existing SkillType, then the pre-existing object will be returned.
	 * 
	 * @param name	name of the desired skill
	 */
	public static SkillType constructSkillType(String name)
	{
		//fetch skill from skillMap
		SkillType returnObject = skillTypeMap.get(name);
		
		//if map did not contain the skill, create and map the skill
		if (returnObject == null)
		{
			//create new SkillType
			returnObject = new SkillType(name);
			
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
	public static SkillType[] getSkillTypes()
	{
		return ScoreType.getScoreTypes(skillTypeMap, new SkillType[skillTypeMap.size()]);
	}
	
	public static int getNumberOfSkillTypes()
	{
		return currentIndex;
	}
	
	/**
	 * This is equivalent to a call to {@link #indexOf(String)}
	 * Returns the index of the desired skill. If no matching skill is found,
	 * UnmappedException will be thrown
	 * 
	 * @param skillName		the desired skill name
	 * @return				the index of the desired skill
	 */
	public static int search(String skillName) throws UnmappedException
	{	
		return ScoreType.indexOf(skillTypeMap, skillName);
	}

	public String getName() 
	{
		return name;
	}

	public int getIndex() 
	{
		return index;
	}

	@Override
	public int indexOf(String skillName) throws UnmappedException 
	{
		return ScoreType.indexOf(skillTypeMap, skillName);
	}
}