/**
 * Pepare the listeners
 */
function listeners (ball, paddleLeft, paddleRight) {
  document.addEventListener('keydown', function(event) {
    changePropertyEvent (ball, paddleLeft, paddleRight, event.keyCode, true)
  }.bind(this));

  document.addEventListener('keyup', function(event) {
    changePropertyEvent (ball, paddleLeft, paddleRight, event.keyCode, false)
  }.bind(this));
};


/**
 * Change objects properties depending on the event runed
 * @param  {[object]} ball        [description]
 * @param  {[object]} paddleLeft  [description]
 * @param  {[object]} paddleRight [description]
 * @param  {[integer]} keyCode     [description]
 * @param  {[boolean]} value       [description]
 * @return {[type]}             [description]
 */
function changePropertyEvent (ball, paddleLeft, paddleRight, keyCode, value){
  switch(keyCode) {
    case 87:
      paddleLeft.directionTop = value;
      break;
    case 83:
      paddleLeft.directionBottom = value;
      break;
    case 81:
      ball.changeLeftY = value;
      break;
    case 80:
      paddleRight.directionTop = value;
      break;
    case 76:
      paddleRight.directionBottom = value;
        break;
    case 186:
      ball.changeRightY = value;
        break;
  }
};

/**
 * Perpare the canvas to play
 * @param  {[Array]} position [Width/height]
 * @return {[Context]}          [Canvas context]
 */
function prepareDOM (position) {

  //create the canvas
  let canvas = document.createElement('canvas');
  canvas.id = "canvas";
  canvas.width = position[0];
  canvas.height = position[1];
  canvas.style = "border:1px solid #000000;";
  window.document.body.appendChild(canvas);
  return canvas.getContext('2d');
};

/**
 * Ask the user the players
 * @return {[array]} [Array of players]
 */
function createPlayers (ctx) {
  let players = [];

    //Get player names
  let firstPlayer = prompt ("Please, write the name of the first player. \n You'll play on the left with the keys 'W' and 'S' to move the paddle and 'Q' to change ball direction");
  let secondPlayer = prompt ("Please, write the name of the second player. \n You'll play on the right with the keys 'P' and 'L' and '`' to change ball direction");

  //Control player, if there's no name, the name will be Player1/Player2
  firstPlayer = (firstPlayer === '') ? "Player 1" : firstPlayer;
  secondPlayer = (secondPlayer === '') ? "Player 2" : secondPlayer;

  players.push(new Player(firstPlayer, [ctx.canvas.clientWidth / 2 - 100,30]));
  players.push(new Player(secondPlayer, [ctx.canvas.clientWidth / 2 + 50,30]));

  return players;
}

/**
 * Ask the players for the maximum score to play
 * @return {[integer]} [Maximum score to end the game]
 */
function askMaxScore () {
  let scoreMaximum = 1
  let scoreMaximumPrompt = parseInt(prompt ("Please, write the Maximum number of scores to win the game"));
  if (Number.isInteger(scoreMaximumPrompt) === true && scoreMaximumPrompt >= 0){
    scoreMaximum = scoreMaximumPrompt;
  }
  return scoreMaximum;
}

/**
 * [renderGame description]
 * @param  {[type]} canvasContext [description]
 * @param  {[type]} ball          [description]
 * @param  {[type]} paddleLeft    [description]
 * @param  {[type]} paddleRight   [description]
 * @param  {[type]} players       [description]
 * @return {[type]}               [description]
 */
function gameRender (ball, paddleLeft, paddleRight, players, ctx) {
  //Create initial board
  boardRender(ctx);

  //Render players
  for (let i = 0; i < players.length; i++) playerRender(players[i], ctx);

  //Create initial ball
  ballRender(ball, ctx);
  //Create initial paddle
  paddleRender(paddleLeft, ctx);
  paddleRender(paddleRight, ctx);

  //Move the ball
  return setInterval(function () {
    boardRender(ctx);
    var ballMoved = ballMove(ball, paddleLeft, paddleRight, ctx);
    ballRender(ballMoved, ctx);
    paddleRender(paddleLeft, ctx);
    paddleRender(paddleRight, ctx);
  }.bind(ctx, ball, paddleLeft, paddleRight, players), 100);
}
