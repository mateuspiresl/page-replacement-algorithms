
public class FIFO
{
	public static int run(int size, Integer[] sequence)
	{
		int[] pages = new int[size];
		int faults = 0;
		
		for (int page : sequence)
		{
			int max = (size < faults ? size : faults) - 1;
			
			for (; max >= 0; max--)
				if (page == pages[max])
					break;
			
			if (max == -1) pages[faults++ % size] = page;
		}
		
		return faults;
	}
}
