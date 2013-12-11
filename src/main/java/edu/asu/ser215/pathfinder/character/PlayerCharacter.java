package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;
import java.util.Random;

import edu.asu.ser215.pathfinder.gui.map.GameBoardToken;

/**
 * Represents a single PC. 
 * 
 * @see <a 
 *      href="http://www.d20pfsrd.com/basics-ability-scores/character-creation">
 *      Pathfinder's guide on character building & character sheets</a>
 * @author Zach Moore
 */
public class PlayerCharacter extends CombatCharacter
{
	protected String playerName; //name of player controlling the character
	
	public static PlayerCharacter generateRandomPlayerCharacter() throws Exception
	{
		Random random = new Random();
		
		return new PlayerCharacter(
				"playerCharacter", //String name, 
				random.nextInt(10) + 1, //int difficultyChallenge,
				ModifiedScore.getArbitraryModifiedScore(), //ModifiedScore hitPoints, 
				ModifiedScore.getArbitraryModifiedScore(), //ModifiedScore initiative, 
				30, //int speedLand,
				30, //int speedSwim, 
				30, //int speedClimb, 
				30, //int speedFly, 
				30, //int speedBurrow,
				random.nextInt(10) + 9, //int armourClass, 
				10, //int armourClassTouch, 
				10, //int armourClassFlatFooted,
				ModifiedScore.getArbitraryModifiedScore(), //ModifiedScore saveFortitude, 
				ModifiedScore.getArbitraryModifiedScore(), //ModifiedScore saveReflex,
				ModifiedScore.getArbitraryModifiedScore(), //ModifiedScore saveWill, 
				new CharacterLevel(0, 1), //CharacterLevel level,
				new ArrayList<CharacterClass>(), //ArrayList<CharacterClass> classes, 
				new ScoreList<Skill>(Skill.class), //ScoreList<Skill> skillScores,
				new ScoreList<Ability>(Ability.class), //ScoreList<Ability> abilityScores,
				
				//TODO replace null
				null, //CharacterInformation characterInformation, 
				"player" //String playerName
				);
	}

	public PlayerCharacter(String name, int difficultyChallenge,
			ModifiedScore hitPoints, ModifiedScore initiative, int speedLand,
			int speedSwim, int speedClimb, int speedFly, int speedBurrow,
			int armourClass, int armourClassTouch, int armourClassFlatFooted,
			ModifiedScore saveFortitude, ModifiedScore saveReflex,
			ModifiedScore saveWill, CharacterLevel level,
			ArrayList<CharacterClass> classes, ScoreList<Skill> skillScores,
			ScoreList<Ability> abilityScores,
			CharacterInformation characterInformation, String playerName)
	{
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

	@Override
	public GameBoardToken<? extends PlayerCharacter> createToken() {
		return new GameBoardToken<PlayerCharacter>(this, GameBoardToken.DefaultIcons.playerToken);
	}
	
	
}
