import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
public class FactorialTest {

	@Test
	public void firstTest(){
		assertEquals(Factorial.factorial(BigInteger.valueOf(4)), (BigInteger.valueOf(24)));
	}
}
