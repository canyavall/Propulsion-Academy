package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class example {
//	int sum = widgets.stream()
//            .filter(w -> w.getColor() == RED) // only red
//            .mapToInt(w -> w.getWeight()) // convert widget to the weight of the widget
//            .sum(); // sum them
	
	public static void main(String[] args) {
		
		Stream.of("A", "B", "C").forEach(System.out::println);
		
		Stream<String> strings = Stream.of("A", "B", "C");
		System.out.println("***********************************************************");
		strings.forEach(System.out::println);
		System.out.println("***********************************************************");
		//strings.forEach(System.out::println);//It doesnt work because the stream was already consumed before
		System.out.println("***********************************************************");
		IntStream.of(1,2,3).forEach(System.out::println);
		System.out.println("***********************************************************");
		System.out.println("Sum: " + IntStream.of(1,2,3).sum());
		System.out.println("Count: " + IntStream.of(1,2,3).count());
		
	}
}
