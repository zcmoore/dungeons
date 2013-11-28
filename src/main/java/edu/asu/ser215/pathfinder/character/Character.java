package edu.asu.ser215.pathfinder.character;

public abstract class Character 
{
	public static final int DEFAULT_EXPERIENCE_POINTS = 0;
	public static final int DEFAULT_HIT_POINTS = 10;
	
	protected int[] abilityValues; /* Each entry in attributeValues corresponds 
									to an attribute in attributeList with 
									the same index. */
	protected int experiencePoints; 
	protected int level;
	protected int totalHitPoints;
	protected int currentHitPoints;
	
	protected String name;
	protected Ability abilities;

	@Override
	public abstract String toString();
}
