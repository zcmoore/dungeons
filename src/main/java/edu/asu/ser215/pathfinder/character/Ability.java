package edu.asu.ser215.pathfinder.character;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Each Ability is mapped upon instantiation, and will be unique. Note that 
 * abilities are mapped both by name and abbreviation, to allow for faster 
 * and more convenient searching. This class contains a map of all Abilities 
 * that are available. Each Ability is associated with an index (which is unique 
 * to each instance), which will be used to reference the value of each 
 * attribute in ScoreList<Ability>, and all other classes which have a value 
 * associated with each Ability
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.ScoreList
 * @see edu.asu.ser215.pathfinder.SpecifiedScore
 * @see <a 
 *      href="http://paizo.com/pathfinderRPG/prd/gettingStarted.html#strength">
 *      Pathfinders guide on Abilities</a>
 *
 */
public class Ability extends ScoreType
{
	public static final String XML_PATH = "res/resourcepacks/default/abilities.xml";
	public static final String ABILITY_TAG = "ability"; //how each ability is listed in abilities.xml
	public static final int DEFAULT_SCORE = 10;
	public static final int DEFAULT_BONUS = 0;
	public static final int BASE_VALUE = 10; //the value at which the modifier obtained will be 0
	public static final int DELTA_VALUE = 2; //modifier = (modifiedValue - baseValue)/delta
	
	/**Maps all ability types. The abbreviation of each ability is used as a key*/
	private static HashMap<String, Ability> abilityTypeAbbreviationMap = new HashMap<>();
	/**Maps all ability types using name as the key*/
	private static HashMap<String, Ability> abilityTypeNameMap = new HashMap<>();
	/**Represents the current number of AbilityType objects in abilityTypeMap*/
	private static int currentIndex = 0;
	
	/**Unique abbreviation of this Ability's name*/
	protected final String abbreviation;
	
	/**
	 * Private constructor to prevent unmapped and/or duplicate instances.
	 * The current index will be assigned to the new object, and the index will
	 * be incremented.
	 */
	private Ability(String name, String abbreviation)
	{
		super(name, currentIndex);
		this.abbreviation = abbreviation;
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
	 * or if a unique abbreviation could not be found, this method will throw 
	 * NotUniqueException.
	 * 
	 * @param name		the name to abbreviate
	 * @return			a unique abbreviation of the given name
	 */
	private static String generateUniqueAbbreviation(String name, int length) throws NotUniqueException
	{
		String abbreviation = name.substring(0, length);
		Ability existingAbility = abilityTypeAbbreviationMap.get(abbreviation);
		
		/* start with 'length' number of letters, and continue increasing the 
		 * number of letters until a unique abbreviation is found. Example: 
		 * "Strength" will begin with "Str" if "Str" is already being used, 
		 * try "stre" then "stren" etc.
		 */
		if (existingAbility == null)
			return abbreviation; //found unique abbreviation
		
		else if (existingAbility.name.equalsIgnoreCase(name))
			//if the given name is already mapped, throw an exception
			throw (new NotUniqueException("name already exists"));
		
		else if (name.length() > length)
			/* if the abbreviation was not unique, and the name has not yet
			 * been found/mapped, then increase the abbreviation length and
			 * continue searching
			 */
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
	public static Ability constructAbilityType(String name)
	{
		//if an error occurs, a null value will be returned
		Ability returnObject = null;
		
		try
		{
			//search for an existing ability with the same name
			returnObject = abilityTypeNameMap.get(name);
			if (returnObject == null)
			{
				/*create an abbreviation. If an instance with this abbreviation 
					already exists, then NotUniqueException will be thrown*/
				String uniqueAbbreviation = generateUniqueAbbreviation(name);
				returnObject = new Ability(name, uniqueAbbreviation);
				
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
	 * @see ScoreType#indexOf(HashMap, String)
	 */
	public static int indexOf(String abilityName) throws UnmappedException
	{
		return ScoreType.indexOf(abilityTypeNameMap, abilityName);
	}
	
	/**
	 * Returns a sorted list of abilityTypes, in order of their index
	 * 
	 * @return sorted array of all AbilityType objects
	 * @see ScoreType#getScoreTypes(HashMap, ScoreType[])
	 */
	@SuppressWarnings("unchecked")
	public static Ability[] getScoreTypes()
	{
		return ScoreType.getScoreTypes(abilityTypeNameMap, new Ability[abilityTypeNameMap.size()]);
	}
	
	/**
	 * Returns a sorted array of SpecifiedScore<Ability>, representing the
	 * default values for each Ability.
	 * 
	 * Note: the length of the returned array will be equal to the total number
	 * of Abilities that are currently mapped.
	 * 
	 * @return	default ability scores
	 */
	@SuppressWarnings("unchecked")
	public static SpecifiedScore<Ability>[] getDefaultScores()
	{
		Ability[] abilityTypes = getScoreTypes();
		SpecifiedScore<Ability>[] defaultScores = new SpecifiedScore[abilityTypes.length];
		
		for (int index = 0; index < defaultScores.length; index++)
		{
			defaultScores[index] = new SpecifiedScore<>(DEFAULT_SCORE, DEFAULT_BONUS, abilityTypes[index]);
		}
		
		return defaultScores;
	}
	
	/**
	 * @return	the number of abilities that are currently mapped
	 */
	public static int getNumberOfAbilityTypes()
	{
		return currentIndex;
	}

	public String getAbbreviation() 
	{
		return abbreviation;
	}
	
	/* (non-Javadoc)
	 * @see edu.asu.ser215.pathfinder.character.ScoreType#calculateModifier(edu.asu.ser215.pathfinder.character.SpecifiedScore)
	 */
	@Override
	public int calculateModifier(SpecifiedScore<?> score)
	{
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
	
	public static boolean loadAbilities()
	{
		return loadAbilities(new File(XML_PATH));
	}
	
	/**
	 * Attempts to load all abilities listed in the given file, and add them to
	 * the abilityMap. Will return true if the values were loaded successfully.
	 * 
	 * @param abilitiesFile	an XML file from which to load abilities
	 * @return	whether or not the abilities in the given file were loaded
	 */
	public static boolean loadAbilities(File abilitiesFile)
	{
		boolean loadSuccessful = false;
		try 
		{
			DocumentBuilder documentBuilder = 
					DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document abilitiesDocument = documentBuilder.parse(abilitiesFile);
			NodeList abilityNodes;
			
			//eliminate empty nodes and normalize document 
			abilitiesDocument.getDocumentElement().normalize();
			
			//get ability nodes from document
			abilityNodes = abilitiesDocument.getElementsByTagName(ABILITY_TAG);
			
			//parse nodes into Ability objects, and add them to the map
			for(int index = 0; index < abilityNodes.getLength(); index++)
			{
				Node currentNode = abilityNodes.item(index);
				String abilityName = currentNode.getTextContent();
				Ability.constructAbilityType(abilityName);
				System.out.println("Ability Loaded: " + abilityName);
			}
			
			loadSuccessful = true;
			
		} catch (ParserConfigurationException | SAXException | IOException e) 
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return loadSuccessful;
	}
	
	/* (non-Javadoc)
	 * Returns the name of this ability
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return this.name;
	}
}
