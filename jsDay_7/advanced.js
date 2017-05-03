/**
 * MyBind function
 */

// function myBind(fn, obj){
//       var mainArgs = [].slice.call(arguments,2);
//   return function (){
//       var args = [].slice.call(arguments);
//       var finalArgs = mainArgs.concat(args);
//     fn.apply(obj, finalArgs)
//   };
// }
//
// var obj = {
//   name: 'Markov'
// }
//
// function printName() {
//   console.log('Thy name is: ' + this.name);
// }
//
// function greetingsTo(name) {
//   console.log('Hello ' + name + ', my name is: ' + this.name);
// }
//
// function greetingsToAll(name, name2) {
//   console.log('Hello ' + name + ' and ' + name2 + ', my name is: ' + this.name);
// }
//
// printName();
// var boundPrint = myBind(printName, obj);
// boundPrint();
//
// greetingsTo('Fante');
// var boundGreeting = myBind(greetingsTo, obj);
// boundGreeting('Fante');
//
//
// greetingsToAll('Fante', 'Hornby');
// var boundToAll = myBind(greetingsToAll, obj);
// boundToAll('Fante', 'Hornby');
//
// var boundAndFirst = myBind(greetingsToAll, obj, 'Monti');
// boundAndFirst('Hornby');

/**
 * Currying Calculator
 */
// function createCurryCalc () {
//   var mainArgs = [].slice.call(arguments);
//     return function(){
//       var args = [].slice.call(arguments);
//       var totalArgs = args.concat(mainArgs);
//       if (totalArgs.length >= 5){
//         return totalArgs.reduce(function (a,b){return a*b});
//       }
//       return createCurryCalc.apply(this, totalArgs);
//
//     };
// };
// var curryCalc = createCurryCalc();
// var partial = curryCalc(2, 3, 4);
// console.log(partial(1, 3));
//
// var curryCalc2 = createCurryCalc();
// var partial2 = curryCalc2(2);
// partial2 = partial2(4, 5)
// console.log(partial2(1, 3));

/**
 * Curry function
 */

 // function curry () {
 //   var mainArgs = [].slice.call(arguments);
 //     return function(){
 //       var args = [].slice.call(arguments);
 //       var totalArgs = args.concat(mainArgs);
 //       return curry.apply(this, totalArgs);
 //     };
 // };

/**
 * Mynew
 */
 // function Person(name) {
 //   this.name = name;
 // }
 //
 // function myNew(ConstrucorFn) {
 //   var obj = Object.create(ConstrucorFn.prototype);
 //   var args = [].slice.call(arguments, 1);
 //   ConstrucorFn.apply(obj, args);
 //   return obj;
 // }
 //
 // var manel = myNew(Person, 'Manel');
 // console.log(manel);
