package edu.asu.ser215.pathfinder.character;

public class CharacterInformation
{
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
	
	public CharacterInformation(CharacterAlignment alignment, Race race,
			String deity, String gender, int age, int height, int weight,
			String hairColour, String eyeColour) {
		super();
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
