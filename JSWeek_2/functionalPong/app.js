'use strict';

//Prepare canvas
var canvasPosition = [600, 400]; //Width, height
var canvasContext = prepareDOM(canvasPosition);

//Set paddle and ball
var ball = new Ball(5, [100,350]);
var paddleLeft = new Paddle([30, canvasPosition[1] /2]);
var paddleRight = new Paddle([canvasPosition[0] - 30, canvasPosition[1] /2]);

//Render objects
ballRender(ball, canvasContext);
paddleRender (paddleLeft, canvasContext);
paddleRender (paddleRight, canvasContext);

//Set game properties
var players = createPlayers(canvasContext);
var maxScore = askMaxScore();


//listeners
listeners (ball, paddleLeft, paddleRight);

//
gameRender(ball, paddleLeft, paddleRight, players, canvasContext);
