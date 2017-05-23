var restaurant = require('./restaurant.js');
var test = require('tape');
var tapSpec = require('tap-spec');
test.createStream().pipe(tapSpec()).pipe(process.stdout);

var Dish = restaurant.Dish;
var Ingredient = restaurant.Ingredient;

test('Ingredient Class', function (t) {
  t.test('Class constructor', function (t) {
    var cheese = new Ingredient('Cheese', 5);
    var expectedCheese = {name: "Cheese", cost: 5};
    t.deepEqual(cheese,expectedCheese, "Check 1");
    t.end();
  });
});

test('Dish Class', function (t) {
  t.test('Class constructor', function (t) {

    var cheese = new Ingredient('Cheese', 5);
    var pepperoni = new Ingredient('pepperoni', 7);
    var dough = new Ingredient('doug', 9);
    var pizza = new Dish('Pizza', 35,  [cheese, dough, pepperoni]);

    t.equal(pizza.cost(), 31, 'Check cost Dish');
    t.end();
  });
});
