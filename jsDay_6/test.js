var exercise = require('./Exercises.js');
var test = require('tape');
var tapSpec = require('tap-spec');
test.createStream().pipe(tapSpec()).pipe(process.stdout);

test('isString function', function (t) {
  t.test('normal test', function (t) {

    t.equal(exercise.isString(""), true, 'Check string');
    t.equal(exercise.isString(2), false, 'Check number');
    t.equal(exercise.isString(), false, 'Check empty');

    t.equal(exercise.isArray([]), true, 'Check array');
    t.equal(exercise.isArray(""), false, 'Check str');
    t.equal(exercise.isArray(), false, 'Check empty');

    t.equal(exercise.areSameType(['hello', 'world', 'long sentence']), true, 'All are the same');
    t.equal(exercise.areSameType([true, true, true]), true, 'All are the same');
    t.equal(exercise.areSameType(["true", false, true]), false, 'All are the same');
    t.equal(exercise.areSameType([]), false, 'Empty array');

    t.equal(exercise.longest('abcccaa', 'acddddffzzz'), "abcdfz", 'first check');
    t.equal(exercise.longest('xyaabbbccccdefww', 'xxxxyyyyabklmopq'), "abcdefklmopqwxy", 'second check');
    t.equal(exercise.longest('abcccaa', ''), "abc", 'one parameter is empty');
    t.equal(exercise.longest('abcccaa'), false, 'one parameter is not parsed');
    t.equal(exercise.longest('abcccaa', true), false, 'one parameter is not an string');

    t.deepLooseEqual(exercise.convert(429563), [9, 6, 5, 4, 3, 2], 'Check it works 1'); //?????
    t.deepLooseEqual(exercise.convert(234), [4, 3, 2], 'Check it works 2'); //?????
    t.deepLooseEqual(exercise.convert(), false, 'Check empty argument');
    t.deepLooseEqual(exercise.convert("po"), false, 'Check with another thing is not a number');

    t.deepLooseEqual(exercise.countRepetitions(['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante']),
                                      {kerouac: 2, fante: 3, buk: 2, hemingway: 1, hornby: 1}, 'First check');
    t.deepLooseEqual(exercise.countRepetitions([]),false, 'Empty array');
    t.deepLooseEqual(exercise.countRepetitions(),false, 'Empty argument');

    t.deepLooseEqual(exercise.isCaught('C.....m'),false, 'First check');
    t.deepLooseEqual(exercise.isCaught('C..m'),true, 'Second check');
    t.deepLooseEqual(exercise.isCaught(51115),false, 'It is not a string');
    t.deepLooseEqual(exercise.isCaught(),false, 'Empty argument');

    t.deepLooseEqual(exercise.splitTheBill({Amy: 20,Bill: 15,Chris: 10}),{ Amy: -5, Bill: 0, Chris: 5 }, 'First check');
    t.deepLooseEqual(exercise.splitTheBill({Amy: -5,Bill: -5,Chris: -5}),false, 'First check');
    t.deepLooseEqual(exercise.splitTheBill([]),false, 'It is not an object');
    t.deepLooseEqual(exercise.splitTheBill(),false, 'Empty argument');

    t.equal(exercise.exp(5,3),125, 'First check');
    t.equal(exercise.exp(2,4),16, 'First check');
    t.equal(exercise.exp(2),false, 'Empty argument');
    t.equal(exercise.exp(2,"4"),false, 'Different argument type');

    t.equal(exercise.factorial(5),120, 'First check');
    t.equal(exercise.factorial(0),1, 'First check');
    t.equal(exercise.factorial("5"),false, 'Argument is not a number');
    t.equal(exercise.factorial(),false, 'Empty argument');

    t.deepLooseEqual(exercise.fibs(3),[0, 1, 1], 'First check');
    t.deepLooseEqual(exercise.fibs(7),[0, 1, 1, 2, 3, 5, 8], 'Second check');
    t.deepLooseEqual(exercise.fibs("3"),false, 'String argument');
    t.deepLooseEqual(exercise.fibs(),false, 'No argument');

    t.end();
  });


});
