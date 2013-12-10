package edu.asu.ser215.pathfinder.character;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
	public static final String XML_PATH = "res/resourcepacks/default/skills.xml";
	public static final String SKILL_TAG = "skill"; //how each skill is listed in skills.xml
	public static SpecifiedScore<Ability> DEFAULT_MODIFYING_ABILITY = createDefaultModifyingAbility();
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_BONUS = 0;
	
	/**Maps all skill types using name as the key*/
	private static HashMap<String, Skill> skillTypeMap = new HashMap<>();
	private static int currentIndex = 0; /*Represents the current number of 
										SkillType objects in abilityTypeMap*/
	private final Ability modifyingAbility;
	
	private static SpecifiedScore<Ability> createDefaultModifyingAbility()
	{
		if (Skill.DEFAULT_MODIFYING_ABILITY != null)
			System.out.println("Warning: Default ability constructed.");
		return new SpecifiedScore<Ability>(Ability.DEFAULT_SCORE, Ability.DEFAULT_BONUS, 
				Ability.constructAbilityType("Default"));
	}
	
	/**
	 * Private constructor to prevent unmapped and/or duplicate instances.
	 * The current index will be assigned to the new object, and the index will
	 * be incremented.
	 */
	private Skill(String name, String modifyingAbilityName)
	{
		super(name, currentIndex);
		this.modifyingAbility = Ability.constructAbilityType(modifyingAbilityName);
		currentIndex++;
	}
	
	/**
	 * Returns a SkillType based on the given name. If the name refers to
	 * a pre-existing SkillType, then the pre-existing object will be returned.
	 * 
	 * @param name	name of the desired skill
	 */
	public static Skill constructSkillType(String name, String modifyingAbilityName)
	{
		//fetch skill from skillMap
		Skill returnObject = skillTypeMap.get(name);
		
		//if map did not contain the skill, create and map the skill
		if (returnObject == null)
		{
			//create new SkillType
			returnObject = new Skill(name, modifyingAbilityName);
			
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
	
	public static boolean loadSkills()
	{
		return loadSkills(new File(XML_PATH));
	}
	
	/**
	 * Attempts to load all skills listed in the given file, and add them to
	 * the skillMap. Will return true if the values were loaded successfully.
	 * 
	 * @param skillsFile	an XML file from which to load skills
	 * @return	whether or not the skills in the given file were loaded
	 */
	public static boolean loadSkills(File skillsFile)
	{
		boolean loadSuccessful = false;
		try 
		{
			DocumentBuilder documentBuilder = 
					DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document skillsDocument = documentBuilder.parse(skillsFile);
			NodeList skillNodes;
			
			//eliminate empty nodes and normalize document 
			skillsDocument.getDocumentElement().normalize();
			
			//get skill nodes from document
			skillNodes = skillsDocument.getElementsByTagName(SKILL_TAG);
			
			//parse nodes into Skill objects, and add them to the map
			for(int index = 0; index < skillNodes.getLength(); index++)
			{
				Node currentNode = skillNodes.item(index);
				Element skillElement = (Element) currentNode;
				String skillName = skillElement.getAttribute("name");
				String abilityName = skillElement.getAttribute("ability");
				//String skillName = currentNode.getTextContent();
				Skill.constructSkillType(skillName, abilityName);
				System.out.println("Skill Loaded: " + skillName + "[" + abilityName + "]");
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

	public Ability getModifyingAbility()
	{
		return modifyingAbility;
	}
	
	
}