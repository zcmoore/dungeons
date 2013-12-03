package edu.asu.ser215.pathfinder.character;

/**
 * Represents the alignment of a character. An alignment has 2 components: moral
 * (Good or Evil) and method (Lawful or Chaotic). Either component can be "neutral."
 * 
 * Note: the value of CharacterAlignment is an abbreviation. Use the elongatedName()
 * method to view the full title of the CharacterAlignment.
 * 
 * @author Zach Moore
 * @see @see <a 
 *      href="http://www.d20pfsrd.com/alignment-description/additional-rules">
 *      Pathfinders guide on Alignment</a>
 * @see #elongatedName()
 */
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
