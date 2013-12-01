package edu.asu.ser215.pathfinder.character;

import java.util.ArrayList;

import edu.asu.ser215.pathfinder.character.ScoreType.NoMapException;
import edu.asu.ser215.pathfinder.inventory.ItemData;

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
	
	public Object callStaticMethod(String methodName, Object... parameters) throws Exception
	{
		Class<?>[] parameterTypes = ItemData.primitiveArrayCast(parameters);
		return typeParameterClass.getMethod(methodName, parameterTypes).invoke(new EmptyScoreType(), parameters);
	}
	
	public SpecifiedScore<T> getScoreAt(int index) throws ArrayIndexOutOfBoundsException
	{
		return scores[index];
	}
	
	public SpecifiedScore<T> getScore(String scoreName) throws ArrayIndexOutOfBoundsException, Exception
	{
		//TODO remove call from T
		//return getScoreAt(T.indexOf(scoreName));
		return getScoreAt((int) callStaticMethod("indexOf", scoreName));
	}
	
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
