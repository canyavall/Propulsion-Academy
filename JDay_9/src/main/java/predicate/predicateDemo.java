package predicate;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class predicateDemo{
	public static void main(String[] args) {
	
		Predicate<String> isNotNull = pswd -> pswd != null;
		Predicate<String> isLongEnough = pswd -> pswd.trim().length() > 8;
		
		Predicate<String> containsLetter = pswd -> pswd.matches(".*[A-Za-z]+.*");
		Predicate<String> containsDigit = pswd -> pswd.matches(".*\\d+.*");
		
		Predicate<String> isvalid = isNotNull.and(isLongEnough).and(containsLetter).and(containsDigit);
		
		System.out.println(isvalid.test("adfasdfa123"));

		Stream.of("TEST", "    ", "", "TEST12345", "12345678a ")
			.filter(isvalid)
			.forEach(System.out::println);
	}
}
