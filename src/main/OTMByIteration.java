public class OTMByIteration
{
	public static int run(int size, Integer[] sequence)
	{
		int[] pages = new int[size];
		boolean[] in = new boolean[sequence.length + 1]; 
		int faults = 0;

		for (int iSeq = 0; iSeq < sequence.length; iSeq++)
		{
			int page = sequence[iSeq];
			if (in[page]) continue;
			
			if (faults >= size)
			{
				int farest = -1;
				int distance = -1;
				
				for (int iPag = 0; iPag < size; iPag++)
				{
					int innerSeq = iSeq + 1;
					for (; innerSeq < sequence.length; innerSeq++)
					{
						if (pages[iPag] == sequence[innerSeq]) {
							if (innerSeq > distance)
							{
								farest = iPag;
								distance = innerSeq;
							}
							
							break;
						}
					}
					
					if (innerSeq == sequence.length)
					{
						farest = iPag;
						break;
					}
				}
				
				in[pages[farest]] = false;
				pages[farest] = page;
			}
			else pages[faults] = page;
			
			in[page] = true;
			faults++;
		}
		
		return faults;
	}
}
