//Create main class
function Bank () {
	this.customers = {};
}

// Create a new customer, we need to pass the name of the curstomer
Bank.prototype.addCustomer = function(customerName) {
	var customersLenght = Object.keys(this.customers).length;;
	var key = customersLenght + 1;
	this.customers[key] = {};
  	this.customers[key]["account"] = key;
  	this.customers[key]["name"] = customerName;
  	this.customers[key]["deposit"] = 0;     	
}

// Print the account for the customer with the name...
Bank.prototype.printAccount = function(customerName) {
	for ( key in this.customers) {
		if (this.customers[key].name == customerName){
			console.log(this.customers[key].name + " account is " + this.customers[key].deposit );
		}		
	}
  	
}

//Function to allow deposit some money in the account
Bank.prototype.deposit = function(customerName, amount) {
	for ( key in this.customers) {
		if (this.customers[key].name == customerName){
			this.customers[key].deposit = this.customers[key].deposit + amount;
		}		
	}
}

//FUnction to withdraw money from all accounts. It controls there won't be negative numbers
Bank.prototype.withdraw = function(customerName, amount) {
	for ( key in this.customers) {
		if (this.customers[key].name == customerName){
			estimatedTotal =  this.customers[key].deposit - amount;
			if (estimatedTotal >= 0) {
				this.customers[key].deposit = this.customers[key].deposit - amount;
			}else{
				console.log("Action could not be commited. Not enough money in the account.")
			}			
		}		
	}
}

//Print all accounts
Bank.prototype.printAll = function(customerName, amount) {
	for ( key in this.customers) {		
		console.log(this.customers[key].name + " account is " + this.customers[key].account + " and the saldo is " + this.customers[key].deposit );
			
	}
}

//Running commands
var bank = new Bank();
bank.addCustomer('Sheldor');
bank.printAccount('Sheldor');
bank.deposit('Sheldor', 10);
bank.printAccount('Sheldor');
bank.addCustomer('Raj');
bank.printAccount('Raj');
bank.deposit('Raj', 10000);
bank.printAccount('Raj');
bank.withdraw('Raj', 100000);
bank.withdraw('Raj', 100);
bank.printAccount('Sheldor'); 
bank.printAccount('Raj'); 
bank.printAll('Raj'); 

