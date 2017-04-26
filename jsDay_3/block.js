'use strict';

/**
 * Create the blocks
 * @return {[type]} [description]
 */
function Block (position, width, heigth, color, context) {
  this.position = position;
  this.heigth = heigth;
  this.width = width;
  this.color = color;
  this.context = context;

  /**
   * Renders the block in the canvas
   * @return {[type]} [description]
   */
  this.render = function () {
    this.context.fillStyle = this.color;
    this.context.fillRect(this.position[0], this.position[1], this.width, this.heigth);
  };
}
