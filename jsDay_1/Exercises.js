//isString Exercise
/*
function isString (str){
	if (typeof str === 'string'){
		console.log("True");
	}else{
		console.log("False");
	}
}

isString('hello'); // => true
isString(['hello']); // => false
isString('this is a long sentence'); // => true
isString({ a: 2 }); // => false
*/

//isArray Exercise
/*
function isArray (arr){
	if (arr.constructor === Array){
		console.log("True");
	}else{
		console.log("False");
	}
}

isArray('hello'); // => false
isArray(['hello']); // => true
isArray([2, {}, 10]); // => true
isArray({ a: 2 }); // => false
*/

//Check for types in array
/*
function areSameType (checkValue){
	var arrayLength = checkValue.length;
	var baseType = checkValue[0].constructor;
	var control = true;
	for (var i = 1; i < arrayLength; i++){
		if (checkValue[i].constructor !== baseType){
			control = false;
			break;
		}
	}
	if (control === true){
		console.log ("True");
	}else{
		console.log ("False");
	}
}

areSameType(['hello', 'world', 'long sentence']) // => true
areSameType([1, 2, 9, 10]) // => true
areSameType([['hello'], 'hello', ['bye']]) // => false
areSameType([['hello'], [1, 2, 3], [{ a: 2 }]]) // => true
*/

//Sort and remove duplicated characters
/*
function longest (str1, str2){
	var totalString = str1.concat(str2);
	var splitString = totalString.split("");
	var resultStr = [];

	for (var i = 0; i < splitString.length; i++){
		//Check if we can find the index for every value
		//if it returns -1 it means that it was not find
		if(resultStr.indexOf(splitString[i]) == -1) {
			resultStr.push(splitString[i]);
		}
	}
	resultStr = resultStr.sort().join("");
	console.log(resultStr);
}

longest('abcccaa', 'acddddffzzz') // => 'abcdfz'

a = 'xyaabbbccccdefww'
b = 'xxxxyyyyabklmopq'
longest(a, b) // => 'abcdefklmopqwxy'

a = 'abcdefghijklmnopqrstuvwxyz'
longest(a, a) // => 'abcdefghijklmnopqrstuvwxyz'
*/

//Convert number in an array in descendent order
/*
function convert (number){
	var numberSplit = number.toString().split("");
	console.log(numberSplit.sort().reverse());
}

convert(429563) // => [9, 6, 5, 4, 3, 2]
convert(324) // => [4, 3, 2]
*/

//Count repetitions

function countRepetitions (arrayToCheck) {
	var result = {};
	var arrayResult = [];
	for (var i = 0; i < arrayToCheck.length; i++){
		if (!arrayResult.includes(arrayToCheck[i])){
			var counter = 0;
			for (var u = 0; u < arrayToCheck.length; u++){
				if (arrayToCheck[i] ===  arrayToCheck[u]){
					counter++;
				}
			}
			result[arrayToCheck[i]] = counter;
		}

	}
		return result;

}

console.log (countRepetitions(['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante']));


//Cat and Mouse
/*
function isCaught(str){
	var catPosition = str.indexOf('C');
	var mousePosition = str.indexOf('m');
	if (mousePosition > catPosition + 3){
		console.log("Another day")
	}else{
		console.log("Gotcha!")
	}
}

isCaught('C.....m') // => false
isCaught('C..m') // => true
isCaught('..C..m') // => true
*/

//Split the bill
/*
var group = {
    Amy: 20,
    Bill: 15,
    Chris: 10
}

function splitTheBill(group) {
	var totalAmount = 0;
	var numberOfUsers = 0;
	var payByUser = 0;
	var result = {};

	//Get the total amount
	for (var key in group) {
		totalAmount = totalAmount + group[key];
		numberOfUsers++;
	}
	//How much have to pay everyone
	payByUser = totalAmount / numberOfUsers;

	//Calculate the amount
	for (var key in group) {
		var toPay = payByUser - group[key];
		result[key] = toPay;
	}

	console.log(result);

}

splitTheBill(group); // => { Amy: -5, Bill: 0, Chris: 5 }
*/

//Exponentiation
/*
function exp (base, exponent){
	if (exponent == 0 ){
		return 1;
	}else{
		return base * exp(base, --exponent)
	}
}

console.log(exp(5, 3)); // => 125
console.log(exp(2, 4)); // => 16
console.log(exp(5, 1)); // => 5
console.log(exp(6, 0)); // => 1
*/

//Factorial
/*
function factorial (num){
	if (num === 0) {
		return 1
	}else{
		return num * factorial (--num);
	}

}

console.log(factorial(5)); // => 120
console.log(factorial(4)); // => 24
console.log(factorial(0)); // => 1
*/

//Fibonacci
/*
//In this function we create the recursivity
function fibRec (numReturns){
	if (numReturns == 0){
		return 0;
	}else if (numReturns ==1){
		return 1;
	}else{
		return fibRec(numReturns-1) + fibRec(numReturns-2);
	}
}

// In this function we call the recursivity
// to show the number in every step
// and then we show an array with all numbers
function fibs (numReturns){
	var arrayResult = [];
	for (var i = 0; i < numReturns; i++){
		arrayResult.push(fibRec (i));
	}
	console.log( arrayResult);
}

fibs(3); // => [0, 1, 1]
fibs(7); // => [0, 1, 1, 2, 3, 5, 8]
fibs(1); // => [0]
*/

//Zero Sum

function zeroSum(nums) {
	var result = [];
	for (i = 0; i <= nums.length;i++){
		if (nums[i] > 0) {
			for (z = 0; z <nums.length;z++){
				if (nums[i] + nums[ z] === 0){
					var value = "[" + i + "," + z + "]";
					result.push( value);
				}
			}
		}
	}
	console.log(result);
}


zeroSum([1, 5, 0, -5, 3, -1]) // => [[0, 5], [1, 3]]
zeroSum([1, -1]) // => [[0, 1]]
zeroSum([0, 4, 3, 5]) // => []
