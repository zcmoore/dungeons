package edu.asu.ser215.pathfinder.character;

/**
 * Any descendent class of Score that is modified by another score should
 * implement this interface. Note: this interface was added to 'cure' the
 * multiple inheritance problem that SkillScore is both a ModifiedScore and a
 * SpecifiedScore.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.character.ModifiedScore
 * @see edu.asu.ser215.pathfinder.character.SkillScore
 * @see edu.asu.ser215.pathfinder.character.SpecifiedScore
 */
public interface Modified
{
	public Score getModifyingScore();
}
