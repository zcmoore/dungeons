package edu.asu.ser215.pathfinder.character;

/**
 * The level of a Character. Note: this is NOT the same as difficulty level.
 * When experience points are added, the level value will automatically be
 * recalculated.
 * 
 * @author Zach Moore
 */
public class CharacterLevel
{
	/**The amount of experience required for each level. index 0 corresponds to level 1*/
	public static final int[] levelCheckpoints = {0, 2000, 5000};
	public static final int DEFAULT_EXPERIENCE_POINTS = 0;
	private int experiencePoints;
	private int level;
	
	public CharacterLevel(int experiencePoints, int level)
	{
		this.experiencePoints = experiencePoints;
		this.level = level;
	}
	
	/**
	 * Sets the level to an appropriate value based on levelCheckpoints and the
	 * current amount of experience points. If EXP is negative, level will be
	 * set to 0.
	 * 
	 * @return	the new level value
	 */
	public int recalculateLevel()
	{
		this.level = levelCheckpoints.length;
		
		for (int levelIndex = 0; levelIndex < levelCheckpoints.length; levelIndex++)
		{
			if (this.experiencePoints < levelCheckpoints[levelIndex])
			{
				this.level = levelIndex;
				break;
			}
		}
		
		return this.level;
	}
	
	/**
	 * Calculates the amount of experience points this object needs before it
	 * increases a level.
	 * 
	 * @return number of experience points until the next level.
	 */
	public int experienceToNextLevel()
	{
		int experienceToNextLevel;
		
		if (!(levelCheckpoints.length < this.level || this.level < 0))
			experienceToNextLevel = levelCheckpoints[this.level] - this.experiencePoints;
		else
			experienceToNextLevel = 0;
		
		return experienceToNextLevel;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	/**
	 * Sets current experience to given value, and recalculates level based on
	 * the new exp.
	 */
	public void setExperiencePoints(int experiencePoints)
	{
		this.experiencePoints = experiencePoints;
		recalculateLevel();
	}

	/**
	 * @Unsafe	the given array should not be altered in any way.
	 */
	public static int[] getLevelcheckpoints() {
		return levelCheckpoints;
	}

	public static int getDefaultExperiencePoints() {
		return DEFAULT_EXPERIENCE_POINTS;
	}

	public int getLevel() {
		return level;
	}
	
	/**
	 * Level should not be set outside of this class.
	 */
	@SuppressWarnings("unused")
	private void setLevel(int level)
	{
		this.level = level;
	}
}
