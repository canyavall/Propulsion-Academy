let DataType = require('data-type')

//isString Exercise
function isString (str){
	 return DataType.isString(str);
}
module.exports.isString = isString;


//isArray Exercise
function isArray (arr){
	return DataType.isArray(arr);
}
module.exports.isArray = isArray;

//Check for types in array
function areSameType (checkValue){
	if (DataType.isArray(checkValue) === false || checkValue.length <= 0) return false; //In this case we implemented the input checking
	let baseType = DataType.type(checkValue[0]);	//Bfore, I was checking it with .constructor. CHanged it as it was not working for booleans
	for (let i = 1; i < checkValue.length; i++){
		if (DataType.type(checkValue[i]) !== baseType)	return false;
	}
	return true
}
module.exports.areSameType = areSameType;

//Sort and remove duplicated characters
function longest (str1, str2){
	//Changed when testing
	if (DataType.isUndefined(str1) ||
			DataType.isUndefined(str2) ||
			DataType.isString(str1) === false ||
			DataType.isString(str2) === false)
				return false;

	let totalString = str1.concat(str2),
	 		splitString = totalString.split(""),
			resultStr = [];

	for (let i = 0; i < splitString.length; i++){
		//Check the index for every value if -1 iit was not found
		if(resultStr.indexOf(splitString[i]) == -1) resultStr.push(splitString[i]);
	}
	return resultStr.sort().join("");
}

module.exports.longest = longest;



/**
 * Convert number in an array in descendent order
 * Test:   Added parameter control and convert result to number,
 * because the output was an string
 */
function convert (number){
	if (DataType.isNumber(number) === false || DataType.isUndefined(number)) return false;
	let numberSplit = number.toString().split("");
	numberSplit = numberSplit.sort().reverse();
	return numberSplit.map(function(item) {
    return parseInt(item, 10);
		});
}
module.exports.convert = convert;


//Count repetitions
function countRepetitions (arrayToCheck) {
	let result = {};
	let arrayResult = [];
	for (let i = 0; i < arrayToCheck.length; i++){
		if (!arrayResult.includes(arrayToCheck[i])){
			let counter = 0;
			for (let u = 0; u < arrayToCheck.length; u++){
				if (arrayToCheck[i] ===  arrayToCheck[u]){
					counter++;
				}
			}
			result[arrayToCheck[i]] = counter;
		}

	}
		return result;

}
module.exports.countRepetitions = countRepetitions;


//Cat and Mouse
/*
function isCaught(str){
	let catPosition = str.indexOf('C');
	let mousePosition = str.indexOf('m');
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
let group = {
    Amy: 20,
    Bill: 15,
    Chris: 10
}

function splitTheBill(group) {
	let totalAmount = 0;
	let numberOfUsers = 0;
	let payByUser = 0;
	let result = {};

	//Get the total amount
	for (let key in group) {
		totalAmount = totalAmount + group[key];
		numberOfUsers++;
	}
	//How much have to pay everyone
	payByUser = totalAmount / numberOfUsers;

	//Calculate the amount
	for (let key in group) {
		let toPay = payByUser - group[key];
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
	let arrayResult = [];
	for (let i = 0; i < numReturns; i++){
		arrayResult.push(fibRec (i));
	}
	console.log( arrayResult);
}

fibs(3); // => [0, 1, 1]
fibs(7); // => [0, 1, 1, 2, 3, 5, 8]
fibs(1); // => [0]
*/

//Zero Sum
/*
function zeroSum(nums) {
	let result = [];
	for (i = 0; i <= nums.length;i++){
		if (nums[i] > 0) {
			for (z = 0; z <nums.length;z++){
				if (nums[i] + nums[ z] === 0){
					let value = "[" + i + "," + z + "]";
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
*/
