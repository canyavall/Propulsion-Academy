package lastExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lastExercise {

	public static void main(String[] args) {

		label("Int Stream output");
		IntStream.of(1,2,3).forEach(System.out::println);
		
		label("IntStream Sum");
		System.out.println("Sum: " + IntStream.of(1,2,3).sum());
		
		label("IntStream Count");
		System.out.println("Count: " + IntStream.of(1,2,3).count());
		
		label("IntStream Peek");
		IntStream.of(1,2,3).peek(System.out::println).count(); //Take a look but don't remove
		
		label("IntStream Limit + SummaryStatistics");
		IntStream.of(1,2,3,4,5,6).limit(3).peek(System.out::println).summaryStatistics();
		
		label("IntStream Skip + SummaryStatistics");
		IntStream.of(1,2,3,4,5,6).skip(3).peek(System.out::println).summaryStatistics(); 
		
		label("IntStream Filter");
		IntStream.of(1,2,3,4,5,6).filter(i -> i > 3).peek(System.out::println).summaryStatistics(); 
		
		label("IntStream Collecting");
		int[] newlist = IntStream.of(1,2,3,4,5,6,7,8,9).filter(i -> i > 3).toArray();
		System.out.println(Arrays.toString(newlist));
 
	}

	public static void label(String str){
		System.out.println("*****************************" + str.toUpperCase() + "************************");
	}
}
