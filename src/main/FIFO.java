
public class FIFO
{
	public static int run(int size, int nPages, Integer[] sequence)
	{
		int[] pages = new int[size];
		boolean[] in = new boolean[nPages];
		
		int faults = 0;
		
		for (int page : sequence)
		{
			if (!in[page])
			{
				int place = faults++ % size;
				if (faults > size) in[pages[place]] = false;
				
				pages[place] = page;
				in[page] = true;
			}
		}
		
		return faults;
	}
}
