import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Sorting {

	public static Double[] sortItOut(Double... arrayNumbers) {

		//Let's create 2 arrays, one for odd and one for even
		//sort them and then, merge them
		int arrayLength = arrayNumbers.length;
		List<Double> evenList = new ArrayList<Double>();
		List<Double> oddList = new ArrayList<Double>();
		for (int i = 0; i < arrayLength; i++ ){
			if (Math.floor(arrayNumbers[i]) % 2 == 0){
				evenList.add(arrayNumbers[i]); 
			}else{
				oddList.add(arrayNumbers[i]);
			}
		}

		// Merge both lists
		Collections.sort(oddList);
		Collections.sort(evenList);
		Collections.reverse(evenList);
		List<Double> fullList = new ArrayList<Double>(oddList);
		fullList.addAll(evenList);

		//Return an array
		Double[] arrayResult = new Double[fullList.size()];
		fullList.toArray(arrayResult);
		return arrayResult;		
	}
	
	public static void main(String[] args) {
		print(sortItOut(1.0, 2.0, 5.0, 8.0, 3.0, 6.0, 7.0, 4.0, 9.0));
		print(sortItOut(26.66, 24.01, 52.00, 2.10, 44.15, 13.07, 1.02, 11.15));
	}

	private static void print(Double[] array) {
		System.out.println(Arrays.toString(array));
	}
}