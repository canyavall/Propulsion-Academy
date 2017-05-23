//////////////////////////////////////////////////////
var Pet = function (name){
  this.name = name;
}
Pet.prototype.yellName = function(){
  console.log(this.name.toUpperCase());
}
//////////////////////////////////////////////////////
var Mammal = function(name){
  Pet.call(this, name);
}
Mammal.prototype = Object.create(Pet.prototype);
Mammal.prototype.walk = function(){
  console.log(this.name, 'is going for a walk');
}
//////////////////////////////////////////////////////
var Dog = function(name, surname){
Mammal.call(this, name);
this.surname = surname;

}
Dog.prototype = Object.create(Mammal.prototype);
Dog.prototype.bark = function(){
  console.log(this.surname, ', woof woof!!!');
}
//////////////////////////////////////////////////////
var Cat = function(name, surname){
Mammal.call(this, name);
this.surname = surname;

}
Cat.prototype = Object.create(Mammal.prototype);
Cat.prototype.spoon = function(){
  console.log(this.surname, 'GET OUT');
}

var firstPet = new Pet('Buk');
firstPet.yellName(); // BUK!!!

var firstMammal = new Mammal('Fante');
firstMammal.yellName(); // FANTE!!!
firstMammal.walk(); // Fante is going for a walk

var doggy = new Dog('Hornby', 'Laurent');
doggy.yellName(); // HORNBY!!!
doggy.walk(); // Hornby is going for a walk
doggy.bark(); // Laurent, woof woof!!!

var markov = new Cat('Markov', 'Bogdan');
markov.yellName(); // MARKOV!!!
markov.walk(); // Markov is going for a walk
markov.spoon(); // Bogdan GET OUT!
