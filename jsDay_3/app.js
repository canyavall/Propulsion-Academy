'use strict';

function Game () {
  this.canvasField = window.document.getElementById('mainField');
  this.fieldContext = this.canvasField.getContext('2d');
  this.canvasBall = window.document.getElementById('mainField');
  this.ballContext = this.canvasBall.getContext('2d');
  this.field = new Field();
  this.ball = new Ball(5, [30,30]);

  this.play = function () {
    //Create field
    this.field.render (this.fieldContext);
    //Create ball
    this.ball.render (this.ballContext);

    //Move the ball
    setInterval(this.resetCanvas.bind(this), 10);
  };

  /**
   * Reset the canvas
   * @return {[type]} [description]
   */
  this.resetCanvas = function () {
    this.ball.move();
    this.field.render (this.fieldContext);
    this.ball.render(this.ballContext);
  };

}

/**
 * Object Field
 * @type {Object}
 */
function Field () {
  this.render = function (context) {
    context.fillStyle = 'black';
    context.fillRect(10, 10, 400, 400);
  }
}


/**
 * We create the object ball
 * @type {Object}
 */
function Ball (radius, initial) {
  this.radius = radius;
  this.initial = initial;
  //Check the initial values are an array, to avoid confusion
  if (initial.constructor !== Array || initial.length != 2){
    console.log('Declaring the ball, initial must be an array');
  }
  /**
   * Render the ball
   * @param  {[type]} context [description]
   * @return {[type]}         [description]
   */
  this.render = function (context) {
    context.beginPath();
    context.arc(this.initial[0], this.initial[1], this.radius, 0,2*Math.PI);
    context.fillStyle = '#fff';
    context.fill();
  }

  this.move = function () {
    this.initial[0]++;
    this.initial[1]++;
  }
}

var game = new Game ();
game.play();
