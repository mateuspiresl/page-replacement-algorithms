import java.util.LinkedList;

public class OTM
{
	public static int run(int size, int nPages, Integer[] sequence)
	{
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] uses = new LinkedList[nPages];
		
		for (int i = 0; i < sequence.length; i++)
		{
			int page = sequence[i];
			
			if (uses[page] == null)
				uses[page] = new LinkedList<Integer>();
			
			uses[page].add(i);
		}
		
		int[] pages = new int[size];
		boolean[] in = new boolean[nPages]; 
		int faults = 0;
		
		for (int page : sequence)
		{
			uses[page].poll();
			if (in[page]) continue;
			
			if (faults >= size) {
				int to = 0;
				
				for (int iPag = 1; iPag < size && !uses[pages[to]].isEmpty(); iPag++)
					if (uses[pages[iPag]].isEmpty() || uses[pages[iPag]].peek() > uses[pages[to]].peek())
						to = iPag;
				
				in[pages[to]] = false;
				pages[to] = page;
			}
			else pages[faults] = page;
			
			in[page] = true;
			faults++;
		}
		
		return faults;
	}
	
	public static int runIterative(int size, int nPages, Integer[] sequence)
	{
		int[] pages = new int[size];
		boolean[] in = new boolean[nPages]; 
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
