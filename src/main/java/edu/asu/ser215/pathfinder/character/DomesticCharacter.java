package edu.asu.ser215.pathfinder.character;

/**
 * Represents an NPC that cannot or will not participate in combat. This is a
 * lightweight alternative to CombatCharacter.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.character.CombatCharacter
 */
public class DomesticCharacter extends TokenEntity implements Character
{
	protected CharacterInformation characterInformation; //demographics about this character

	public DomesticCharacter(String name,
			CharacterInformation characterInformation) {
		super(name);
		this.characterInformation = characterInformation;
	}

	public CharacterInformation getCharacterInformation() {
		return characterInformation;
	}

	public void setCharacterInformation(CharacterInformation characterInformation) {
		this.characterInformation = characterInformation;
	}
	
	
}
