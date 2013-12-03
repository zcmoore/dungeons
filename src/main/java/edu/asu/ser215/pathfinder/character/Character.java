package edu.asu.ser215.pathfinder.character;

/**
 * Any class that represents a sentient character with backstory and associated
 * lore should be a descendent of this class. This includes Player Characters,
 * NPCs, Merchants & Shopkeepers, etc, but EXCLUDES monsters, livestock, etc.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.character.PlayerCharacter
 * @see edu.asu.ser215.pathfinder.character.DomesticCharacter
 * @see edu.asu.ser215.pathfinder.character.CombatCharacter
 */
public interface Character
{
	/**
	 * Returns a CharacterInformation object to identify the character
	 * @return identification information for this character
	 */
	CharacterInformation getCharacterInformation();
	String getName();
}
