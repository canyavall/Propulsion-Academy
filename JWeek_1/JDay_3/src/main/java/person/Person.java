package person;

import java.util.ArrayList;
import java.util.List;

public class Person implements Animal {

	private final String name;
	private final String text;	
	private final List<Pet> petList= new ArrayList<>(); //Contain pets
	
	public Person(String name, String text){
		this.name = name;
		this.text = text;
	}
	@Override
	public String speak() {
		return this.text;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void addList(Pet pet){
		this.petList.add(pet);
	}
}
