//1 - Reverse
/*
function reverse(str) {

	//Split into an array
	var splitString = str.split("");

	//reverse the array
	return splitString.reverse();

}

//Return result
console.log(reverse ("123"));
*/

/*
//2. Factorial
function factorial(n) {
	var m = 1;

	// We ahve tos et up manually for 0 as 0 * 1 = not definied
	if ( n == 0 ) {
		return 0;
	}

	// Now, just loop
	for (i = 1;  i <= n; i++){
		m = m * i;
	}
	return m;
	
}

//Return result
console.log(factorial (7));
*/

//3. Longest Word
/*
function longest_word(sentence) {
	//Split in differnt values of the array
	var splitSentence = sentence.split(" ");

	//Set up variables
	var arrayLength = splitSentence.length;
	var maxValue = 0;
	var MaxValueString = "";
	for (var i = 0; i < arrayLength; i++) {
	  	var valueArrayLength = splitSentence[i].length;
	  	//Just need to save the longest
	  	if (valueArrayLength > maxValue){	  		
	  		maxValue = valueArrayLength;
	  		MaxValueString =  splitSentence[i];
	  	}
	}
	return MaxValueString;
}

//Returnt result
console.log(longest_word ("Sorry seems to be the hardest word"));
*/

/*
//4. Sum Nums
function sum_nums(num) {
	var total = 0;
	for (i = 0; i <= num; i++){
		total = total + i;	
	}
	return total;
}


//Returnt result
console.log(sum_nums (6));
*/

/*
//5. Time Conversion
function time_conversion(totalMinutes) {
	var hours =  Math.floor(totalMinutes / 60);
	var minutes =  totalMinutes % 60;	
	return hours + ":" + minutes;
}

//Returnt result
console.log(time_conversion (130));
*/

/*
//6. Count Vowels
function count_vowels(string) {
	  var m = string.match(/[aeiou]/gi);
	  return m === null ? 0 : m.length;
}

//Returnt result
console.log(count_vowels('alphabet'));
*/

/*
//7. Palindrome
function palindrome(str) {
	var len = str.length;
	// Check for every letter if the reverse is the same, and we only need to
	//loop for the half of letters in the word
	for ( var i = 0; i < Math.floor(len/2); i++ ) {
		if (str[i] !== str[len - 1 - i]) {
			return false;
		}
	}
	return true;
}

//Returnt result
console.log(palindrome('abcba'));
*/

/*
//8. Most Letters
function nearby_az(string) {
	var splitString = string.split("");
	var splitStringLength = splitString.length;
	var control = 0;

	for  (i = 0; i <= splitStringLength; i++){
		if (splitString[i] === 'a'){
			control = i + 1;			
		}
		if (splitString[i] === 'z'  && control != 0){
			if (control + 2 >= i){
				return true;
			}else{
				control = 0;
			}
		}
	}
	return false;
}

//Returnt result
console.log(nearby_az('assz'));
*/

/*
//9. Two Sum
function two_sum(nums) {
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
	return result;
}

//Returnt result
console.log(two_sum([1, 3, -1, 5, -3]));
*/

//10. Is Power of Two
//The formula has been copied in internet, the idea is to check the bytes, and with the
// bytes we can know if it is or not power of 2 as the binary system is power of 2
//we only have to check the binary number of the number and the previows number
//if "1" fits in one of the positions, it is not power of 2
function is_power_of_two(num) {
	
	return num && (num & (num - 1)) === 0;
}

//Returnt result
console.log(is_power_of_two(8));