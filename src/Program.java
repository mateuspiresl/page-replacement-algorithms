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
			
			try {
				while (in.hasNextInt()) sequence.add(in.nextInt());
			} catch (InputMismatchException ime) { }
			
			System.out.println("FIFO " + FIFO.run(size, sequence.toArray(new Integer[0])));
			System.out.println("OTM " + OTM.run(size, sequence.toArray(new Integer[0])));
			System.out.println("LRU " + LRU.run(size, sequence.toArray(new Integer[0])));
		}
	}
}
