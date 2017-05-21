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
}
