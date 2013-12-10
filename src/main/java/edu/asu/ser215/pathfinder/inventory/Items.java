package edu.asu.ser215.pathfinder.inventory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.asu.ser215.pathfinder.core.DiceSet;

public class Items 
{
	public static final String XML_PATH = "res/resourcepacks/default/items.xml";
	
	/**
	 * Contains the names of each tag and node name found in the items XML file.
	 * These variables will be used to load and save XMLs.
	 *
	 */
	public static class XMLTagNames
	{
		public static final String WEAPON_NODE 			= "weapon";
		public static final String ARMOUR_NODE 			= "armour";
		public static final String GENERIC_ITEM_NODE 	= "genericItem";
		public static final String NAME 				= "name";
		public static final String TYPE 				= "type";
		public static final String DESCRIPTION 			= "description";
		public static final String COST 				= "cost";
		public static final String WEIGHT 				= "weight";
		
		public static final String RANGE 				= "range";
		public static final String DAMAGE_SMALL			= "damageRollSmall";
		public static final String DAMAGE_MEDIUM		= "damageRollMedium";
		public static final String CRIT_MULTIPLIER		= "critMultiplier";
		public static final String MIN_CRIT_ROLL		= "minimumCritRoll";
		public static final String DAMAGE_TYPES			= "damageTypes";
		
		public static final String ARMOUR_BONUS			= "armourBonus";
		public static final String ARMOUR_PENALTY		= "armourCheckPenalty";
		public static final String MAX_DEX_BONUS		= "maxDexBonus";
		public static final String ARCANE_FAIL_CHANCE	= "arcaneFailureChance";
		public static final String SPEED_LIMIT20		= "speedLimitation20";
		public static final String SPEED_LIMIT30		= "speedLimitation30";
	}
	
	/**
	 * Loads ItemData (and/or subclasses thereof) from an XML file.
	 * 
	 * @param itemsFile		the XML file from which to load the items from.
	 * @param tags	the names of every tag that should be loaded from the XML.
	 * 				(e.g. WEAPON_NODE, ARMOUR_NODE, etc).
	 * @see 		XMLTagNames(edu.asu.ser215.pathfinder.inventory.Items.XMLTagNames)
	 * @return		an array of objects created from the information found in
	 * 				the specified nodes of the given XML
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ItemData> T[] loadItems(File itemsFile, String... tags)
	{
		ArrayList<T> itemsList;
		T[] parsedDataArray = null;
		
		if (tags.length == 0)
			return (T[]) new ItemData[0]; //No nodes will be found; end method
		
		try 
		{
			itemsList = new ArrayList<>();
			DocumentBuilder documentBuilder = 
					DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document itemsDocument = documentBuilder.parse(itemsFile);
			NodeList itemNodes;
			
			//eliminate empty nodes and normalize document 
			itemsDocument.getDocumentElement().normalize();
			
			
			for (String tag : tags)
			{
				//get specified nodes from document
				itemNodes = itemsDocument.getElementsByTagName(tag);
				
				//parse nodes into ItemData objects, and add them to the list
				T[] parsedData = parseItemData(itemNodes, tag);
				itemsList.addAll(Arrays.asList(parsedData));
			}
			
			//convert parsed list to an array of the appropriate type
			String tag = tags[0];
			
			if (tags.length > 1)
				parsedDataArray = (T[]) itemsList.toArray(new ItemData[itemsList.size()]);
			
			else if (tag.equals(XMLTagNames.GENERIC_ITEM_NODE))
				parsedDataArray = (T[]) itemsList.toArray(new GenericItemData[itemsList.size()]);
			
			else if (tag.equals(XMLTagNames.WEAPON_NODE))
				parsedDataArray = (T[]) itemsList.toArray(new WeaponData[itemsList.size()]);
			
			else if (tag.equals(XMLTagNames.ARMOUR_NODE))
				parsedDataArray = (T[]) itemsList.toArray(new ArmourData[itemsList.size()]);
			
		} catch (ParserConfigurationException | SAXException | IOException e) 
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return parsedDataArray;
	}
	
	/**
	 * Loads all ItemData found in the given XML file. This is equivalent to a
	 * call to loadItems (itemsFile, WEAPON_NODE, ARMOUR_NODE, GENERIC_ITEM_NODE)
	 * 
	 * @param 	itemsFile	XML file from which to load the ItemData[]
	 * @return	an array of ItemData objects created from the information found
	 * 			in the given XML.
	 * @see		edu.asu.ser215.pathfinder.inventory.Items#loadItems(File, String...)
	 */
	public static ItemData[] loadAllItems(File itemsFile)
	{
		return loadItems(itemsFile, XMLTagNames.WEAPON_NODE, 
				XMLTagNames.ARMOUR_NODE, XMLTagNames.GENERIC_ITEM_NODE);
	}
	
