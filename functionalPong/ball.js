'use strict';

/**
 * We create the object ball
 * @type {Object}
 */
var Ball = function (radius, position) {
  this.radius = radius;
  this.position = position;
  this.speed = 0.1;
  this.changeRightY = false;
  this.changeLeftY = false;
  //Direction defines if we need to increment or decrement the move
  this.direction = [2,2];
}
/**
 * Renders the ball in the canvas
 */
function ballRender(ball, ctx) {
  ctx.beginPath();
  ctx.fillStyle = 'white';
  ctx.fill();
  ctx.arc(ball.position[0], ball.position[1], ball.radius, 0,2*Math.PI);
  ctx.stroke();
};

/**
 * Move the ball and checks the collision with the paddles
 * @param  {[object]} paddleLeft  Left paddle
 * @param  {[object]} paddleRight Right paddle
 */
function ballMove (ball, paddleLeft, paddleRight, ctx) {

  let xPositionRadius = ball.position[0] + ball.radius * ball.direction[0];
  let yPositionRadius = ball.position[1] + ball.radius * ball.direction[1];
  //ballBoardCollision(xPositionRadius, yPositionRadius, ball, ctx);
  //ballPaddleColission(paddleLeft, paddleRight, xPositionRadius, yPositionRadius, ball);


  //Move the ball
  let newPosition = [ball.position[0] += ball.direction[0], ball.position[1] += ball.direction[1]];
  return new Ball(ball.radius, newPosition);
};

function ballBoardCollision (xPositionRadius, yPositionRadius, ball, ctx){

  if (yPositionRadius <= 0){
    ball.direction[1] *= -1
    ball.position[1] = 0 + ball.radius;
  };
  if (yPositionRadius >= ctx.canvas.clientHeight){
    ball.direction[1] *= -1
    ball.position[1] = ctx.canvas.clientHeight - ball.radius;
  };
  if (xPositionRadius <= 0){
    ball.direction[0] *= -1;
    ball.position[0] = 0 + ball.radius;
    ball.players[1].score++;
    ball.players[1].strikeCounter++;
    ball.players[0].strikeCounter--;
    ball.players[1].scoreTime = new Date().getTime();
  };
  if (xPositionRadius >= ball.context.canvas.clientWidth){
    ball.direction[0] *= -1
    ball.position[0] = ball.context.canvas.clientWidth - ball.radius;
    ball.players[0].score++;
    ball.players[1].strikeCounter--;
    ball.players[0].strikeCounter++;
    ball.players[0].scoreTime = new Date().getTime();
  }
}

/**
 * [description]
 * @param  {[object]} paddleLeft  Left paddle object
 * @param  {[object]} paddleRight Right paddle object
 */
 function ballPaddleColission(paddleLeft, paddleRight, xPositionRadius, yPositionRadius) {
   //Check the paddleLeft position for the collision
   if (this.position[0]-this.radius <= paddleLeft.position[0] + paddleLeft.width &&
       this.position[1] >= paddleLeft.position[1] &&
       this.position[1] <= paddleLeft.position[1] + paddleLeft.height &&
       this.direction[0] < 0
     ){
       this.position[0] = paddleLeft.position[0] + paddleLeft.width + this.radius;
       this.direction[0] *= (this.direction[0] > -5) ? (-1 - this.speed) : -1;
       if (this.changeLeftY === true) this.direction[1] *= -1;
   }

  //Check the paddleRight position for the collision
  if (this.position[0] + this.radius >= paddleRight.position[0] &&
      this.position[1] >= paddleRight.position[1] &&
      this.position[1] <= paddleRight.position[1] + paddleRight.height &&
      this.direction[0] > 0
    ){
      this.position[0] = paddleRight.position[0] - this.radius;
      this.direction[0] *= (this.direction[0] < 5) ? (-1 - this.speed) : -1;
      if (this.changeRightY === true) this.direction[1] *= -1;
  }
}
