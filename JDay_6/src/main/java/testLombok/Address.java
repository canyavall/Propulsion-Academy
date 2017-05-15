package testLombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Address {
	private final int pc;
	private final String street;	
	private final int number;
}
