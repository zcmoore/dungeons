package edu.asu.ser215.pathfinder.character;

import edu.asu.ser215.pathfinder.TokenEntity;
import edu.asu.ser215.pathfinder.gui.map.GameBoardToken;
import edu.asu.ser215.pathfinder.inventory.Inventory;

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
	protected Inventory inventory; //drops and/or current inventory

	public DomesticCharacter(String name,
			CharacterInformation characterInformation) {
		super(name, true);
		this.characterInformation = characterInformation;
	}

	public CharacterInformation getCharacterInformation() {
		return characterInformation;
	}

	public void setCharacterInformation(CharacterInformation characterInformation) {
		this.characterInformation = characterInformation;
	}

	@Override
	public GameBoardToken<DomesticCharacter> createToken() {
		return new GameBoardToken<DomesticCharacter>(this, GameBoardToken.DefaultIcons.npcToken);
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}
	
	
}
