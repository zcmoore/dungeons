package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;
import java.util.HashMap;

public abstract class ScoreType implements Comparable<ScoreType>
{
	/**
	 * Exception thrown when an attempt is made to add a duplicate abbreviation
	 * to the abbreviation map
	 * 
	 * @author Zach Moore
	 *
	 */
	protected static class NotUniqueException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public NotUniqueException(String message)
		{
			super(message);
		}
	}
	
	/**
	 * Exception thrown when an attempt is made to access a ScoreType that
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
	
	protected String name;
	protected int index; /*the index reference for arrays that 
							have a value for each SkillType*/
		
	public abstract int indexOf(String typeName) throws UnmappedException;
	public abstract int calculateModifier(SpecifiedScore<?> score) throws IllegalArgumentException;
	public abstract int getDefaultScore();
	
	protected static <T extends ScoreType> int indexOf(HashMap<String, T> scoreTypeMap, String scoreName) throws UnmappedException
	{
		int index;
		T scoreType = scoreTypeMap.get(scoreName);
		
		if (scoreType == null)
			throw new UnmappedException("specified type not found");
		else
		{
			index = scoreType.getIndex();
		}
		
		return index;
	}
	
	protected static <T extends ScoreType> T[] getScoreTypes(HashMap<String, T> scoreTypeMap, T[] array)
	{
		//create and populate array of all abilityTypes
		T[] skillTypes = scoreTypeMap.values().toArray(array);
		
		//sort by index
		Arrays.sort(skillTypes);
		
		return skillTypes;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
	
	@Override
	public int compareTo(ScoreType comparisonType) 
	{
		//if this id is less than the comparison id, return <0; 
		//if ids are equal, return =0
		//if id of this object is greater than the comparison id, return >0
		return this.index - comparisonType.index;
	}
}
