//import java.util.stream.IntStream;
import java.math.BigInteger;

public class Factorial {

	//In this case I'm using recursivity and BigInteger
	//Recursion is better when we need to stack (like in a tree)
	//but is better to don't abuse because we need to recall it and alocate
	//it in the memory every time the function is called
	static BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}else {
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
		}
	}
	

	//In this case i'm using an iterative loop and integer
	//THe iterative loop is better for performance
	//but sometimes harder when we need to stack results
	//or for a easy mainteneance of the code.
	/*	
	static int factorial(int n) {
		int factorialnumber = 1;
		for (int i = 1; i <=n; i++){
			factorialnumber = i * factorialnumber;
		}
		return factorialnumber;
	}
	*/


	//These are the methods for int values
	/*
	public static void main(String... args) {
		IntStream.rangeClosed(0, 50).forEach(n -> print(n));
	}

	private static void print(int n) {
		System.out.println(n + "! = " + factorial(n));
	}
	*/

	//These are the methods for biginteger values
	//I couldn't find a way to work with Intstream and BigIntegers
	//so, I created an iteraction
	public static void main(String[] args) {
		for (int i = 0; i <=50; i++){
			BigInteger bi = BigInteger.valueOf(i);
			print(bi);
		}
	}
	
	private static void print(BigInteger n) {
		System.out.println(n + "! = " + factorial(n));
	}

}