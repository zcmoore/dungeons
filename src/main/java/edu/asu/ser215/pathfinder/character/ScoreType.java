package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;
import java.util.HashMap;

import edu.asu.ser215.pathfinder.character.AbilityType.UnmappedException;

public abstract class ScoreType implements Comparable<ScoreType>
{
	protected String name;
	protected int index; /*the index reference for arrays that 
							have a value for each SkillType*/
	
	public abstract int indexOf(String typeName) throws UnmappedException;
	
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
