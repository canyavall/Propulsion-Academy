package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import domain.Account;
import domain.Customer;

@Service
public class BankService {

	private static final AtomicInteger idGenerator = new AtomicInteger();
	private Map<Integer, Customer> customers = new HashMap<>();
	
	public int createCustomer(String name){
		Customer cust = new Customer(name, idGenerator.incrementAndGet());
		customers.put(cust.getId(), cust);
		return cust.getId();
	}
	
	public void deleteCustomer(Integer id){
		customers.remove(id);
	}
	
	public Optional<Customer> getCustomerById(Integer id){
		return Optional.ofNullable(customers.get(id));		
	}
	
	public List<Customer> listofCustomers(){
		return new ArrayList<Customer>(customers.values());		
	}
	
	public List<Customer> negativebalance(){
		List<Customer> custRes = new ArrayList<Customer>();
		for (Customer item : this.listofCustomers()) {		
			Account acc = item.getAcc();
		    if (acc.getBalance() < 0){
		    	custRes.add(item);
		    }
		}
		return custRes;
		
	}
}
