'use strict';

/**
 * Main function to play the game
 * @param {[type]} widthCanvas  [description]
 * @param {[type]} heightCanvas [description]
 */
function Game (widthCanvas, heightCanvas) {
  //Create the DOM
  // let wrapper = document.createElement("div");
  // wrapper.id = "wrapper"
  // window.document.body.appendChild(wrapper);

  let menu = document.createElement("div");
  menu.id = "menu"
  menu.style.width = widthCanvas/2 + "px";
  menu.style.height = heightCanvas + "px";
  menu.style.background = "pink";
  menu.style.border = "1px solid black";
  menu.innerHTML = "Hello";
    window.document.body.appendChild(menu)
  // window.document.getElementById('wrapper').appendChild(menu)

  this.canvas = document.createElement('canvas');
  this.canvas.id     = "canvas";
  this.canvas.width  = widthCanvas;
  this.canvas.height = heightCanvas;
  window.document.body.appendChild(this.canvas);
  // window.document.getElementById('wrapper').appendChild(this.canvas)

  //Get canvas
  this.canvasContext = this.canvas.getContext('2d');

  //Prepare parameters
  this.board = new Board(this.canvasContext);
  this.ball = new Ball(5, [100,350], this.canvasContext);
  this.paddle = new Paddle(this.canvasContext);
  this.width = widthCanvas;
  this.height = heightCanvas;
  this.blocks = [];
  this.blockNum = 23;

  // Stop the game
  this.intervalId = 0;

  //Control the events
  document.addEventListener('keydown', function(event) {
    if (event.keyCode == 37) {
      this.paddle.directionLeft = true;
    }else if (event.keyCode == 39){
      this.paddle.directionRight = true;
    }
  }.bind(this));

  document.addEventListener('keyup', function(event) {
    if (event.keyCode == 37) {
      this.paddle.directionLeft = false;
    }else if (event.keyCode == 39){
      this.paddle.directionRight = false;
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
    this.blockWrapper(this.blockNum);
    this.blocks.forEach(function (element) {
      element.render();
    });

    //Move the ball
    this.intervalId = setInterval(this.resetCanvas.bind(this), 10);
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
    this.hBorder = 5;
    this.vBorder = 5;

    for (let i = 0; i <= num; i++) {
      if (this.blockPosition[0] + this.blockWidth >= this.maxWrapperWidth){
        this.blockPosition[0] = 30;
        this.blockPosition[1] += this.blockHeight + this.hBorder;
      }else if (i == 0){
        this.blockPosition[0] = 30;
      }else{
        this.blockPosition[0] += this.blockWidth + this.vBorder;
      }

      //Push in the array the blocks already created
      this.blocks.push(new Block(this.blockPosition.slice(0), this.blockWidth, this.blockHeight, this.canvasContext));
    }
  };

  /**
   * Reset the canvas
   * @return {[type]} [description]
   */
  this.resetCanvas = function () {
    // Game Over!
    if (this.ball.position[1] + this.ball.radius === this.canvasContext.canvas.clientHeight){
      this.gameOver();
    }

    // Render all
    this.ball.move(this.paddle, this.blocks);
    this.paddle.move();
    this.board.render (this.canvasContext);
    this.paddle.render (this.canvasContext);
    this.ball.render(this.canvasContext);
    this.blocks.forEach(function (element) {
      element.render();
    });
  };

  this.gameOver = function () {
    window.clearInterval(this.intervalId);
    if (confirm("GAME OVER! \n Do you want to play again?")){

    }
  }
}
