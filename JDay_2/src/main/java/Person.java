import java.lang.reflect.Array;

public class Person {
	private String firstName;	
	private String secondName;
	private int age;
	public Person (String firstName, String secondName, int age){
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	public static void main(String[] args) {
		Person person = new Person("Miguel", "Perello", 38);
		Person person1 = new Person("Miguel", "Perello", 38);
		Person person2 = new Person("Miguel", "Perello", 38);
		Person person3 = new Person("Miguel", "Perello", 38);
		
		System.out.println("Name: " + person.getFirstName());
		System.out.println("Second Name: " + person.getSecondName());
		System.out.println("Age: " + person.getAge());
		person.setAge(37);
		System.out.println("Age: " + person.getAge());
		System.out.println(person.toString());
		System.out.println(person.getFullName());
		printPeople(person, person1, person2, person3);
	}
	public String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	private void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	public String getFullName(){
		return this.firstName + " " + this.secondName;
	}
	@Override
	public String toString() {
		//return "Person [firstName=" + firstName + ", secondName=" + secondName + ", age=" + age + "]";
		return new StringBuilder().append("Person [firstName=").append(firstName).append(", secondName=").append(secondName).append(", age=").append(age).append("]").toString();
	}
	public static void printPeople(Person... args){
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i].toString());
		}
	}
	
}
