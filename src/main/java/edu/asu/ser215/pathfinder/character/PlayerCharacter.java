package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

public class PlayerCharacter extends CombatCharacter
{
	protected String playerName; //name of player controlling the character

	public PlayerCharacter(String name, int difficultyChallenge,
			ModifiedScore hitPoints, ModifiedScore initiative, int speedLand,
			int speedSwim, int speedClimb, int speedFly, int speedBurrow,
			int armourClass, int armourClassTouch, int armourClassFlatFooted,
			ModifiedScore saveFortitude, ModifiedScore saveReflex,
			ModifiedScore saveWill, CharacterLevel level,
			ArrayList<CharacterClass> classes, ScoreList<Skill> skillScores,
			ScoreList<Ability> abilityScores,
			CharacterInformation characterInformation, String playerName) {
		super(name, difficultyChallenge, hitPoints, initiative, speedLand,
				speedSwim, speedClimb, speedFly, speedBurrow, armourClass,
				armourClassTouch, armourClassFlatFooted, saveFortitude,
				saveReflex, saveWill, level, classes, skillScores,
				abilityScores, characterInformation);
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
}
