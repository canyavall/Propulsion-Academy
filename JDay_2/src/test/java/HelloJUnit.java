import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class HelloJUnit {
//	@Rule
//	public ExpectedException exception = ExpectedException.none();
//
//	@Rule
//	public Timeout timeout = Timeout.millis(20);
//
//	@Test
//	public void timeouts() throws InterruptedException {
//		Thread.sleep(10);
//	}
	
	
	@Test
	public void firstTest(){
		assertTrue(2*2 == 4);
		
	}
	
	@Test
	public void secondTest(){
		assertFalse("2*2 ==10", 2*2==10);
	}
//	
//	@Test
//	public void thirdTest(){
//		assertEquals(2*2, 10);
//		assertNotEquals(2*2, 10);
//	}
	
//	@Test
//	public void exceptions() {
//		/* some method in our production code */
//		exception.expect(RuntimeException.class);
//		exception.expectMessage("Boom!");
//		blowUp();
//	}
//
//	private void blowUp() {
//		throw new RuntimeException("Boom!");
//	}
}
