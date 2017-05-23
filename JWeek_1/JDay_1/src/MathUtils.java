import java.util.Scanner;

public class MathUtils {
	private static final double PI = Math.PI;
	
	public static void main(String[] args) {
		System.out.println("Let's calculate the square of an integer");
		
		//Ask for weigth
		Scanner reader = new Scanner(System.in);
					
		int result = new MathUtils().squared(reader.nextInt());
		System.out.println("The squared is " + result);	
		System.out.println("Print Pi " + PI);	
	}
	 public int squared(int x){
		 return x*x;
	 }
}
