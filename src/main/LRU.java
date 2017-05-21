import java.util.LinkedList;
import java.util.ListIterator;

public class LRU
{
	public static int run(int size, int nPages, Integer[] sequence)
	{
		LinkedList<Integer> pages = new LinkedList<Integer>();
		boolean[] in = new boolean[nPages];
		
		int faults = 0;
		
		for (int page : sequence)
		{
			if (in[page])
			{
				ListIterator<Integer> it = pages.listIterator();
				
				while (it.hasNext()) {
					if (it.next() == page)
					{
						it.remove();
						pages.add(page);
						break;
					}
				}
				
				continue;
			}
			
			if (pages.size() >= size) in[pages.poll()] = false;
			
			pages.add(page);
			in[page] = true;
			faults++;
		}
		
		return faults;
	}
}
