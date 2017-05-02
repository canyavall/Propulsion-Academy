// function myBind(fn, obj){
//       var arg3 = arguments[2];
//   return function (){
//       //console.log(arg3);
//       var args = Array.prototype.slice.call(arguments);
//       args.push(arg3);
//       console.log(args);
//     fn.apply(obj, args)
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
//

var curryCalc = createCurryCalc();
var partial = curryCalc(2, 3, 4);
console.log(partial(1, 3));

var curryCalc2 = createCurryCalc();
var partial2 = curryCalc2(2);
partial2 = partial2(4, 5)
console.log(partial2(1, 3));
