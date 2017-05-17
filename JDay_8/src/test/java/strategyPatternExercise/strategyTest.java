package strategyPatternExercise;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;

import org.junit.Test;

import strategyPatternExercise.DateService;
import strategyPatternExercise.PricingService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class strategyTest {

	@Test
	public void testPriceMonday() {
		DateService dateServ = mock(DateService.class);
		when(dateServ.getDayOfWeek()).thenReturn(DayOfWeek.valueOf("MONDAY"));
		PricingService price1 = new PricingService(dateServ);
		double result = price1.calculatePrice(2, 50);
		assertEquals(100, result, 0.01);
	}
	
	@Test
	public void testPriceSaturday() {
		DateService dateServ = mock(DateService.class);
		when(dateServ.getDayOfWeek()).thenReturn(DayOfWeek.valueOf("SATURDAY"));
		PricingService price1 = new PricingService(dateServ);
		double result = price1.calculatePrice(2, 50);
		assertEquals(90, result, 0.01);
	}
}
