package person;

import java.util.ArrayList;
import java.util.List;

public class Person implements Animal {

	private List<Pet> petList= new ArrayList<>(); //Contain pets
	
	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addList(Pet pet){
		this.petList.add(pet);
	}
}
