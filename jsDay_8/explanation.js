console.log("hello world");

//new function
var func = (name) => {
  console.log(name);
}
func("pep");

//New class
class Person {
  constructor(name) {
    this.name = name;
  }
  talk(){
    console.log("complain all day");
  }
}

var per = new Person("Joan");
per.talk();

//Inheritance
class Dancer extends Person{
  constructor(name, surname){
    super(name);
    this.surname = surname;
  }
  full(){
    console.log(this.name, this.surname);
  }
}
var testingObj = function () {

}
testingObj.prototype.po = function () {
  console.log("po");
}
var per2 = new Dancer("Joan", "Mandril");

per2.talk();
per2.full();
var test = new testingObj();
console.log(per2);
console.log(test);
