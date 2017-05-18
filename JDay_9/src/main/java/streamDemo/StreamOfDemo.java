package streamDemo;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfDemo {
	public static void main(String[] args) {
Stream.of("A", "B", "C").forEach(System.out::println);
		
		Stream<String> strings = Stream.of("A", "B", "C");
		
		System.out.println("*******************Normal Out******************************");
		strings.forEach(System.out::println);
		
		System.out.println("***********************************************************");
		//strings.forEach(System.out::println);//It doesnt work because the stream was already consumed before
		
		System.out.println("*******************IntStream Out******************************");
		IntStream.of(1,2,3).forEach(System.out::println);
		
		System.out.println("*******************Sum Out******************************");
		System.out.println("Sum: " + IntStream.of(1,2,3).sum());
		
		System.out.println("*******************Count Out******************************");
		System.out.println("Count: " + IntStream.of(1,2,3).count());
		
		System.out.println("*******************Peek Out******************************");
		IntStream.of(1,2,3).peek(System.out::println).count(); //Take a look but don't remove
		
		System.out.println("*******************Limit Out******************************");
		IntStream.of(1,2,3,4,5,6).limit(3).peek(System.out::println).summaryStatistics();
		
		System.out.println("*******************Skip Out******************************");
		IntStream.of(1,2,3,4,5,6).skip(3).peek(System.out::println).summaryStatistics(); 
	}
}
