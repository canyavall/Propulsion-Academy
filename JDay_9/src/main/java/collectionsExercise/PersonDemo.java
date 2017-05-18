package collectionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDemo {

		private static List<Person> peopleList = new ArrayList<Person>();
		private static Set<Person> peopleSet;		
		private static Map<String, Person> peopleMap;
		
		public static void main(String[] args) {
			Address address1 = new Address(5507, "Sheunengasse", 8);
			Address address2 = new Address(6694, "Reumentstrasse", 12);
			Address address3 = new Address(4819, "Melligerstrasse", 32);
			Person person1 = new Person ("Juan", address1);
			Person person2 = new Person ("Pepe", address2);
			Person person3 = new Person ("Maria", address3);
			peopleList.add(person1);
			peopleList.add(person2);
			peopleList.add(person3);
			peopleList.add(person1);
			
			//Add to a list
			peopleList.forEach(person->System.out.println(person.getName()));
			
			
		}
}
