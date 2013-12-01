package edu.asu.ser215.pathfinder.character;

public class DomesticCharacter extends AnimateEntity implements Character
{
	protected CharacterInformation characterInformation;

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
