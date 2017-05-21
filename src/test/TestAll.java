import static org.junit.Assert.*;

import org.junit.Test;

public class TestAll
{
	@Test
	public void FIFO() throws Exception
	{
		assertEquals(10, FIFO.run(TestExamples.getSize(0), TestExamples.getSequence(0)));
		assertEquals(15, FIFO.run(TestExamples.getSize(1), TestExamples.getSequence(1)));
		assertEquals(5, FIFO.run(TestExamples.getSize(2), TestExamples.getSequence(2)));
	}
	
	@Test
	public void OTM() throws Exception
	{
		assertEquals(6, OTM.run(TestExamples.getSize(0), TestExamples.getSequence(0)));
		assertEquals(9, OTM.run(TestExamples.getSize(1), TestExamples.getSequence(1)));
		assertEquals(5, OTM.run(TestExamples.getSize(2), TestExamples.getSequence(2)));
	}
	
	@Test
	public void LRU() throws Exception
	{
		assertEquals(8, LRU.run(TestExamples.getSize(0), TestExamples.getSequence(0)));
		assertEquals(12, LRU.run(TestExamples.getSize(1), TestExamples.getSequence(1)));
		assertEquals(5, LRU.run(TestExamples.getSize(2), TestExamples.getSequence(2)));
	}
}
