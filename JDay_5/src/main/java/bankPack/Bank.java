package bankPack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
	private Map<Integer, Customer> customers = new HashMap<>();
	private Integer accountId = 0;
	
	public int createCustomer(String name){
		this.accountId++;
		Customer cust = new Customer(name, this.accountId);
		customers.put(cust.getId(), cust);
		return cust.getId();
	}
	
	public void deleteCustomer(Integer id){
		customers.remove(id);
	}
	
	public Customer getCustomerById(Integer id){
		return customers.get(id);		
	}
	
	public List<Customer> listofCustomers(){
		return new ArrayList<Customer>(customers.values());		
	}
}
