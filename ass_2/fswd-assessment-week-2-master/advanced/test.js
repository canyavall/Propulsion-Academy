var test = require('tape');
var advanced = require('./advanced.js');

test('MyEvery function testing', function(t) {
  function enoughBig(el) {return el >= 10};
  var testing = "mo";
  t.equal(advanced.myEvery([12, 5, 8, 130, 44], enoughBig), false, 'First array check');
  t.equal(advanced.myEvery([12, 54, 18, 130, 44], enoughBig), true, 'Second array check');
  t.equal(advanced.myEvery({"var": 15, "per": 13, "mer": 27}, enoughBig), true, 'First object check');
  t.equal(advanced.myEvery({"var": 16, "per": 2, "mer": 19}, enoughBig), false, 'Second object check');
  t.equal(advanced.mySome({"var": 16, "per": 2, "mer": 19}, testing), undefined, 'Second argument is not a function');
  t.equal(advanced.myEvery(), undefined, 'No arguments parsed');
  t.equal(advanced.myEvery([]), undefined, 'Empty Array');
  t.equal(advanced.myEvery({}), undefined, 'Empty Object');
  t.end();
});

test('MySome function testing', function(t) {
  function enoughBig(el) {return el >= 70};
  var testing = "mo";
  t.equal(advanced.mySome([12, 5, 8, 60, 44], enoughBig), false, 'First array check');
  t.equal(advanced.mySome([12, 54, 18, 130, 44], enoughBig), true, 'Second array check');
  t.equal(advanced.mySome({"var": 15, "per": 73, "mer": 27}, enoughBig), true, 'First object check');
  t.equal(advanced.mySome({"var": 16, "per": 2, "mer": 19}, enoughBig), false, 'Second object check');
  t.equal(advanced.mySome({"var": 16, "per": 2, "mer": 19}, testing), undefined, 'Second argument is not a function');
  t.equal(advanced.mySome(), undefined, 'No arguments parsed');
  t.equal(advanced.mySome([]), undefined, 'Empty Array');
  t.equal(advanced.mySome({}), undefined, 'Empty Object');
  t.end();
});

test('MyDefaults function testing', function(t) {
  t.deepEqual(advanced.myDefaults({ 'a': 1 }, { 'b': 2 }), { 'a': 1, 'b': 2 }, 'First check');
  t.deepEqual(advanced.myDefaults({ 'a': 1 }, { 'b': 2 , 'c': 3}), { 'a': 1, 'b': 2 , 'c': 3}, 'Second array check');
  t.deepEqual(advanced.myDefaults({ 'a': 1 }, { 'a': 2 , 'b': 3}), { 'a': 1, 'b': 3}, 'Second array check');
  t.deepEqual(advanced.myDefaults({ 'a': 1 }), undefined, 'Missing one argument');
  t.deepEqual(advanced.myDefaults("po", { 'a': 1 }), undefined, 'First argument is not an object');
  t.deepEqual(advanced.myDefaults({ 'a': 1 }, []), undefined, 'Second argument is not an object');
  t.deepEqual(advanced.myDefaults({}, {}), {}, 'Empty Objects');
  t.end();
});
