package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;
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
public class AbilityType implements Comparable<AbilityType>
{
	/**
	 * Exception thrown when an attempt is made to add a duplicate abbreviation
	 * to the abbreviation map
	 * 
	 * @author Zach Moore
	 *
	 */
	private static class NotUniqueException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public NotUniqueException(String message)
		{
			super(message);
		}
	}
	
	/**
	 * Exception thrown when an attempt is made to access an AbilityType that
	 * does not exist or has not been mapped
	 * 
	 * @author Zach Moore
	 *
	 */
	public static class UnmappedException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public UnmappedException(String message)
		{
			super(message);
		}
	}
	
	/**Maps all ability types. The abbreviation of each ability is used as a key*/
	private static HashMap<String, AbilityType> abilityTypeAbbreviationMap = new HashMap<>();
	/**Maps all ability types using name as the key*/
	private static HashMap<String, AbilityType> abilityTypeNameMap = new HashMap<>();
	/**Represents the current number of AbilityType objects in abilityTypeMap*/
	private static int currentIndex = 0;
	
	protected String abbreviation;
	protected String name;
	/**the index reference for arrays that have a value for each AbilityType*/
	protected int index;
	
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
	
	/**
	 * Returns a sorted list of abilityTypes, in order of their index
	 * 
	 * @return sorted array of all AbilityType objects
	 */
	public static AbilityType[] getAbilityTypes()
	{
		//create and populate array of all abilityTypes
		AbilityType[] abilityTypes = abilityTypeNameMap.values().toArray
				(new AbilityType[abilityTypeNameMap.size()]);
		
		//sort by index
		Arrays.sort(abilityTypes);
		
		return abilityTypes;
	}
	
	public static int getNumberOfAbilityTypes()
	{
		return currentIndex;
	}
	
	public static int indexOf(String abilityName) throws UnmappedException
	{
		int index;
		AbilityType abilityType = abilityTypeNameMap.get(abilityName);
		
		if (abilityType == null)
			throw new UnmappedException("ability type not found");
		else
		{
			index = abilityType.getIndex();
		}
		
		return index;
	}

	public String getAbbreviation() 
	{
		return abbreviation;
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
	public int compareTo(AbilityType comparisonType) 
	{
		//if this id is less than the comparison id, return <0; 
		//if ids are equal, return =0
		//if id of this object is greater than the comparison id, return >0
		return this.index - comparisonType.index;
	}
	
	
}
