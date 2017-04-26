'use strict';

/**
 * Main function to play the game
 * @param {[type]} widthCanvas  [description]
 * @param {[type]} heightCanvas [description]
 */
function Game (widthCanvas, heightCanvas) {
  //Create the canvas
  var canvasDom = document.createElement('canvas');
  canvasDom.id     = "canvas";
  canvasDom.width  = widthCanvas;
  canvasDom.height = heightCanvas;
  window.document.body.appendChild(canvasDom);

  //Get canvas
  this.canvas = window.document.getElementById('canvas');
  this.canvasContext = this.canvas.getContext('2d');

  //Prepare parameters
  this.board = new Board(this.canvasContext);
  this.ball = new Ball(5, [150,250], this.canvasContext);
  this.paddle = new Paddle(this.canvasContext);
  this.width = widthCanvas;
  this.heigth = heightCanvas;
  this.blocks = [];

  //Control the events
  document.addEventListener('keydown', function(event) {
    //console.log(this);
    if (event.keyCode == 37) {
      this.paddle.move(37);
      this.paddle.render();
    }else if (event.keyCode == 39){
      this.paddle.move(39);
      this.paddle.render();
    }


  }.bind(this));

/**
 * Method to initiate the game
 * @return {[type]} [description]
 */
  this.play = function () {
    //Create initial board
    this.board.render();
    //Create initial ball
    this.ball.render();
    //Create initial paddle
    this.paddle.render();
    //Create wrapper
    this.blockWrapper(30);
    this.blocks.forEach(function (element) {
      element.render();
    });

    //Move the ball
    setInterval(this.resetCanvas.bind(this), 10);
  };

  /**
   * Create a wrapper of blocks and save them in the array blocks
   * @param  {[type]} num [description]
   * @return {[type]}     [description]
   */
  this.blockWrapper = function (num) {
    this.maxWrapperWidth = this.canvasContext.canvas.clientWidth - 30;
    this.blockWidth = 40;
    this.blockHeight = 15;
    this.blockPosition = [0, 30];

    for (let i = 0; i < num; i++) {
      if (this.blockPosition[0] + this.blockWidth >= this.maxWrapperWidth){
        this.blockPosition[0] = 30;
        this.blockPosition[1] += this.blockHeight;
      }else{
        this.blockPosition[0] += 30;
      }
      //this.currentPosition[i]=this.blockPosition;
      //Define a random color for the block
      let r = 255*Math.random()|0,
          g = 255*Math.random()|0,
          b = 255*Math.random()|0;
      let color = 'rgb(' + r + ',' + g + ',' + b + ')';
      //Push in the array the blocks already created
      this.blocks.push(new Block(this.blockPosition.slice(0), this.blockWidth, this.blockHeight, color, this.canvasContext));
    }

  };

  /**
   * Reset the canvas
   * @return {[type]} [description]
   */
  this.resetCanvas = function () {
    this.ball.move();
    this.board.render (this.canvasContext);
    this.paddle.render (this.canvasContext);
    this.ball.render(this.canvasContext);
    this.blocks.forEach(function (element) {
      element.render();
    });
  };

}
