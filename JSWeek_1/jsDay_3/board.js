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
  this.context.fillStyle = 'black';
  this.context.fillRect(0, 0, this.context.canvas.clientWidth, this.context.canvas.clientHeight);
}
