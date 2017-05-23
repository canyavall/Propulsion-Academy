'use strict';

/**
 * Defines the paddle to be played
 * @param {[object]} context Canvas context
 */
var Paddle = function (position) {
  this.position = position;
  this.width = 10;
  this.height = 60;
  this.speed = 4;
  this.direction = 0;
}

/**
 * Render the paddle object
 * @param  {[object]} paddle [paddle object]
 */
function paddleRender (paddle, ctx) {
  ctx.fillStyle = 'white';
  ctx.fillRect(paddle.position[0], paddle.position[1], paddle.width, paddle.height);
};

/**
 * Move the paddle, the paddle must be moved only horizontal
 */
function paddleMove () {
  //We don't allow the paddle to go out from the board
  //But we move to the top or bottom depending on the key pressed
  if (this.directionTop == true) this.position[1] += -this.speed;
  if (this.directionBottom == true) this.position[1] += this.speed;
  if (this.direction == 0 ) this.position[1];
  if (this.position[1] < 0 ) this.position[1] = 0;
  if (this.position[1] > this.context.canvas.clientHeight - this.height ) this.position[1] = this.context.canvas.clientHeight - this.height;
};
