'use strict';

/**
 * We create the object ball
 * @type {Object}
 */
function Ball (radius, position, context) {
  this.radius = radius;
  this.position = position;
  this.context = context;
  //Direction defines if we need to increment or decrement the move
  this.direction = [1,1];

  //Check the position values are an array, to avoid confusion
  if (position.constructor !== Array || position.length != 2){
    console.log('Declaring the ball, position must be an array');
  }

  /**
   * Renders the ball in the canvas
   * @param  {[type]} context [description]
   * @return {[type]}         [description]
   */
  this.render = function () {
    this.context.beginPath();
    this.context.arc(this.position[0], this.position[1], this.radius, 0,2*Math.PI);
    this.context.fillStyle = '#fff';
    this.context.fill();
  };

  /**
   * Move the ball in the board
   * @return {[type]} [description]
   */
  this.move = function () {

     //We use the position in order to know the direction of the ball
    if (this.position[0] - this.radius === 0) this.direction[0] = 1;
    if (this.position[0] + this.radius === this.context.canvas.clientWidth) this.direction[0] = -1;
    if (this.position[1] - this.radius === 0) this.direction[1] = 1;
    if (this.position[1] + this.radius === this.context.canvas.clientHeight) this.direction[1] = -1;

    //Move the ball
    this.position[0] += this.direction[0];
    this.position[1] += this.direction[1];
  };
}
