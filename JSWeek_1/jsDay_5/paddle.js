'use strict';

/**
 * Defines the paddle to be played
 * @param {[object]} context Canvas context
 */
app.Paddle = function (position, context) {
  this.context = context;
  this.position = position;
  this.width = 10;
  this.height = 60;
  this.speed = 4;
  this.direction = 0;
}

/**
 * Renders the paddle in the canvas
 */
app.Paddle.prototype.render = function () {
  this.context.fillStyle = 'white';
  this.context.fillRect(this.position[0], this.position[1], this.width, this.height);
};

/**
 * Move the paddle, the paddle must be moved only horizontal
 */
app.Paddle.prototype.move = function () {

  //We don't allow the paddle to go out from the board
  //But we move to the top or bottom depending on the key pressed
  if (this.directionTop == true) this.position[1] += -this.speed;
  if (this.directionBottom == true) this.position[1] += this.speed;
  if (this.direction == 0 ) this.position[1];
  if (this.position[1] < 0 ) this.position[1] = 0;
  if (this.position[1] > this.context.canvas.clientHeight - this.height ) this.position[1] = this.context.canvas.clientHeight - this.height;
};
