package strategyPatternExercise;

import java.time.DayOfWeek;

public class PricingService{
	private final DateService dateService;
	
	public PricingService(DateService day){
		this.dateService = day;
	}

	public double calculatePrice(double quantity, double amount){
		DiscountCalculatorFactory  calc = new DiscountCalculatorFactory ();
		double price = quantity * amount;
		DiscountCalculator discount = calc.getDiscountCalculatorFor(this.dateService.getDayOfWeek());
		return discount.calculateDiscountedPrice(price);
	}

}
