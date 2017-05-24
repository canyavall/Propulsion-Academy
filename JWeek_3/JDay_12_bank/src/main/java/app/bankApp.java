package app;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.BankConfig;
import domain.Account;
import domain.Customer;
import service.BankService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {BankConfig.class, })
public class bankApp {

	@Autowired
	static BankService bank;
	
	@Autowired
	JavaMailSender mailSender;
	
	public static void main(String[] args) {
		//BankService bank = new BankService();
		System.out.println("WELCOME TO PIXIE BANK");
		Scanner reader = new Scanner(System.in);
		System.out.println("PLease, select an option");
		
		while(true){
			System.out.println("1- Create a new Customer");
			System.out.println("2- Find customer by id");
			System.out.println("3- Delete customer by id");
			System.out.println("4- Add money into account");
			System.out.println("5- Subtract money from account");
			System.out.println("6- List of customers with negative balance");
			System.out.println("9- List of customers");
			int option = reader.nextInt();
			reader.nextLine();
			if (option == 0){//Logout				
				break;
			}else if (option == 1){//Create customer
				createCustomer(bank, reader);
			}else if (option == 2){// Find customer by id
				findCustomerById(bank, reader);
			}else if (option == 3){// Delete Customer
				deleteCustomer(bank, reader);
			}else if (option == 4){// Credit
				creditToCustomer(bank, reader);
			}else if (option == 5){// Debit
				debitToCustomer(bank, reader);
			}else if (option == 6){// Customers with negative balance
				negativeBalance(bank);
			}else if (option == 9){// List of customers
				listOfCustomers(bank);
			}
			System.out.println("------------------------------------------");
		}
		System.out.println("Thank you very much for using Pixie services.");
	}

	private static void listOfCustomers(BankService bank) {
		System.out.println("ID:NAME");
		List<Customer> custList = bank.listofCustomers();
		for (Customer item : custList) {					
		    System.out.println(item.toString());
		}
	}

	private static void debitToCustomer(BankService bank, Scanner reader) {
		System.out.println("Please, introduce the id of the customer ");
		Integer customerId = reader.nextInt();
		Optional<Customer> cust = bank.getCustomerById(customerId);
		cust.get().getName();
		reader.nextLine();
		System.out.println("Please, introduce the ammount to be subtract to " + cust.get().getName() + " account");
		Integer amount = reader.nextInt();
		reader.nextLine();				
		Account acc = cust.get().getAcc();
		acc.debit(amount);
		System.out.println("Customer with id " + cust.get().getName() + " has " + acc.getBalance() + "CHF");
	}

	private static void creditToCustomer(BankService bank, Scanner reader) {
		System.out.println("Please, introduce the id of the customer ");
		Integer customerId = reader.nextInt();
		Optional<Customer> cust = bank.getCustomerById(customerId);
		reader.nextLine();
		System.out.println("Please, introduce the ammount to be add to " + cust.get().getName() + " account");
		Integer amount = reader.nextInt();
		reader.nextLine();				
		Account acc = cust.get().getAcc();
		acc.credit(amount);
		System.out.println("Customer with id " + cust.get().getName() + " has " + acc.getBalance() + "CHF");
	}

	private static void deleteCustomer(BankService bank, Scanner reader) {
		System.out.println("Please, introduce the id of the customer you want to delete");
		Integer customerId = reader.nextInt();
		reader.nextLine();
		bank.deleteCustomer(customerId);
		System.out.println("Customer with id " + customerId + " has been deleted");
	}

	private static void findCustomerById(BankService bank, Scanner reader) {
		System.out.println("Please, introduce the id of the new customer");
		int customerId = reader.nextInt();
		reader.nextLine();
		Optional<Customer> cust = bank.getCustomerById(customerId);
		System.out.println(cust.get().toString());
	}

	private static void createCustomer(BankService bank, Scanner reader) {
		System.out.println("Please, introduce the name of the new customer");
		String name = reader.next();
		bank.createCustomer(name);
		System.out.println("Customer " + name + " has been created");
	}
	
	private static void negativeBalance(BankService bank) {
		System.out.println("ID:NAME");
		List<Customer> custList = bank.negativebalance();
		for (Customer item : custList) {					
		    System.out.println(item.toString());
		}
	}
}
