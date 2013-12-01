package edu.asu.ser215.pathfinder.character;

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

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
		recalculateLevel();
	}

	public static int[] getLevelcheckpoints() {
		return levelCheckpoints;
	}

	public static int getDefaultExperiencePoints() {
		return DEFAULT_EXPERIENCE_POINTS;
	}

	public int getLevel() {
		return level;
	}
	
	@SuppressWarnings("unused")
	private void setLevel(int level)
	{
		this.level = level;
	}
}
