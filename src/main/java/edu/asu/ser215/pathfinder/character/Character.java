package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

public class Character extends CombatEntity 
{
	protected String name;
	protected CharacterLevel level;
	protected ScoreList<AbilityType> abilityScores;
	protected ScoreList<SkillType> skillScores;
	protected ArrayList<CharacterClass> classes;
	protected CharacterAlignment alignment;
	protected Race race;
	protected String deity;
	protected String gender;
	protected int age;
	protected int height;
	protected int weight;
	protected String hairColour;
	protected String eyeColour;
	//TODO add protected Location homeLand;

	public Character(int difficultyChallenge, ModifiedScore hitPoints,
			ModifiedScore initiative, int speedLand, int speedSwim,
			int speedClimb, int speedFly, int speedBurrow, int armourClass,
			int armourClassTouch, int armourClassFlatFooted,
			ModifiedScore saveFortitude, ModifiedScore saveReflex,
			ModifiedScore saveWill, String name, CharacterLevel level,
			ScoreList<AbilityType> abilityScores,
			ScoreList<SkillType> skillScores,
			ArrayList<CharacterClass> classes, CharacterAlignment alignment,
			Race race, String deity, String gender, int age, int height,
			int weight, String hairColour, String eyeColour) {
		super(difficultyChallenge, hitPoints, initiative, speedLand, speedSwim,
				speedClimb, speedFly, speedBurrow, armourClass,
				armourClassTouch, armourClassFlatFooted, saveFortitude,
				saveReflex, saveWill);
		this.name = name;
		this.level = level;
		this.abilityScores = abilityScores;
		this.skillScores = skillScores;
		this.classes = classes;
		this.alignment = alignment;
		this.race = race;
		this.deity = deity;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.hairColour = hairColour;
		this.eyeColour = eyeColour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacterLevel getLevel() {
		return level;
	}

	public void setLevel(CharacterLevel level) {
		this.level = level;
	}

	public ScoreList<AbilityType> getAbilityScores() {
		return abilityScores;
	}

	public void setAbilityScores(ScoreList<AbilityType> abilityScores) {
		this.abilityScores = abilityScores;
	}

	public ScoreList<SkillType> getSkillScores() {
		return skillScores;
	}

	public void setSkillScores(ScoreList<SkillType> skillScores) {
		this.skillScores = skillScores;
	}

	public ArrayList<CharacterClass> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<CharacterClass> classes) {
		this.classes = classes;
	}

	public CharacterAlignment getAlignment() {
		return alignment;
	}

	public void setAlignment(CharacterAlignment alignment) {
		this.alignment = alignment;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getDeity() {
		return deity;
	}

	public void setDeity(String deity) {
		this.deity = deity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	public String getEyeColour() {
		return eyeColour;
	}

	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}
	
	
}
