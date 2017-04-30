var exercise = require('./Exercises.js');
var test = require('tape');

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

    //t.equal(exercise.convert(429563), [9, 6, 5, 4, 3, 2], 'Check it works 1'); //?????
    //t.equal(exercise.convert(234), [4, 3, 2], 'Check it works 2'); //?????
    t.equal(exercise.convert(), false, 'Check empty');
    t.equal(exercise.convert("po"), false, 'Check with another thing is not a number');

    t.eql(exercise.countRepetitions(['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante']),
                                      {kerouac: 2, fante: 3, buk: 2, hemingway: 1, hornby: 1}, 'First check');


    t.end();
  });


});
