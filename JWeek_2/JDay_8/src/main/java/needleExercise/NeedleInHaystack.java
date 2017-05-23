package needleExercise;

import java.util.Arrays;
import java.util.Random;

public class NeedleInHaystack {
	private static final int NEEDLE = 42; // 4000;
	private static final int HAYSTACK_SIZE = 10; // 100;

	private static final Random random = new Random();

	private static int numStepsInAlgorithm = 0;

	public static void main(String[] args) throws Exception {
		int[] haystack = new int[HAYSTACK_SIZE];

		// Add needle to haystack
		haystack[0] = NEEDLE;

		// Add random numbers to haystack
		for (int i = 1; i < haystack.length; i++) {
			haystack[i] = random.nextInt(HAYSTACK_SIZE * HAYSTACK_SIZE) + 1;
		}

		Arrays.sort(haystack);

		System.out.println("Needle:   " + NEEDLE);
		System.out.println("Haystack: " + Arrays.toString(haystack));
		System.out.println();

		final int index = findNeedleInHaystack(NEEDLE, haystack);
		if (haystack[index] != NEEDLE) {
			System.out.println("ERROR: Needle is NOT at index: " + index);
		}
		else {
			System.out.println("Found needle at index: " + index);
		}

		System.out.println();
		System.out.println("Algorithm took " + numStepsInAlgorithm + " steps.");
	}

	/**
	 * Finds the index of the needle in the haystack.
	 */
	public static int findNeedleInHaystack(int needle, int[] haystack) {
		boolean searching = true;
		int amount = haystack.length / 2;
		int middle = amount;
		
		while (searching){
			System.out.println(middle + "/"+amount);
			amount = amount / 2;
			if (needle > haystack[middle]){
				middle = middle + amount;
			}else if(needle < haystack[middle]){
				middle = middle - amount;
			}else if(needle == haystack[middle]){
				searching = false;
			}

			numStepsInAlgorithm++;
		}
		
		return middle;
	}
	

}
