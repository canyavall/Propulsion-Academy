var Person = function() {
  this.alive = true;
  this.name = null;
}

Person.prototype.talk = function() {
  console.log('Talking!');
}

Person.prototype.setName = function (name) {
  this.name = name;
}
var bogdan = new Person('Bogdan');

bogdan.talk();

var Singer = function() {
  Person.call(this);
  this.artisticName = 'Fancy ' + this.name;
}

Singer.prototype = Object.create(Person.prototype);

Singer.prototype.sing = function() {
  console.log(this.artisticName + ' singing!');
}

var beck = new Singer();
beck.setName("Beck");
console.log(beck);
beck.sing();
