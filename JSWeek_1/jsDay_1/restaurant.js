
//create class restaurant
function Restaurant (){
	this.dishList = {};
	this.orderNumber = 0;
	//Create an order for the restaurant
	this.orderDish = function (dish) {
		this.dishList[this.orderNumber] = dish;
		this.orderNumber++;
	};
	//Print all orders
	this.printOrders = function () {
		for (var key in this.dishList){
			console.log("Order #" + key + ": " + this.dishList[key].name);
		}
	};
	this.printCheck = function () {
		var totalPrice = 0;
		for (var key in this.dishList){
			totalPrice = totalPrice + this.dishList[key].price;
			console.log("Order #" + key + ": " + this.dishList[key].name + ' - ' + this.dishList[key].price);
		}
		console.log("Total: " + totalPrice);
	}
}

//Create class dish
function Dish (name, price, ingredients) {
	this.name = name;
	this.price = price;
	this.ingredients = ingredients;
	this.cost = function () {
		var totalCost = 10;
		for (var i = 0; i < this.ingredients.length; i++){
			totalCost = totalCost + this.ingredients[i].cost;
		}
		//console.log(this.name + " costs " + totalCost + " euros")
		return totalCost;
	};
	this.profit = function () {
		var profitValue = this.price - this.cost();
		//console.log (profitValue);
		return profitValue;
	}
}

//Create class ingredients
function Ingredient (name, cost) {
	this.name = name;
	this.cost = cost;
}

var cheese = new Ingredient('Cheese', 5);
var pepperoni = new Ingredient('pepperoni', 7);
var dough = new Ingredient('doug', 9);
var lettuce = new Ingredient('lettuce', 3);
var tomato = new Ingredient('tomato', 2);

var pizza = new Dish('Pizza', 35,  [cheese, pepperoni, dough]);
var salad = new Dish('Salad', 20,  [lettuce, cheese, tomato]);
var restaurant = new Restaurant();
restaurant.orderDish(pizza);
restaurant.orderDish(salad);
restaurant.printOrders();
pizza.profit();
restaurant.printCheck();
