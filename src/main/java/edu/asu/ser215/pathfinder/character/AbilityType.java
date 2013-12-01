package edu.asu.ser215.pathfinder.character;

import java.util.HashMap;

/**
 * Each AbilityType is mapped upon instantiation, and will be unique. This class
 * contains a map of all AbilityTypes that are available. Each AbilityType is
 * associated with an index (which is unique to each instance), which will be
 * used to reference the value of each attribute in AbilityScoreList, and all other
 * classes which have a value for each AbilityType
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.AbilityScoreList
 * @see edu.asu.ser215.pathfinder.AbilityScore
 * @see <a 
 *      href="http://paizo.com/pathfinderRPG/prd/gettingStarted.html#strength">
 *      Pathfinders guide on Abilities</a>
 *
 */
public class AbilityType extends ScoreType
{
	public static final int DEFAULT_SCORE = 10;
	public static final int DEFAULT_BONUS = 0;
	public static final int BASE_VALUE = 10; //the value at which the modifier obtained will be 0
	public static final int DELTA_VALUE = 2; //modifier = (modifiedValue - baseValue)/delta
	
	/**Maps all ability types. The abbreviation of each ability is used as a key*/
	private static HashMap<String, AbilityType> abilityTypeAbbreviationMap = new HashMap<>();
	/**Maps all ability types using name as the key*/
	private static HashMap<String, AbilityType> abilityTypeNameMap = new HashMap<>();
	/**Represents the current number of AbilityType objects in abilityTypeMap*/
	private static int currentIndex = 0;
	
	protected String abbreviation;
	
	/**
	 * Private constructor to prevent unmapped and/or duplicate instances.
	 * The current index will be assigned to the new object, and the index will
	 * be incremented.
	 */
	private AbilityType(String name, String abbreviation)
	{
		this.name = name;
		this.abbreviation = abbreviation;
		this.index = currentIndex;
		currentIndex++;
	}
	
	/**
	 * @see #generateUniqueAbbreviation(String, int)
	 */
	private static String generateUniqueAbbreviation(String name) throws NotUniqueException
	{
		return generateUniqueAbbreviation(name, 3);
	}
	
	/**
	 * generates a unique abbreviation of the given string, to be used as a key
	 * in abilityTypeMap. If an AbilityType with the same name already exists,
	 * this method will throw NotUniqueException.
	 * 
	 * @param name
	 * @return
	 */
	private static String generateUniqueAbbreviation(String name, int length) throws NotUniqueException
	{
		String abbreviation = name.substring(0, length);
		AbilityType existingAbility = abilityTypeAbbreviationMap.get(abbreviation);
		
		if (existingAbility == null)
			return abbreviation; //found unique abbreviation
		
		else if (existingAbility.name.equalsIgnoreCase(name))
			throw (new NotUniqueException("name already exists"));
		
		else if (name.length() > length)
			abbreviation = generateUniqueAbbreviation(name, length + 1);
		
		else
			//The following could produce an instance where the given name is
			//unique, but all possible abbreviations are taken (e.g. name="Strr",
			//and abbreviations for "Stra" and "Strra" already exist)
			//TODO add unique abbreviation generator code
			throw (new NotUniqueException("name already exists"));
		
		return abbreviation;
	}
	
	/**
	 * Returns an AbilityType based on the given name. If the name refers to
	 * a pre-existing AbilityType, then the pre-existing object will be returned.
	 * 
	 * @param name	name of the new attribute
	 */
	public static AbilityType constructAbilityType(String name)
	{
		AbilityType returnObject = null;
		
		try
		{
			returnObject = abilityTypeNameMap.get(name);
			if (returnObject == null)
			{
				/*create an abbreviation. If an instance with this abbreviation 
					already exists, then NotUniqueException will be thrown*/
				String uniqueAbbreviation = generateUniqueAbbreviation(name);
				returnObject = new AbilityType(name, uniqueAbbreviation);
				
				//Add unique AbilityType to both maps
				abilityTypeAbbreviationMap.put(uniqueAbbreviation, returnObject);
				abilityTypeNameMap.put(name, returnObject);
			}
			
		}
		catch (NotUniqueException e)
		{
			returnObject = abilityTypeNameMap.get(name);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return returnObject;
	}
	
	public static int indexOf(String abilityName) throws UnmappedException
	{		
		return ScoreType.indexOf(abilityTypeNameMap, abilityName);
	}
	
	/**
	 * Returns a sorted list of abilityTypes, in order of their index
	 * 
	 * @return sorted array of all AbilityType objects
	 */
	@SuppressWarnings("unchecked")
	public static AbilityType[] getScoreTypes()
	{
		return ScoreType.getScoreTypes(abilityTypeNameMap, new AbilityType[abilityTypeNameMap.size()]);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends SpecifiedScore<?>> T[] getDefaultScores() throws NoMapException
	{
		AbilityType[] abilityTypes = getScoreTypes();
		SpecifiedScore<AbilityType>[] defaultScores = new SpecifiedScore[abilityTypes.length];
		
		for (int index = 0; index < defaultScores.length; index++)
		{
			defaultScores[index] = new SpecifiedScore<>(DEFAULT_SCORE, DEFAULT_BONUS, abilityTypes[index]);
		}
		
		return (T[]) defaultScores;
	}
	
	public static int getNumberOfAbilityTypes()
	{
		return currentIndex;
	}

	public String getAbbreviation() 
	{
		return abbreviation;
	}
	
	@Override
	public int calculateModifier(SpecifiedScore<?> score) {
		//Example: if baseValue = 10, and deltaValue = 2
		//if modifiedScore = 10 or 11, return 0
		//if modifiedScore = 12 or 13, return 1
		//return 2 for 14 or 15; 3 for 16 or 17, etc.
		//9 and 8 return -1; 7 returns -2
		int newModifier = score.modifiedScore - BASE_VALUE;
		if (newModifier < 0)
			newModifier -= (DELTA_VALUE - 1);
		
		newModifier /= DELTA_VALUE;
		return newModifier;
	}
	
	
}
