package testLombok;

public class appPerson {

	public static void main(String[] args) {
		Address address = new Address(5507, "Sheunengasse", 8);
		Person person1 = new Person("Miguel", address);
		
		person1.setAge(38);
		//person1.setAddress(address);
		System.out.println(person1.getAddress().getStreet());
		System.out.println(person1.getAge());
	}
}
