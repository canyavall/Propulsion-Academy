'use strict';

/**
 * [Block description]
 * @param {[array]} position x,y position of the block
 * @param {[int]} width    width of the block
 * @param {[int]} height   height of the block
 * @param {[object]} context  [description]
 */
function Block (position, width, height, context) {
  this.position = position;
  this.width = width;
  this.height = height;
  this.context = context;
  this.colorsArray = ["red", "white", "blue", "yellow", "pink", "green", "orange"];

   //this.currentPosition[i]=this.blockPosition;
  //Define a random color for the block
  this.color = this.colorsArray[Math.floor(Math.random() * this.colorsArray.length)];

  /**
   * Renders the block in the canvas
   */
  this.render = function () {
    
    this.context.beginPath();
    // Set faux rounded corners
    this.context.lineJoin = "round";
    this.context.lineWidth = this.cornerRadius;
    this.context.fillStyle = this.color;

    // Change origin and dimensions to match true size (a stroke makes the shape a bit larger)
    this.context.fillRect(this.position[0], this.position[1], this.width, this.height);
  };

}
