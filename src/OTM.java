import java.util.LinkedList;

public class OTM
{
	public static int run(int size, Integer[] sequence)
	{
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] uses = new LinkedList[sequence.length + 1];
		
		for (int i = 0; i < sequence.length; i++)
		{
			int page = sequence[i];
			
			if (uses[page] == null)
				uses[page] = new LinkedList<Integer>();
			
			uses[page].add(i);
		}
		
		int[] pages = new int[size];
		boolean[] in = new boolean[sequence.length + 1]; 
		int faults = 0;
		
		for (int page : sequence)
		{
			uses[page].poll();
			if (in[page]) continue;
			
			int to = faults;
			if (to >= size) {
				to = -1;
				
				for (int iPag = 0; iPag < size; iPag++)
				{
					if (uses[pages[iPag]].size() == 0)
					{
						to = iPag;
						break;
					}
					else if (to == -1 || uses[pages[iPag]].peek() > uses[pages[to]].peek()) {
						to = iPag;
					}
				}
			}
			
			if (faults >= size) in[pages[to]] = false;
			in[pages[to] = page] = true;

			faults++;
		}
		
		return faults;
	}
}
