var sumFn = require('./index.js');
var test = require('tape');

test('sum function', function (t) {
  t.test('when pass 2 int', function (t) {
    t.equal(sumFn(3,7), 10, 'sums two integers');
    t.end();
  })


t.test('when pass 1 int', function (t) {
  t.equal(sumFn(3), 3, 'sums one integer');
  t.end();
});

});
