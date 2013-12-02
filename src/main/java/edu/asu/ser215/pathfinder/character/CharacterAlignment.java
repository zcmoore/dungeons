package edu.asu.ser215.pathfinder.character;

public enum CharacterAlignment
{
	LG ("Lawful", "Good"),
	LN ("Lawful", "Neutral"),
	LE ("Lawful", "Evil"),
	
	NG ("Neurtral", "Good"),
	NN ("True", "Neutral"),
	NE ("Neutral", "Evil"),
	
	CG ("Chaotic", "Good"),
	CN ("Chaotic", "Neutral"),
	CE ("Chaotic", "Evil");
	
	public final String moralAlignment;
	public final String methodAlignment;
	
	private CharacterAlignment(String methodAlignment, String moralAlignment)
	{
		this.moralAlignment = moralAlignment;
		this.methodAlignment = methodAlignment;
	}
	
	public String toString()
	{
		return elongatedName();
	}
	
	public String elongatedName()
	{
		return (this.methodAlignment + "-" + this.moralAlignment);
	}
}
