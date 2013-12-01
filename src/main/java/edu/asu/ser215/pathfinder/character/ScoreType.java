package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;
import java.util.HashMap;

/**
 * All child classes of ScoreType should implement the following static methods:
 * 		public static int indexOf(String typeName)
 * 		public static <T extends ScoreType> T[] getScoreTypes()
 * 		public static <T extends SpecifiedScore<?>> T[] getDefaultScores()
 * 
 * @author Zach Moore
 *
 */
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
	
	public static class NoMapException extends UnmappedException
	{
		private static final long serialVersionUID = 1L;

		public NoMapException(String message)
		{
			super(message);
		}
	}
	
	protected final String name;
	protected final int index; /*the index reference for arrays that 
							have a value for each SkillType*/
	
	protected ScoreType(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	
	public abstract int calculateModifier(SpecifiedScore<?> score) throws IllegalArgumentException;
	
	protected static int indexOf(String typeName) throws UnmappedException
	{
		throw new NoMapException("Abstract class ScoreType does not map values.");
	}
	
	protected static <T extends ScoreType> T[] getScoreTypes() throws NoMapException
	{
		throw new NoMapException("Abstract class ScoreType does not map values.");
	}
	
	protected static <T extends SpecifiedScore<?>> T[] getDefaultScores() throws NoMapException
	{
		throw new NoMapException("Abstract class ScoreType does not map values.");
	}
	
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
