
package enumEx;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import enumExercise.Color;
import enumExercise.PriceCalculator;
import enumExercise.Product;
import enumExercise.Size;

public class enumExTest {

	@Test
	public void calculationTest() {
		Color color = Color.RED;
		Size size = Size.XL;
		Product product = new Product("Camiseta", color, size, 100d);
		PriceCalculator calc = new PriceCalculator();
		assertEquals(105d, calc.calculatePrice(product), 0.1);
	}
		
}
