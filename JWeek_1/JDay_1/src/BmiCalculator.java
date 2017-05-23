import java.text.DecimalFormat;
import java.util.Scanner;

public class BmiCalculator {

	public static void main(String[] args) {
		System.out.println("Let's calculate your BMI (kg/m^2)");
		
		//Ask for weigth
		Scanner personWeight = new Scanner(System.in);
		System.out.println("What is your weight in kilograms?");				
		double weight = personWeight.nextDouble();
		
		//Ask for width
		Scanner personHeight = new Scanner(System.in);
		System.out.println("What is your height in meters?");		
		double height = personHeight.nextDouble();
		
		//Calculate
		double bmiResult = weight/Math.pow(height, 2);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		//Output print
		System.out.println("Your BMI is: " + df.format(bmiResult));
	}

}
