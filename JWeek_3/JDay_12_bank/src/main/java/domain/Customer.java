package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	private final int id;
	private final String name;
	private Account acc = new Account();
		
	public Customer(String name, int id){
		this.name = name;
		this.id = id;
	}

	public Account getAcc(){
		return acc;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return this.id + ":" + this.name;
	}
	
}
