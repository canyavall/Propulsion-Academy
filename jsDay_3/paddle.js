'use strict';

/**
 * Defines the paddle to be played
 * @param {[type]} context [description]
 */
function Paddle (context) {
  this.context = context;
  this.position = [this.context.canvas.clientWidth/2, this.context.canvas.clientHeight-20];
  this.width = 50;
  this.heigth = 10;
  /**
   * Renders the paddle in the canvas
   * @return {[type]} [description]
   */
  this.render = function () {
    this.context.fillStyle = 'white';
    this.context.fillRect(this.position[0], this.position[1], this.width, this.heigth);
  };

  /**
   * Move the paddle, the paddle must be moved only horizontal
   * @return {[type]} [description]
   */
  this.move = function (direction) {
    //We use the position in order to know the direction of the ball
   if (this.position[0] >= 0 && this.position[0] + this.width <= this.context.canvas.clientWidth){
     if (direction === 37 && this.position[0] - 4 > 0){ //Left Arrow
       this.position[0] += -4;
     }else  {
       this.position[0]+= 4;
     }
   }
  }
}
