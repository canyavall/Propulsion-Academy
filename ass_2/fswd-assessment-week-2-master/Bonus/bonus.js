/**
 * First ES6 conversion bonus question
 */
// var obj = {b: 3, routes: 2, a: 10};
// var res = ({ routes }) => ({ routes });
// console.log(res(obj));
//
//
// var res2 = function (obj) {
//   let objReturn = {};
//   objReturn['routes'] = obj.routes;
//   return objReturn;
//  }
//  console.log(res2(obj));

/**
 * Twitter Es6
 */
var fn = function (el) {
return el*2;
}
 const composeMixins = (...fns) => (
   obj = {a:2},
   piped = x => fns.reduce((o, fn) => fn(o), x)
 ) => piped(obj);
 var first = composeMixins(2,fn);

  var second = first([2])

// console.log(first());

// const pep = function (...fns){
// var obj = {a:2};
// var piped = function x (fns.reduce(function (o, fn) {fn(o), x})) {
//   return(piped(obj));
// }
// console.log(obj);
// console.log(piped);
// }
// pep([2,4,6]);


/**
 * MyUnion
 */
// function myUnion (){
//   var args = [].slice.call(arguments);
//   let finalArray = [];
//   for (let i = 0; i < args.length; i++) {
//     if (Array.isArray(args[i]) !== true ) return; //not an array, return undefined
//     for (let u = 0; u < args[i].length; u++) {
//       if (finalArray.indexOf(args[i][u]) === -1) finalArray.push(args[i][u]);
//     }
//   }
//   return finalArray;
// }

//module.exports = {myUnion}
