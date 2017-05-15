package merge;

public class TestCaseMaker {
	private final static int[] TINY = { 3, 1, 2 };

	public static int[] getTiny() 
	{
		return TINY;
	}

	private final static int[] ALREADY_SORTED = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static int[] getAlreadySorted() 
	{
		return ALREADY_SORTED;
	}

	private final static int[] BACKWARD = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	public static int[] getBackward() 
	{
		return BACKWARD;
	}

	private final static int[] LENGTH10 = { 6, 1, 3, 7, 8, 10, 9, 4, 5, 2 };

	public static int[] getLength10() 
	{
		return LENGTH10;
	}

	public static int[] buildRandom(int length, int maxValue) 
	{
		int[] array = new int[length];
		for (int i = 0; i < length; i++)
			array[i] = (int) (Math.random() * maxValue);
		return array;
	}
}
