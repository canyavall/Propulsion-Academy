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

    t.deepLooseEqual(exercise.convert(429563), [9, 6, 5, 4, 3, 2], 'Check it works 1');
    t.deepLooseEqual(exercise.convert(234), [4, 3, 2], 'Check it works 2');
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

    t.deepLooseEqual(exercise.zeroSum([1, 5, 0, -5, 3, -1]),[[0, 5], [1, 3]], 'First check');
    t.deepLooseEqual(exercise.zeroSum([1, -1]),[[0, 1]], 'Second check');
    t.deepLooseEqual(exercise.zeroSum("3"),false, 'String argument');
    t.deepLooseEqual(exercise.zeroSum(),false, 'No argument');

    t.equal(exercise.isAnagram('hello', 'ollhe'),true, 'First check');
    t.equal(exercise.isAnagram('world', 'ordly'),false, 'Second check');
    t.equal(exercise.isAnagram('fante', 'tenaff'),false, 'Third check');
    t.equal(exercise.isAnagram(4, 5),false, 'Wrong argument type');
    t.equal(exercise.isAnagram('hello'),false, 'One argument');
    t.equal(exercise.isAnagram(),false, 'No argument');

    t.equal(exercise.boxVolume(10, 10, 10),1, 'First check');
    t.equal(exercise.boxVolume(5, 5, 5), 0.125, 'Second check');
    t.equal(exercise.boxVolume(5, 5, 5.1), 0.1275, 'Third check');
    t.equal(exercise.boxVolume(5, 5), false, 'Missing one argument');
    t.equal(exercise.boxVolume(), false, 'Missing all arguments');
    t.equal(exercise.boxVolume(5, 5, "5"), false, 'Wrong types');

    t.deepLooseEqual(exercise.intersect([[1, 1], [4, 3]], [[2, 2], [6, 7]]),[[2, 2], [4, 3]], 'First check');
    t.deepLooseEqual(exercise.intersect([[2, 1], [4, 4]], [[1, 1], [8, 8]]),[[2, 1], [4, 4]], 'Second check');
    t.deepLooseEqual(exercise.intersect(1,2,3,4),false, 'Check arguments');
    t.deepLooseEqual(exercise.intersect(),false, 'Check empty');

    t.end();
  });


});
