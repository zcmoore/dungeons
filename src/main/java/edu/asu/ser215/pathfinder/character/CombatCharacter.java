package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

/**
 * Contains information necessary for characters in combat. Any CHARACTER that can
 * participate in combat should be a descendent of this class. Note: monsters,
 * and other classes that do not implement Character do not need to descend
 * from this class.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.character.CombatEntity
 * @see edu.asu.ser215.pathfinder.character.Character
 */
public class CombatCharacter extends CombatEntity implements Character
{
	protected CharacterLevel level;
	protected ArrayList<CharacterClass> classes;
	protected ScoreList<Skill> skillScores;
	protected ScoreList<Ability> abilityScores;
	protected CharacterInformation characterInformation;
	public CombatCharacter(String name, int difficultyChallenge,
			ModifiedScore hitPoints, ModifiedScore initiative, int speedLand,
			int speedSwim, int speedClimb, int speedFly, int speedBurrow,
			int armourClass, int armourClassTouch, int armourClassFlatFooted,
			ModifiedScore saveFortitude, ModifiedScore saveReflex,
			ModifiedScore saveWill, CharacterLevel level,
			ArrayList<CharacterClass> classes, ScoreList<Skill> skillScores,
			ScoreList<Ability> abilityScores,
			CharacterInformation characterInformation)
	{
		super(name, difficultyChallenge, hitPoints, initiative, speedLand,
				speedSwim, speedClimb, speedFly, speedBurrow, armourClass,
				armourClassTouch, armourClassFlatFooted, saveFortitude,
				saveReflex, saveWill);
		this.level = level;
		this.classes = classes;
		this.skillScores = skillScores;
		this.abilityScores = abilityScores;
		this.characterInformation = characterInformation;
	}
	public CharacterLevel getLevel() {
		return level;
	}
	public void setLevel(CharacterLevel level) {
		this.level = level;
	}
	public ArrayList<CharacterClass> getClasses() {
		return classes;
	}
	public void setClasses(ArrayList<CharacterClass> classes) {
		this.classes = classes;
	}
	public ScoreList<Skill> getSkillScores() {
		return skillScores;
	}
	public void setSkillScores(ScoreList<Skill> skillScores) {
		this.skillScores = skillScores;
	}
	public ScoreList<Ability> getAbilityScores() {
		return abilityScores;
	}
	public void setAbilityScores(ScoreList<Ability> abilityScores) {
		this.abilityScores = abilityScores;
	}
	public CharacterInformation getCharacterInformation() {
		return characterInformation;
	}
	public void setCharacterInformation(CharacterInformation characterInformation) {
		this.characterInformation = characterInformation;
	}
}
