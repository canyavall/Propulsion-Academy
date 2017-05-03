'use strict';
/**
 * Renders the Board in the canvas
 */
function boardRender (context) {
  //draw the board
  context.fillStyle = 'black';
  context.fillRect(0, 0, context.canvas.clientWidth, context.canvas.clientHeight);

  //draw the line
  context.beginPath();
  context.moveTo(context.canvas.clientWidth/2, 0);
  context.lineTo(context.canvas.clientWidth/2, context.canvas.clientHeight);
  context.strokeStyle = 'white';
  context.stroke();
}
