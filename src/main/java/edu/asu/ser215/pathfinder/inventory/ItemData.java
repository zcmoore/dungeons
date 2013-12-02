package edu.asu.ser215.pathfinder.inventory;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Represents attributes of items that cannot be change (e.g. base_cost
 * and weight). ItemData objects are immutable. However, changes to these
 * values can be represented using the available values in Item or its subclasses)
 * or by creating a new ItemData object
 * 
 * Each subclass of ItemData has a related class that extends Item. Item holds 
 * item information that can (and is expected to) change, and should be used to 
 * represent item objects instead of ItemData. All Items have an ItemData object.
 * 
 * All ItemData objects are mapped upon instantiation. Additionally, any two
 * ItemData objects that hold the same values will reference the same
 * location in memory. The name of each ItemData will be used as its map key.
 * 
 * Direct instantiation of ItemData or its subClasses are not allowed. The
 * construct method of the appropriate subclass must be used instead.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.inventory.ItemData
 * @see edu.asu.ser215.pathfinder.inventory.Item
 *
 */
public abstract class ItemData 
{
	protected final String name;
	protected final String type;
	protected final int baseCost; //in copper pieces
	protected final int weight; //in pounds
	protected final String description;
	
	/**
	 * Protected constructor to prevent unmapped or duplicate instantiations.
	 */
	protected ItemData(String name, String type, int cost, int weight, String description) 
	{
		this.name = name;
		this.type = type;
		this.baseCost = cost;
		this.weight = weight;
		this.description = description;
	}
	
	/**
	 * Constructs an object of a subclass of item data based on the given parameters.
	 * This should only be called by a corresponding construct...Data method
	 * in a subclass of ItemData. This method ensures all data gets mapped.
	 * 
	 * @param type			the class that the return object should be
	 * @param dataMap		the map object to map the return object
	 * @param key			key used to map the return object
	 * @param parameters	parameters of the desired return object
	 * @return				an object of a subclass of ItemData that corresponds
	 * 						to the given parameters.
	 * 
	 * @see edu.asu.ser215.pathfinder.inventory.ArmourData#constructArmourData
	 * (String, String, int, int, String, int, int, int, double, int, int)
	 * 
	 * @see edu.asu.ser215.pathfinder.inventory.WeaponData#constructWeaponData
	 * (String, String, int, int, String, int, DiceSet, DiceSet, int, int, DamageType...)
	 * 
	 * @see edu.asu.ser215.pathfinder.inventory.GenericItemData#constructGenericItemData
	 * (String, String, int, int, String)
	 */
	@SuppressWarnings("unchecked")
	protected static <T, V extends ItemData> V constructItemData(Class<V> type, HashMap<String, V> dataMap, String key, T... parameters) 
	{
		V matchingData;
		Constructor<?> constructor;
		
		//attempt to find a pre-existing copy of the desired object
		matchingData = dataMap.get(key);
		if (matchingData == null)
		{
			try
			{
				//create the desired object and map it
				constructor = type.getDeclaredConstructor(primitiveArrayCast(parameters));
				matchingData = (V)constructor.newInstance(parameters);
				dataMap.put(key, matchingData);
			} catch (Exception e)
			{
				e.printStackTrace();
				matchingData = null; //matching data was not found or could not be added to map
			}
		}
		
		return matchingData;
	}
	
	/**
	 * Returns an array of Classes representing the true type of the given
	 * parameters. For example, an array of {Integer, String, double} would
	 * return an array of {int.class, String.class, double.class}
	 */
	public static <T> Class<?>[] primitiveArrayCast(T[] array)
    {
        int arrayLength = array.length;
        Class<?>[] returnArray = new Class<?>[arrayLength];
        
        //get the casted class of each object in the given array
        for (int index = 0; index < arrayLength; index++)
        {
            if ((array[index] instanceof Number))
                returnArray[index] = primitiveCast(array[index].getClass());
            else
                returnArray[index] = array[index].getClass();
        }
        
        return returnArray;
    }
	
	/**
	 * If the given parameter represents a primitive data type, the returned
	 * Class object will be a primitive class. Otherwise, this method will
	 * return null.
	 */
	public static Class<?> primitiveCast(Class<?> objectClass)
    {
        Class<?> primitiveClass = null;
        
        if ((objectClass.equals(Integer.class)))
            primitiveClass = Integer.TYPE;
        else if ((objectClass.equals(Double.class)))
            primitiveClass = Double.TYPE;
        else if ((objectClass.equals(Float.class)))
            primitiveClass = Float.TYPE;
        else if ((objectClass.equals(Short.class)))
            primitiveClass = Short.TYPE;
        else if ((objectClass.equals(Long.class)))
            primitiveClass = Long.TYPE;
        else if ((objectClass.equals(Boolean.class)))
            primitiveClass = Boolean.TYPE;
        else if ((objectClass.equals(Void.class)))
            primitiveClass = Void.TYPE;
        else if ((objectClass.equals(Byte.class)))
            primitiveClass = Byte.TYPE;
        else if ((objectClass.equals(Character.class)))
            primitiveClass = Character.TYPE;
        else
        	primitiveClass = objectClass;
        
        return primitiveClass;
    }
	
	/**
	 * Returns a String representation of an ItemData object, inclusive of all
	 * variables and their values on a single line.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemData [name=" + name + ", type=" + type + ", cost=" + baseCost
				+ ", weight=" + weight + ", description=" + description + "]";
	}
	
	//------------------------------------------------------------------------------------------------------------
	//------------------------------------------Accessors [NO MUTATORS]-------------------------------------------
	//------------------------------------------------------------------------------------------------------------
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getBaseCost() {
		return baseCost;
	}

	public int getWeight() {
		return weight;
	}

	public String getDescription() {
		return description;
	}
}
