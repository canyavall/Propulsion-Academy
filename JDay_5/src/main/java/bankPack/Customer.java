package bankPack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	private final int id;
	private final String name;
	private Map<Integer, Account> accounts = new HashMap<>();
	private static final AtomicInteger idGenerator = new AtomicInteger();
		
	public Customer(String name, int id){
		this.name = name;
		this.id = id;
		this.createAccount();
	}
	
	public int createAccount(){
		int idAccount = idGenerator.incrementAndGet();
		this.accounts.put(idAccount, new Account());
		return idAccount;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Account getAccById(Integer id) {
		return accounts.get(id);
	}
	
	public String toString(){
		return this.id + ":" + this.name;
	}
	
}
