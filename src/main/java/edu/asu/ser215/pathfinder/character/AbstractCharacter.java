package edu.asu.ser215.pathfinder.character;

public abstract class AbstractCharacter {
	public static final int DEFAULT_ABILITY_POINTS = 0;
	public static final int DEFAULT_EXPERIENCE_POINTS = 0;
	public static final int DEFAULT_HIT_POINTS = 10;

	protected int ability_points; // Points that can be spent on abilities
	protected int experience_points;
	protected int hit_points;
	
	private String name;
	private Abilities abilities;

	@Override
	public abstract String toString();

	public AbstractCharacter(String name) {
		this.name = name;
		this.ability_points = DEFAULT_ABILITY_POINTS;
		this.experience_points = DEFAULT_EXPERIENCE_POINTS;
		this.hit_points = DEFAULT_HIT_POINTS;
		this.abilities = new Abilities();
	}

	public String getName() {
		return name;
	}

	/**
	 * @see Abilities#getScore(edu.asu.ser215.pathfinder.character.Abilities.Ability)
	 */
	public int getAbilityScore(Abilities.Ability ability) {
		return abilities.getScore(ability);
	}

	/**
	 * @see Abilities#getModifier(edu.asu.ser215.pathfinder.character.Abilities.Ability)
	 */
	public int getAbilityModifier(Abilities.Ability ability) {
		return abilities.getModifier(ability);
	}

	/**
	 * @see Abilities#getAbility(edu.asu.ser215.pathfinder.character.Abilities.Ability)
	 */
	public int[] getAbility(Abilities.Ability ability) {
		return abilities.getAbility(ability);
	}

	/**
	 * @see Abilities#set(edu.asu.ser215.pathfinder.character.Abilities.Ability)
	 */
	public void setAbility(Abilities.Ability ability, int score, int modifier) {
		abilities.set(ability, score, modifier);
	}

	/**
	 * @see Abilities#alter(edu.asu.ser215.pathfinder.character.Abilities.Ability)
	 */
	public void alterAbility(Abilities.Ability ability, int score, int modifier) {
		abilities.alter(ability, score, modifier);
	}
}
