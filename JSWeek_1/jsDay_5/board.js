'use strict';
var app = {}
/**
 * Object Board
 * @param {[object]} context Canvas context
 */
app.Board = function (context) {
  this.context = context;
}

/**
 * Renders the Board in the canvas
 */
app.Board.prototype.render = function () {
  //draw the board
  this.context.fillStyle = 'black';
  this.context.fillRect(0, 0, this.context.canvas.clientWidth, this.context.canvas.clientHeight);

  //draw the line
  this.context.beginPath();
  this.context.moveTo(this.context.canvas.clientWidth/2, 0);
  this.context.lineTo(this.context.canvas.clientWidth/2, this.context.canvas.clientHeight);
  this.context.strokeStyle = 'white';
  this.context.stroke();
}
