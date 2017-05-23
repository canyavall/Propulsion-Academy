import java.text.DecimalFormat;
import java.util.Scanner;

public class BmiCalculator {

	public static void main(String[] args) {
		BmiService bmi = new BmiService();
		
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
		double bmiResult = bmi.calculator(weight, height);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		//Close scanner
		personWeight.close();
		personHeight.close();
		
		//Output print
		String str = "Your BMI is: " + df.format(bmiResult);
		System.out.println(str);
	}

}
