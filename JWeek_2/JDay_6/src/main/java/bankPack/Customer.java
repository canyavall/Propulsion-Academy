package bankPack;

import lombok.Data;
import lombok.NonNull;

public @Data class Customer {
	private final String name;
	private final int id;
	private @NonNull Account acc = new Account();

	public String toString(){
		return this.id + ":" + this.name;
	}
	
}
