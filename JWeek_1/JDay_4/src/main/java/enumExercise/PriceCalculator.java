package enumExercise;

public class PriceCalculator {
	
	public double calculatePrice(Product product){
		double calc = product.getSize().getSurchargePercentage() * product.getPrice();
		return calc;		
	}
}
