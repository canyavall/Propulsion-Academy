/**
 * Expanded Math Object
 */
// var myMath = Object.create(Math);
//
// myMath.randomInt = function (max, min = 0){
//   return Math.floor(Math.random() * (max - min + 1) + min);
// }
//
// console.log(myMath.randomInt(5)); // 3 for example
// console.log(myMath.randomInt(10)); // 10 for example
// console.log(myMath.random()); // 10 for example
// console.log(myMath.round(0.5));
// console.log(myMath.randomInt(10, -4)); // -3 for example


/**
 * Add reverse method to String object
 */
// String.prototype.reverse = function () {
//   return this.split("").reverse().join("");
// }
// console.log('hello'.reverse());


/**
 * myEach
 */
// function myEach (arr, fn){
//   let arrResult = [];
//   if (arr.constructor !== Array) throw "Is not an array";
//   if (typeof fn !== "function") throw "Is not a function";
//   for(let i = 0; i < arr.length; i++){
//     if(typeof arr[i] !== "undefined"){
//       let result = fn(arr[i], i, arr);
//       arrResult.push(result);
//     }
//   }
//   if (arguments[2] === true) return arrResult;
// }
//
// function logArrayElements(element, index, array) {
//     //console.log("a[" + index + "] = " + element);
// }
// var arr = [2, 5, 9];
// var pe = myEach([2, 5, 9], logArrayElements);
// var pe = arr.forEach(logArrayElements);
// console.log(pe);
//
/**
 * myMap
//  */
// Array.prototype.myMap = function (fn){
//   return myEach (this, fn, true);
// }
// function convertToUppercase (str) {
//   return str.toUpperCase();
// }
//
// var arrayTestMap = ["macarena", "pepe"];
// console.log(arrayTestMap.myMap(convertToUppercase));

// /**
//  * myFilter
//  */
//  Array.prototype.myFilter = function (fn){
//    let arrResult = [];
//    if (this.constructor !== Array) throw "Is not an array";
//    if (typeof fn !== "function") throw "Is not a function";
//    for(let i = 0; i < this.length; i++){
//      if(typeof this[i] !== "undefined"){
//        let result = fn(this[i], i, this);
//        if (result) arrResult.push(this[i]);
//      }
//    }
//    return arrResult
//  }
//
//   function filterToCheck (num) {
//    return num > 8;
//  }
//
//  var arrayTestFilter = [2,5,7,9,11];
//  console.log(arrayTestFilter.myFilter(filterToCheck));

/**
 * Merge
 */

function merge (){
  let objResult = {};
  for (let i = 0; i < arguments.length; i++) {
    if (typeof arguments[i] !== "object") throw "Argument is not an object";
    for (key in arguments[i]){
      if (!objResult[key])objResult[key] = arguments[i][key];
    }
  }
  return objResult;
}
console.log(merge({ a: 3, b: 2 }, { a: 2, c: 4 })); // { a: 3, b: 2, c: 4 }
console.log(merge({ a: 3, b: 2 }, { a: 2, c: 4 }, { e: 8, c: 5})); // { a: 3, b: 2, c: 4, e: 8 }

/**
 * invert
 */
// function invert () {
//   let objResult = {};
//   for (let i = 0; i < arguments.length; i++) {
//     if (typeof arguments[i] !== "object") throw "Argument is not an object";
//     for (key in arguments[i]){
//       objResult[arguments[i][key]] = key;
//     }
//   }
//   return objResult;
// }
//
//
// console.log(invert({ a: 3, b: 2 })); // { 3: 'a', 2: 'b' }
