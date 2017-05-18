package methodRef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDemo {

		private static List<Person> peopleList = new ArrayList<Person>();
		private static Set<Person> peopleSet = new HashSet<Person>();		
		private static Map<String, Person> peopleMap = new HashMap<String, Person>();
		
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
			
			peopleSet.add(person1);
			peopleSet.add(person2);
			peopleSet.add(person3);
			peopleSet.add(person1);
			
			peopleMap.put("p1", person1);
			peopleMap.put("p2", person2);
			peopleMap.put("p3", person3);
			peopleMap.put("p4", person1);
			
			//List printout
			peopleList.forEach(System.out::println);
			
			System.out.println("***************************************");
			
			//set printout
			peopleSet.forEach(System.out::println);
			
			System.out.println("***************************************");
			
			//map printout
			peopleMap.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
			
		}
}
