package strategyPatternExercise;
import java.time.DayOfWeek;

public class DiscountCalculatorFactory {
	
	public DiscountCalculator getDiscountCalculatorFor(DayOfWeek day){
		if (day.name().equals("SATURDAY") ||day.name().equals("SUNDAY")){
			return new TenPercentDiscountCalculator();
		}
		return new ZeroDiscountCalculator();		
	}
}
