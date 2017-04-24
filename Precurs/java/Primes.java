import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Prints out the first 20 prime numbers.
 */
public class Primes {

	//We can start at 2, as all prime numbers can be divided by 1
	//We can remove any number that could be multiplied by 2 in
	//the iteraction because that numbers can't be prime
	//We can check only odds number as any number
	//that can be divided by 2 is not prime
	private static boolean isPrime(int n) {
		//Check if n is multiply of 2
		if (n%2==0) return false;
		// Now we only need to check odds as pair can be divided by 2
		//and we already checked it
		//At the same time, we can't pass n/2 numbers and can't be
		//bigger than (n/2)sup2
		for(int i=3; i*i<=n; i+=2) {
		        	if(n%i == 0)
		           		return false;
			}
		return true;
	}

	public static void main(String[] args) {
		int[] primes = IntStream.iterate(1, n -> n + 1)
				.filter(Primes::isPrime)
				.limit(20)
				.toArray();

		System.out.println(Arrays.toString(primes));
	}

}