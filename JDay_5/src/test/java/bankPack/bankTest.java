package bankPack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import bankPack.Bank;
import bankPack.Customer;

public class bankTest {
	
	private final Bank bank = new Bank();	
	
	@Test
	public void testCustomerDB() {
		int deadId = bank.createCustomer("Deadpool");
		int spidId = bank.createCustomer("Spiderman");
		int batId = bank.createCustomer("Batman");

		assertNotNull(deadId);
		assertNotNull(spidId);
		assertNotNull(batId);
		
		List<Customer> accList = bank.listofCustomers();
		//Check number of accounts
		assertEquals(3, accList.size());
	}

}
