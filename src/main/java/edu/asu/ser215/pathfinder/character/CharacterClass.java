package edu.asu.ser215.pathfinder.character;

import java.util.Arrays;

import edu.asu.ser215.pathfinder.core.DiceSet;

public class CharacterClass
{
	protected final Skill[] trainedSkills;
	protected final String name;
	protected final DiceSet startingWealth;
	
	public CharacterClass(Skill[] trainedSkills, String name, DiceSet startingWealth)
	{
		this.trainedSkills = trainedSkills;
		this.name = name;
		this.startingWealth = startingWealth;
		
		Arrays.sort(trainedSkills);
	}
	
	public boolean hasTrainedSkill(Skill skill)
	{
		//search trainedSkills for the desired skill
		int searchResult = Arrays.binarySearch(trainedSkills, skill);
		
		//if the skill was found, the result will be >= 0
		return (searchResult >= 0);
	}

	/**
	 * This is acceptable as long as Skill is immutable.
	 * 
	 * @return array of this class' trained skills
	 */
	public Skill[] getTrainedSkills()
	{
		return trainedSkills;
	}

	public String getName() {
		return name;
	}

	public int rollStartingWealth()
	{
		return startingWealth.roll();
	}
	
	

}
