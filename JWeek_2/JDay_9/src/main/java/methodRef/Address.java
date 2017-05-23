package methodRef;

public class Address {

	private int pc;
	private String street;
	private int number;
	
	public Address(int pc, String street, int number) {
		this.pc = pc;
		this.street = street;
		this.number = number;
	}

	public int getPc() {
		return pc;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}
	
	
}
