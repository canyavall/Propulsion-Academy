'use strict';

// function Game (widthCanvas, heightCanvas) {
//   //Create the canvas
//   var canvasDom = document.createElement('canvas');
//   canvasDom.id     = "canvas";
//   canvasDom.width  = widthCanvas;
//   canvasDom.height = heightCanvas;
//   window.document.body.appendChild(canvasDom);
//
//   //Get canvas
//   this.canvas = window.document.getElementById('canvas');
//   this.canvasContext = this.canvas.getContext('2d');
//   this.board = new Board(this.canvasContext);
//   this.ball = new Ball(5, [150,250], this.canvasContext);
//   this.paddle = new Paddle(this.canvasContext);
//   this.width = widthCanvas;
//   this.heigth = heightCanvas;
//   this.blocks = []
//
//
//
//   this.play = function () {
//     //Create initial board
//     this.board.render();
//     //Create initial ball
//     this.ball.render();
//     //Create initial paddle
//     this.paddle.render();
//     //Create wrapper
//     this.blockWrapper(30);
//     this.blocks.forEach(function (element) {
//       element.render();
//     });
//
//     //Move the ball
//     setInterval(this.resetCanvas.bind(this), 10);
//   };
//
//   /**
//    * Create a wrapper of blocks and save them in the array blocks
//    * @param  {[type]} num [description]
//    * @return {[type]}     [description]
//    */
//   this.blockWrapper = function (num) {
//     this.maxWrapperWidth = this.canvasContext.canvas.clientWidth - 30;
//     this.blockWidth = 40;
//     this.blockHeight = 15;
//     this.blockPosition = [0, 30];
//
//     for (let i = 0; i < num; i++) {
//       if (this.blockPosition[0] + this.blockWidth >= this.maxWrapperWidth){
//         this.blockPosition[0] = 30;
//         this.blockPosition[1] += this.blockHeight;
//       }else{
//         this.blockPosition[0] += 30;
//       }
//       //this.currentPosition[i]=this.blockPosition;
//       //Define a random color for the block
//       let r = 255*Math.random()|0,
//           g = 255*Math.random()|0,
//           b = 255*Math.random()|0;
//       let color = 'rgb(' + r + ',' + g + ',' + b + ')';
//       //Push in the array the blocks already created
//       this.blocks.push(new Block(this.blockPosition.slice(0), this.blockWidth, this.blockHeight, color, this.canvasContext));
//     }
//
//   };
//
//   /**
//    * Reset the canvas
//    * @return {[type]} [description]
//    */
//   this.resetCanvas = function () {
//     this.ball.move();
//     this.board.render (this.canvasContext);
//     this.paddle.render (this.canvasContext);
//     this.ball.render(this.canvasContext);
//     this.blocks.forEach(function (element) {
//       element.render();
//     });
//   };
//
// }
//
// /**
//  * Object Board
//  * @type {Object}
//  */
// function Board (context) {
//   this.context = context;
//   this.render = function () {
//     this.context.fillStyle = 'black';
//     this.context.fillRect(0, 0, this.context.canvas.clientWidth, this.context.canvas.clientHeight);
//   }
// }
//
//
// /**
//  * We create the object ball
//  * @type {Object}
//  */
// function Ball (radius, position, context) {
//   this.radius = radius;
//   this.position = position;
//   this.context = context;
//   /**
//    * If true, we will change the direction positively
//    * if false, we will change the directio negatively
//    */
//   this.direction = [1,1];
//
//
//   //Check the position values are an array, to avoid confusion
//   if (position.constructor !== Array || position.length != 2){
//     console.log('Declaring the ball, position must be an array');
//   }
//   /**
//    * Render the ball
//    * @param  {[type]} context [description]
//    * @return {[type]}         [description]
//    */
//   this.render = function () {
//     this.context.beginPath();
//     this.context.arc(this.position[0], this.position[1], this.radius, 0,2*Math.PI);
//     this.context.fillStyle = '#fff';
//     this.context.fill();
//   }
//   /**
//    * Move the ball in the board
//    * @return {[type]} [description]
//    */
//   this.move = function () {
//     /**
//      * We use the position in order to know the direction of the ball
//      */
//     if (this.position[0] - this.radius === 0) this.direction[0] = 1;
//     if (this.position[0] + this.radius === this.context.canvas.clientWidth) this.direction[0] = -1;
//     if (this.position[1] - this.radius === 0) this.direction[1] = 1;
//     if (this.position[1] + this.radius === this.context.canvas.clientHeight) this.direction[1] = -1;
//
//     this.position[0] = this.position[0] + this.direction[0];
//     this.position[1] = this.position[1] + this.direction[1];
//
//   };
// }
// /**
//  * Create the blocks
//  * @return {[type]} [description]
//  */
// function Block (position, width, heigth, color, context) {
//   this.position = position;
//   this.heigth = heigth;
//   this.width = width;
//   this.color = color;
//   this.context = context;
//   /**
//    * Render the block
//    * @return {[type]} [description]
//    */
//   this.render = function () {
//     this.context.fillStyle = this.color;
//     this.context.fillRect(this.position[0], this.position[1], this.width, this.heigth);
//   };
// }
//
// function Paddle (context) {
//   this.context = context;
//   this.render = function () {
//     this.context.fillStyle = 'white';
//     this.context.fillRect(this.context.canvas.clientWidth/2, this.context.canvas.clientHeight-20, 50, 10);
//   }
// }

var game = new Game (400, 500);
game.play();
