package testLombok;

import lombok.Data;
import lombok.NonNull;

public @Data class Person {
	private final String name;
	private int age;
	private @NonNull Address address;
	
	public void setAge(int age){
		this.age = age - 2;
	}
}
