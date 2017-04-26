'use strict';

/**
 * Object Board
 * @type {Object}
 */
function Board (context) {
  this.context = context;

  /**
   * Renders the Board in the canvas
   * @return {[type]} [description]
   */
  this.render = function () {
    this.context.fillStyle = 'black';
    this.context.fillRect(0, 0, this.context.canvas.clientWidth, this.context.canvas.clientHeight);
  }
}
