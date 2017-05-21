
public class TestExamples
{
	private static final int[] sizes = new int[] { 4, 3, 4 };
	private static final int[] nPages = new int[] { 6, 8, 6 };
	private static final Integer[][] sequences = new Integer[][] {
			new Integer[] { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 },
			new Integer[] { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1 },
			new Integer[] { 1, 2, 3, 4, 1, 5, 5, 5, 5, 5, 5, 5 }
	};
	
	public static int getSize(int id) {
		return sizes[id];
	}
	
	public static int getNPages(int id) {
		return nPages[id];
	}
	
	public static Integer[] getSequence(int id) {
		return sequences[id];
	}
}
