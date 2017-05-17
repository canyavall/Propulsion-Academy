package strategyPatternExercise;

public class TenPercentDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		return price - (price * 10 / 100);
	}

}
