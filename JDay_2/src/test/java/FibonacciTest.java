import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FibonacciTest {
	@Test
	public void firstTest(){
		assertEquals(Fibonacci.fibonacci(5), 5);
	}
}
