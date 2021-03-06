package edu.asu.ser215.pathfinder.character;

import edu.asu.ser215.pathfinder.TokenEntity;
import edu.asu.ser215.pathfinder.gui.map.GameBoardToken;
import edu.asu.ser215.pathfinder.inventory.Inventory;

/**
 * Contains information necessary for combat. Any entity (character or otherwise)
 * that can participate in combat should be a descendent of this class. CHARACTERS
 * (not monsters) should extend CombatCharacter instead of CombatEntity directly.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.character.CombatCharacter
 */
public class CombatEntity extends TokenEntity
{
	public static final int DEFAULT_HIT_POINTS = 10;
	
	protected Inventory inventory; //drops and/or current inventory
	protected int difficultyChallenge; //a single int to represent to overall power of the entity
	protected ModifiedScore hitPoints; //bonus will be negative to represent damage
	protected ModifiedScore initiative;
	protected int speedLand;
	protected int speedSwim;
	protected int speedClimb;
	protected int speedFly;
	protected int speedBurrow;
	protected int armourClass;
	protected int armourClassTouch;
	protected int armourClassFlatFooted;
	protected ModifiedScore saveFortitude;
	protected ModifiedScore saveReflex;
	protected ModifiedScore saveWill;
	
	/**
	 * omni-constructor
	 */
	public CombatEntity(String name, int difficultyChallenge,
			ModifiedScore hitPoints, ModifiedScore initiative, int speedLand,
			int speedSwim, int speedClimb, int speedFly, int speedBurrow,
			int armourClass, int armourClassTouch, int armourClassFlatFooted,
			ModifiedScore saveFortitude, ModifiedScore saveReflex,
			ModifiedScore saveWill) {
		super(name, true);
		this.difficultyChallenge = difficultyChallenge;
		this.hitPoints = hitPoints;
		this.initiative = initiative;
		this.speedLand = speedLand;
		this.speedSwim = speedSwim;
		this.speedClimb = speedClimb;
		this.speedFly = speedFly;
		this.speedBurrow = speedBurrow;
		this.armourClass = armourClass;
		this.armourClassTouch = armourClassTouch;
		this.armourClassFlatFooted = armourClassFlatFooted;
		this.saveFortitude = saveFortitude;
		this.saveReflex = saveReflex;
		this.saveWill = saveWill;
	}

	//-------------------------------------------------------------------------
	//-----------------------Accessors & Mutators------------------------------
	//-------------------------------------------------------------------------
	public int getDifficultyChallenge() {
		return difficultyChallenge;
	}

	public void setDifficultyChallenge(int difficultyChallenge) {
		this.difficultyChallenge = difficultyChallenge;
	}

	public ModifiedScore getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(ModifiedScore hitPoints) {
		this.hitPoints = hitPoints;
	}

	public ModifiedScore getInitiative() {
		return initiative;
	}

	public void setInitiative(ModifiedScore initiative) {
		this.initiative = initiative;
	}

	public int getSpeedLand() {
		return speedLand;
	}

	public void setSpeedLand(int speedLand) {
		this.speedLand = speedLand;
	}

	public int getSpeedSwim() {
		return speedSwim;
	}

	public void setSpeedSwim(int speedSwim) {
		this.speedSwim = speedSwim;
	}

	public int getSpeedClimb() {
		return speedClimb;
	}

	public void setSpeedClimb(int speedClimb) {
		this.speedClimb = speedClimb;
	}

	public int getSpeedFly() {
		return speedFly;
	}

	public void setSpeedFly(int speedFly) {
		this.speedFly = speedFly;
	}

	public int getSpeedBurrow() {
		return speedBurrow;
	}

	public void setSpeedBurrow(int speedBurrow) {
		this.speedBurrow = speedBurrow;
	}

	public int getArmourClass() {
		return armourClass;
	}

	public void setArmourClass(int armourClass) {
		this.armourClass = armourClass;
	}

	public int getArmourClassTouch() {
		return armourClassTouch;
	}

	public void setArmourClassTouch(int armourClassTouch) {
		this.armourClassTouch = armourClassTouch;
	}

	public int getArmourClassFlatFooted() {
		return armourClassFlatFooted;
	}

	public void setArmourClassFlatFooted(int armourClassFlatFooted) {
		this.armourClassFlatFooted = armourClassFlatFooted;
	}

	public ModifiedScore getSaveFortitude() {
		return saveFortitude;
	}

	public void setSaveFortitude(ModifiedScore saveFortitude) {
		this.saveFortitude = saveFortitude;
	}

	public ModifiedScore getSaveReflex() {
		return saveReflex;
	}

	public void setSaveReflex(ModifiedScore saveReflex) {
		this.saveReflex = saveReflex;
	}

	public ModifiedScore getSaveWill() {
		return saveWill;
	}

	public void setSaveWill(ModifiedScore saveWill) {
		this.saveWill = saveWill;
	}

	@Override
	public GameBoardToken<? extends CombatEntity> createToken() {
		return new GameBoardToken<CombatEntity>(this, GameBoardToken.DefaultIcons.monsterToken);
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}
	
	
	
	
}
