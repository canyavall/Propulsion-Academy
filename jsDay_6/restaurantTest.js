var restaurant = require('./restaurant.js');
var test = require('tape');
var tapSpec = require('tap-spec');
test.createStream().pipe(tapSpec()).pipe(process.stdout);

test('Restaurant', function (t) {
  t.test('normal test', function (t) {

  var cheese = restaurant.Ingredient('Cheese', 5);
  var pepperoni = restaurant.Ingredient('pepperoni', 7);
  var dough = restaurant.Ingredient('doug', 9);
  var pizza = restaurant.Dish('Pizza', 35,  [cheese, pepperoni, dough]);
console.log(dough);
  //t.equal(pizza.cost(), 31, 'Check string');

    t.end();
  });


});
