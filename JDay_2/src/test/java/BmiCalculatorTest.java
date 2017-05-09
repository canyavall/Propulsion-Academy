import org.junit.Test;
import static org.junit.Assert.*;

public class BmiCalculatorTest {
	
	@Test
	public void firstTest(){
	    BmiService calc= new BmiService();
	    double weight = 85;
	    double height = 1.82;
	    assertEquals(25.66, calc.calculator(weight,height), 0.01);		
	}
}
