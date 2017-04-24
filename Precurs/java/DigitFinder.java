public class DigitFinder {

	public static int find(long n) {		
		int repetition = 0;
		while (n > 9){
			n = calculation (n);
			repetition++;
		}
		return repetition;
	}
	
	private static long calculation (long n){
		//Convert to string and split values
		String stringNumber = String.valueOf(n);
		String[] parts = stringNumber.split("");
		int partsSize = parts.length;
		long totalNumber = 1;
		for (int i = 0; i < partsSize; i++){
			totalNumber = totalNumber *  Long.valueOf(parts[i]).longValue();
		}
		return totalNumber;
	}

	public static void main(String... args) {
		System.out.println(find(57));   // 3
		System.out.println(find(5923)); // 2
		System.out.println(find(90));   // 1
		System.out.println(find(7));    // 0
		System.out.println(find(999));  // 4 
	}

}