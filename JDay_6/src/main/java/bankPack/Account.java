package bankPack;

import lombok.Data;
import net.bytebuddy.implementation.bytecode.Throw;

public @Data class Account {

	private final String nr = java.util.UUID.randomUUID().toString();
	private double balance = 0;

	public void credit(double amount){
		if(amount < 0) throw new IllegalArgumentException();
		this.balance += amount;		
	}
	
	public void debit(double amount){
			this.balance -= amount;
	}
	
	public String toString(){
		return "Account " + this.nr + " has " + balance + " CHF";		
	}
}
