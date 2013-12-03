package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;
import java.util.HashMap;

import edu.asu.ser215.pathfinder.core.DiceSet;

/**
 * Represents a playable class. Each Class is mapped upon instantiation, 
 * and will be unique. "name" is used as a key, and should thus be unique.
 * 
 * Note: trainedSkills is a sorted array
 * 
 * @author Zach Moore
 * @see <a href="http://paizo.com/prd/classes.html">Pathfinders guide on Classes</a>
 */
public class CharacterClass
{
	private static HashMap<String, CharacterClass> classMap = new HashMap<>();
	
	protected final Skill[] trainedSkills;
	protected final String name;
	protected final DiceSet startingWealth;
	
	/**
	 * returns a CharacterClass matching the given name and description. If an
	 * object with the same name already exists, the pre-existing object will
	 * be returned. Otherwise, a new object will be created and returned.
	 * 
	 * @see #CharacterClass(Skill[], String, DiceSet)
	 */
	public CharacterClass constructCharacterClass(Skill[] trainedSkills, String name, DiceSet startingWealth)
	{
		//if an error occurs, a null value will be returned
		CharacterClass returnObject = null;
				
		try
		{
			//search for an existing class with the same name
			returnObject = classMap.get(name);
			
			if (returnObject == null)
			{
				//create and map the new object
				returnObject = new CharacterClass(trainedSkills, name, startingWealth);
				classMap.put(name, returnObject);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return returnObject;
	}
	
	/**
	 * private constructor to prevent unmapped or duplicate objects.
	 * Sorts trainedSkills after setting all values.
	 * 
	 * @param trainedSkills		list of skills that this class is trained in
	 * @param name				name of the class
	 * @param startingWealth	dice set that a player will roll to determine his/her starting wealth
	 */
	private CharacterClass(Skill[] trainedSkills, String name, DiceSet startingWealth)
	{
		this.trainedSkills = trainedSkills;
		this.name = name;
		this.startingWealth = startingWealth;
		
		Arrays.sort(trainedSkills);
	}
	
	/**
	 * Returns true if the specified skill is listed in this class' trainedSkills
	 */
	public boolean hasTrainedSkill(Skill skill)
	{
		//search trainedSkills for the desired skill
		int searchResult = Arrays.binarySearch(trainedSkills, skill);
		
		//if the skill was found, the result will be >= 0
		return (searchResult >= 0);
	}

	/* (Non-JavaDoc)
	 * This is acceptable as long as Skill is immutable.
	 * 
	 * @return array of this class' trained skills
	 */
	public Skill[] getTrainedSkills()
	{
		return trainedSkills;
	}

	public String getName() {
		return name;
	}

	/**
	 * @see 	Pathfinder core rulebook - Character creation
	 * @return	the startingWealth roll for this class
	 */
	public int rollStartingWealth()
	{
		return startingWealth.roll();
	}
	
	/**
	 * Returns an array of all character classes that have been created.
	 */
	public static CharacterClass[] getCharacterClasses()
	{
		return classMap.values().toArray(new CharacterClass[classMap.size()]);
	}

}
