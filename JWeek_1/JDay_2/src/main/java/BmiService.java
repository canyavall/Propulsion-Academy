public class BmiService {
	
	public double calculator(double weight, double height) {		
		//Calculate
		double res = weight/Math.pow(height, 2);
		return res;
	}
}
