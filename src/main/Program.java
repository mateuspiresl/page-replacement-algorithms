import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{	
			int size = in.nextInt();
			List<Integer> sequence = new ArrayList<Integer>();
			int max = Integer.MIN_VALUE;
			
			try {
				while (in.hasNextInt())
				{
					int page = in.nextInt();
					if (page > max) max = page;
					
					sequence.add(page);
				}
			} catch (InputMismatchException ime) { }
			
			System.out.println("FIFO " + FIFO.run(size, max + 1, sequence.toArray(new Integer[0])));
			System.out.println("OTM " + OTM.run(size, max + 1, sequence.toArray(new Integer[0])));
			System.out.println("LRU " + LRU.run(size, max + 1, sequence.toArray(new Integer[0])));
		}
	}
}
