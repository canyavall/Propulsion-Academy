var test = require('tape');
var bonus = require('./bonus.js');

test('MyUnion function testing', function(t) {
  t.deepEqual(bonus.myUnion([1,2], [2,3]), [1,2,3], 'First check');
  t.deepEqual(bonus.myUnion([1,2], [2,3], [4,5], [2,6]), [1,2,3,4,5,6], 'Second check');
  t.deepEqual(bonus.myUnion([1,2], [2,3], [4,5], "asd"), undefined, 'One argument is not an array');
  t.deepEqual(bonus.myUnion(), [], 'Empty arguments');
  t.end();
});
