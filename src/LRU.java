public class LRU
{
	public static int run(int size, Integer[] sequence)
	{
		int[] pages = new int[size];
		boolean[] in = new boolean[sequence.length + 1];
		
		int[] uses = new int[size];
		for (int page = 0; page < uses.length; page++) uses[page] = -1;
		
		int faults = 0;
		int watch = 1;
		
		for (int page : sequence)
		{
			if (in[page])
			{
				for (int i = 0; i < size; i++)
					if (pages[i] == page)
						uses[i] = watch++;
				
				continue;
			}
			
			int lesser = 0;
			for (int iPag = 1; iPag < size; iPag++)
				if (uses[iPag] < uses[lesser])
					lesser = iPag;
			
			if (uses[lesser] != -1) in[pages[lesser]] = false;
			
			in[pages[lesser] = page] = true;
			uses[lesser] = watch++;
			faults++;
		}
		
		return faults;
	}
}
