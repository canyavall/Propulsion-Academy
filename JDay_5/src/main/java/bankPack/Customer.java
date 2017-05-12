package bankPack;

public class Customer {
	private final int id;
	private final String name;
	private Account acc;
	
	public Customer(String name, int id){
		this.name = name;
		this.id = id;
		this.acc = new Account();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Account getAcc() {
		return acc;
	}
	
	public String toString(){
		return "Customer " + this.name;
	}
	
}
