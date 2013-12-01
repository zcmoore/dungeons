package edu.asu.ser215.pathfinder.inventory;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Represents attributes of items that are not expected to change (e.g. cost
 * and weight). ItemData objects are immutable. However, changes to these
 * values can be represented using the set methods available in the Item class.
 * 
 * Each subclass of ItemData has a related class that inherits Item. Item holds
 * the "mutators" for ItemData, and should be used to represent items instead of
 * ItemData. All Items have ItemData.
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
	protected final int cost; //in copper pieces
	protected final int weight; //in pounds
	protected final String description;
	
	/**
	 * Protected constructor to prevent unmapped or duplicate instantiations.
	 */
	protected ItemData(String name, String type, int cost, int weight, String description) 
	{
		this.name = name;
		this.type = type;
		this.cost = cost;
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
		return "ItemData [name=" + name + ", type=" + type + ", cost=" + cost
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

	public int getCost() {
		return cost;
	}

	public int getWeight() {
		return weight;
	}

	public String getDescription() {
		return description;
	}
	
	//replaced by constructItemData
	/*private static <T, V extends ItemData> V createChildInstance(Class<V> desiredType, T[] desiredParameters)
	{
		V returnObject = null;
		Constructor<?>[] constructorArray; //holds all constructors of Class<V>
		Constructor<V> desiredConstructor = null; //holds the constructor which matched the provided parameters
		Class<?>[] constructorParameters; //holds the parameters of a single constructor
		Object[] primitiveParameters; //holds casted values of the parameters of a single constructor //This is used to account for primitives passed through the generic array "parameters"
		boolean numberOfParametersMatch;
		boolean typeOfParametersMatch;
		boolean primitiveParameterMatch;
        boolean constructorParameterMatch;
		
		try
		{
			constructorArray = desiredType.getDeclaredConstructors();
			
			//Search for the desired constructor within the constructor array
			for (Constructor<?> potentialConstructor : constructorArray)
			{
				//Collect information for comparison
				constructorParameters = potentialConstructor.getParameterTypes();
                primitiveParameters = primitiveClassCast(constructorParameters);
                
                //Test if numberOfParametersMatch
                numberOfParametersMatch = (constructorParameters.length == desiredParameters.length);
                
                if (numberOfParametersMatch)
                {
                	//Test if the typeOfParameters in the desiredParameters array match the typeOfParameters taken by the potential constructor
                    typeOfParametersMatch = true;
                    for (int index = 0; index < constructorParameters.length; index++)
                    {
                        primitiveParameterMatch = (primitiveParameters[index].getClass().equals(desiredParameters[index].getClass()));
                        constructorParameterMatch = (constructorParameters[index].equals(desiredParameters[index].getClass()));
                        
                        if (!(primitiveParameterMatch || constructorParameterMatch))
                        {
                            typeOfParametersMatch = false;
                            break;
                        }
                    }
                    
                    //Determine if the desired constructor has been found
                    if (typeOfParametersMatch)
                    {
                    	desiredConstructor = (Constructor<V>)potentialConstructor;
                        break;
                    }
                }
			}
			
			returnObject = desiredConstructor.newInstance(desiredParameters);
		}catch (Exception e){System.out.println(e);}
		
		return returnObject;
	}
	
	//replaced by primitiveArrayCast
	private static <T> Object[] primitiveClassCast(T[] array)
    {
        int arrayLength = array.length;
        Object[] returnArray = new Object[arrayLength];
        
        for (int index = 0; index < arrayLength; index++)
        {
            if ((array[index].equals(int.class)))
                returnArray[index] = new Integer(0);
            else if ((array[index].equals(double.class)))
                returnArray[index] = new Double(0.0);
            else if ((array[index].equals(float.class)))
                returnArray[index] = new Float(0);
            else if ((array[index].equals(byte.class)))
                returnArray[index] = new Byte("0");
            else if ((array[index].equals(short.class)))
                returnArray[index] = new Short("0");
            else if ((array[index].equals(long.class)))
                returnArray[index] = new Long("0");
            else
                returnArray[index] = array[index];
        }
        
        return returnArray;
    }*/
}
