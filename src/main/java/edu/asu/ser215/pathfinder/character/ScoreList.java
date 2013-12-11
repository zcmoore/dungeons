package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

import edu.asu.ser215.pathfinder.character.ScoreType.NoMapException;
import edu.asu.ser215.pathfinder.inventory.ItemData;

/**
 * ScoreList represents a list of scores that corresponds directly to a specific
 * score type. Each scoreList will contain exactly the number of elements as there
 * are scoreTypes of the specified type. For instance, if the specified ScoreType
 * has 6 scores mapped, this list will contain 6 elements - one corresponding to
 * each of the mapped scoreTypes.
 * 
 * @author Zach Moore
 * @param <T> type of score to be stored in this list
 * @see edu.asu.ser215.pathfinder.character.ScoreType
 */
public class ScoreList<T extends ScoreType>
{
	protected final Class<T> typeParameterClass;
	protected SpecifiedScore<T>[] scores;
	
	private class EmptyScoreType extends ScoreType
	{
		public EmptyScoreType()
		{
			super("EmptyScore", 0);
		}

		@Override
		public int calculateModifier(SpecifiedScore<?> score)
				throws IllegalArgumentException 
		{
			//EmptyScore has a +0 modifier
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ScoreList(Class<T> typeParameterClass) throws NoMapException, Exception
	{
		this.typeParameterClass = typeParameterClass;
		//populate scores array with default values
		this.scores = (SpecifiedScore<T>[]) callStaticMethod("getDefaultScores");
	}
	
	@SafeVarargs
	public ScoreList(Class<T> typeParameterClass, 
			SpecifiedScore<T>... scoreValues) throws NoMapException, Exception
	{
		this(typeParameterClass);
		
		//TODO eliminate double loop; optimize
		for (SpecifiedScore<T> score : scoreValues)
		{
			int index = score.getScoreType().getIndex();
			this.scores[index] = score;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ScoreList(Class<T> typeParameterClass,
			ArrayList<SpecifiedScore<T>> scoreValues) throws NoMapException, Exception
	{
		this(typeParameterClass, 
				scoreValues.toArray(new SpecifiedScore[scoreValues.size()]));
	}
	
	/**
	 * Calls a static method from typeParameterClass, where typeParameterClass
	 * is the class of the type of list that this ScoreList represents.
	 * 
	 * @param methodName	name of the static method to call
	 * @param parameters	parameters of the method
	 * @return				return data from the specified method
	 * @throws Exception	if the method does not exist, cannot be accessed, or
	 * 						otherwise fails.
	 */
	protected Object callStaticMethod(String methodName, Object... parameters) throws Exception
	{
		Class<?>[] parameterTypes = ItemData.primitiveArrayCast(parameters);
		return typeParameterClass.getMethod(methodName, parameterTypes).invoke(new EmptyScoreType(), parameters);
	}
	
	/**
	 * Returns the score contained at the specified index.
	 */
	public SpecifiedScore<T> getScoreAt(int index) throws ArrayIndexOutOfBoundsException
	{
		return scores[index];
	}
	
	/**
	 * Fetches the value of a score specified by scoreName, by calling indexOf
	 * 
	 * @param scoreName		name of the score to be fetched.
	 * @return				the score specified by the given name.
	 * @see 				#callStaticMethod(String, Object...)
	 */
	public SpecifiedScore<T> getScore(String scoreName) throws ArrayIndexOutOfBoundsException, Exception
	{
		return getScoreAt((int) callStaticMethod("indexOf", scoreName));
	}
	
	/**
	 * Fetches the value of a score specified by the given score type.
	 */
	public SpecifiedScore<T> getScore(T type)
	{
		return scores[type.index];
	}
	
	public int size()
	{
		return scores.length;
	}

	public Class<T> getTypeParameterClass() {
		return typeParameterClass;
	}

	public SpecifiedScore<T>[] getScores() {
		return scores;
	}
}
