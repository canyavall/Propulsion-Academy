/**
 * Person constructor
 */
var Person = function (firstName, lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.isAlive = true;

}

Person.prototype.greet = function () {
  console.log("Hello, this is ", this.firstName, this.lastName);
}

/**
 * Writer construction
 */
var Writer = function(firstName, lastName) {
  Person.call(this,firstName, lastName);
  this.pseudonym = lastName + " " + firstName;
}

Writer.prototype = Object.create(Person.prototype);
Writer.prototype.signBook = function(){
  console.log("Book signed by", this.pseudonym);
}

/**
 * Developer construction
 */
var Developer = function(firstName, lastName, codename) {
  Person.call(this,firstName, lastName);
  this.codename = codename;
}

Developer.prototype = Object.create(Person.prototype);
Developer.prototype.impress = function(){
  for (var i = 0; i < 5; i++) console.log("00111101010101010101010101010");
  console.log(this.codename);
}


/**
 * Singer construction
 */
var Singer = function(firstName, lastName, melody) {
  Person.call(this,firstName, lastName);
  this.artisticName = 'Fancy ' + firstName + " " + lastName;
  this.melody = melody;

}

Singer.prototype = Object.create(Person.prototype);
Singer.prototype.sing = function () {
  console.log(this.artisticName, "sings");
  for (var i = 0; i < 5; i++) console.log(this.melody);
}

/**
 * Junior developer
 */
var JuniorDev = function(firstName, lastName, codename){
  Developer.call(this,firstName, lastName, codename);
  this.isStruggling = true;
  this.complain = codename.toUpperCase();
}

JuniorDev.prototype = Object.create(Developer.prototype);

JuniorDev.prototype.workHard = function (){
    for (var i = 0; i < 5; i++) console.log(this.complain + " is working hard");
}

// var person1 = new Person ("Pepe", "Palotes");
// person1.greet();
// var writer1 = new Writer ("Monica", "Cantones");
// writer1.signBook();
// var developer1 = new Developer("Capitan", "America", "Pong Game");
// developer1.impress();
// var singer1 = new Singer ("Mariano", "Mirando", "tararararairirairiai");
// singer1.sing();
// console.log(singer1);
var junior1 = new JuniorDev("Pepe", "Palotes", "Pong Game");
junior1.workHard();
console.log(junior1);