	/**
	 * @see		edu.asu.ser215.pathfinder.inventory.Items#loadAllItems(File)
	 */
	public static ItemData[] loadAllItems()
	{
		return loadAllItems(new File(XML_PATH));
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends ItemData> T[] parseItemData(NodeList nodeList, String... expectedNodeNames)
	{
		ArrayList<ItemData> parsedDataList = null;
		T[] parsedDataArray = null;
		int numberOfNodes = nodeList.getLength();
		
		if (expectedNodeNames.length == 0)
			return (T[]) new ItemData[0]; //No nodes will be found; end method
		
		try
		{
			parsedDataList = new ArrayList<>();
			Node currentNode;
			Element itemElement;
			ItemData parsedData;
			String currentNodeName;
			boolean acceptableNode;
			
			//prepare for binary search
			Arrays.sort(expectedNodeNames);
			
			for (int index = 0; index < numberOfNodes; index++)
			{
				currentNode = nodeList.item(index);
				currentNodeName = currentNode.getNodeName();
				parsedData = null;
				
				//ensure the node matches the user defined parameters
				acceptableNode = (Arrays.binarySearch(expectedNodeNames, currentNodeName) >= 0);
				
				if (currentNode.getNodeType() == Node.ELEMENT_NODE 
						&& acceptableNode)
				{
					itemElement = (Element) currentNode;
					
					//parse data of appropriate type;
					if (currentNodeName.equals(XMLTagNames.GENERIC_ITEM_NODE))
						parsedData = parseSingleGenericItemData(itemElement);
					else if (currentNodeName.equals(XMLTagNames.WEAPON_NODE))
						parsedData = parseSingleWeaponData(itemElement);
					else if (currentNodeName.equals(XMLTagNames.ARMOUR_NODE))
						parsedData = parseSingleArmourData(itemElement);
					
					//if the node could not be parsed, do not add it to the list
					if (!(parsedData == null))
						parsedDataList.add(parsedData);
				}
			}
			
			//convert parsed list to an array of the appropriate type
			String nodeName = expectedNodeNames[0];
			if (expectedNodeNames.length > 1)
				parsedDataArray = (T[]) parsedDataList.toArray(new ItemData[parsedDataList.size()]);
			
			else if (nodeName.equals(XMLTagNames.GENERIC_ITEM_NODE))
				parsedDataArray = (T[]) parsedDataList.toArray(new GenericItemData[parsedDataList.size()]);
			
			else if (nodeName.equals(XMLTagNames.WEAPON_NODE))
				parsedDataArray = (T[]) parsedDataList.toArray(new WeaponData[parsedDataList.size()]);
			
			else if (nodeName.equals(XMLTagNames.ARMOUR_NODE))
				parsedDataArray = (T[]) parsedDataList.toArray(new ArmourData[parsedDataList.size()]);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			parsedDataArray = (T[]) new ItemData[0];
		}
		
		return parsedDataArray;
	}
	
	/**
	 * Creates an GenericItemData object based on the information contained in the
	 * given XML element. Returns null if there is not enough information, or
	 * if the available information is not applicable
	 * 
	 * @param element	XML element containing the desired data
	 * @return			GenericItemData object representative of the given element
	 */
	public static GenericItemData parseSingleGenericItemData(Element element)
	{
		GenericItemData returnData;
		//parameters of GenericItemData
		String name;
		String type;
		int cost; //in copper pieces
		int weight; //in pounds
		String description;
		
		try
		{
			name = element.getElementsByTagName(XMLTagNames.NAME)
					.item(0).getTextContent();
			type = element.getElementsByTagName(XMLTagNames.TYPE)
					.item(0).getTextContent();
			cost = Integer.parseInt(element.getElementsByTagName(XMLTagNames.COST)
					.item(0).getTextContent());
			weight = Integer.parseInt(element.getElementsByTagName(XMLTagNames.WEIGHT)
					.item(0).getTextContent());
			description = element.getElementsByTagName(XMLTagNames.DESCRIPTION)
					.item(0).getTextContent();
			
			returnData = GenericItemData.constructGenericItemData(name, type, cost, 
					weight, description);
			
			System.out.println("GenericItemData Loaded: " + returnData.toString());
		} catch (Exception e)
		{
			e.printStackTrace();
			returnData = null;
		}
		
		
		return returnData;
	}
	
	/**
	 * Creates an WeaponData object based on the information contained in the
	 * given XML element. Returns null if there is not enough information, or
	 * if the available information is not applicable
	 * 
	 * @param element	XML element containing the desired data
	 * @return			WeaponData object representative of the given element
	 */
	public static WeaponData parseSingleWeaponData(Element element)
	{
		WeaponData returnData;
		//parameters of WeaponData
			//generic parameters
		String name;
		String type;
		int cost;
		int weight;
		String description;
			//weapon-specific parameters
		int range;
		DiceSet damagePotentialSmall;
		DiceSet damagePotentialMedium;
		int critMultiplier;
		int minimumCritRoll;
		DamageType[] damageTypes;
		
		try
		{
			//collect data for WeaponData object
			name = element.getElementsByTagName(XMLTagNames.NAME)
					.item(0).getTextContent();
			type = element.getElementsByTagName(XMLTagNames.TYPE)
					.item(0).getTextContent();
			cost = Integer.parseInt(element.getElementsByTagName(XMLTagNames.COST)
					.item(0).getTextContent());
			weight = Integer.parseInt(element.getElementsByTagName(XMLTagNames.WEIGHT)
					.item(0).getTextContent());
			description = element.getElementsByTagName(XMLTagNames.DESCRIPTION)
					.item(0).getTextContent();
			//collect data for WeaponData object
			range = Integer.parseInt(element.getElementsByTagName(XMLTagNames.RANGE)
					.item(0).getTextContent());
			damagePotentialSmall = DiceSet.parseDiceSet(element.getElementsByTagName(XMLTagNames.DAMAGE_SMALL)
					.item(0).getTextContent());
			damagePotentialMedium = DiceSet.parseDiceSet(element.getElementsByTagName(XMLTagNames.DAMAGE_MEDIUM)
					.item(0).getTextContent());
			critMultiplier = Integer.parseInt(element.getElementsByTagName(XMLTagNames.CRIT_MULTIPLIER)
					.item(0).getTextContent());
			minimumCritRoll = Integer.parseInt(element.getElementsByTagName(XMLTagNames.MIN_CRIT_ROLL)
					.item(0).getTextContent());
			damageTypes = DamageType.parseDamageTypes(element.getElementsByTagName(XMLTagNames.DAMAGE_TYPES)
					.item(0).getTextContent());
			
			//construct WeaponData object
			returnData = WeaponData.constructWeaponData(name, type, cost, 
					weight, description, range, damagePotentialSmall, 
					damagePotentialMedium, critMultiplier, 
					minimumCritRoll, damageTypes);
			
			System.out.println("WeaponData Loaded: " + returnData.toString());
		} catch (NumberFormatException e)
		{
			returnData = null;
			
		} catch (Exception e)
		{
			e.printStackTrace();
			returnData = null;
		}
		
		
		return returnData;
	}
	
	/**
	 * Creates an ArmourData object based on the information contained in the
	 * given XML element. Returns null if there is not enough information, or
	 * if the available information is not applicable
	 * 
	 * @param element	XML element containing the desired data
	 * @return			ArmourData object representative of the given element
	 */
	public static ArmourData parseSingleArmourData(Element element)
	{
		ArmourData returnData;
		//parameters of ArmourData
			//generic parameters
		String name;
		String type;
		int cost;
		int weight;
		String description;
			//armour-specific parameters
		int armourBonus;
		int armourCheckPenalty;
		int maxDexBonus;
		double arcaneFailureChance;
		int speedLimitation20;
		int speedLimitation30;
		
		try
		{
			//collect data for WeaponData object
			name = element.getElementsByTagName(XMLTagNames.NAME)
					.item(0).getTextContent();
			type = element.getElementsByTagName(XMLTagNames.TYPE)
					.item(0).getTextContent();
			cost = Integer.parseInt(element.getElementsByTagName(XMLTagNames.COST)
					.item(0).getTextContent());
			weight = Integer.parseInt(element.getElementsByTagName(XMLTagNames.WEIGHT)
					.item(0).getTextContent());
			description = element.getElementsByTagName(XMLTagNames.DESCRIPTION)
					.item(0).getTextContent();
			//collect data for WeaponData object
			armourBonus = Integer.parseInt(element.getElementsByTagName(XMLTagNames.ARMOUR_BONUS)
					.item(0).getTextContent());
			armourCheckPenalty = Integer.parseInt(element.getElementsByTagName(XMLTagNames.ARMOUR_PENALTY)
					.item(0).getTextContent());
			maxDexBonus = Integer.parseInt(element.getElementsByTagName(XMLTagNames.MAX_DEX_BONUS)
					.item(0).getTextContent());
			arcaneFailureChance = Double.parseDouble(element.getElementsByTagName(XMLTagNames.ARCANE_FAIL_CHANCE)
					.item(0).getTextContent());
			speedLimitation20 = Integer.parseInt(element.getElementsByTagName(XMLTagNames.SPEED_LIMIT20)
					.item(0).getTextContent());
			speedLimitation30 = Integer.parseInt(element.getElementsByTagName(XMLTagNames.SPEED_LIMIT30)
					.item(0).getTextContent());
			
			//construct ArmourData object
			returnData = ArmourData.constructArmourData(name, type, cost, 
					weight, description, armourBonus, armourCheckPenalty, 
					maxDexBonus, arcaneFailureChance, speedLimitation20, 
					speedLimitation30);
			
			System.out.println("ArmourData Loaded: " + returnData.toString());
		} catch (NumberFormatException e)
		{
			returnData = null;
			
		} catch (Exception e)
		{
			e.printStackTrace();
			returnData = null;
		}
		
		
		return returnData;
	}
	
	/**
	 * Calculate the weight of all items in the given array.
	 * 
	 * @param 	items	array of items for which to calculate the weight
	 * @return	weight of all items in the given array; in pounds
	 */
	public static int calculateWeight(Item<?>[] items)
	{
		int totalWeight = 0;
		
		for (Item<?> item : items)
		{
			totalWeight += item.getData().getWeight();
		}
		
		return totalWeight;
	}
}
