'use strict';

/**
 * Player attributes
 * @param  {[string]} name name of the player
 */
var Player = function (name, position) {
  this.position = position;
  this.name = name;
  this.score = 0;
  this.scoreTime = 0
  this.strikeCounter = 0;
}

function playerRender (player, ctx){
  //let textToShow = this.name + ": " + this.score;
  ctx.font = "20px Calibri";
  ctx.fillStyle = "white";
  ctx.fillText(player.name,player.position[0],player.position[1]);
}

function scoreMsg (ctx) {
  this.context.font = "20px Calibri";
  this.context.textAlign="center";
  this.context.fillStyle = "pink";
  this.context.fillText("Gotcha!",ctx.canvas.clientWidth/2,75);
}

function strikeMsg (msg, ctx) {
  this.context.font = "20px Calibri";
  this.context.textAlign="center";
  this.context.fillStyle = "red";
  this.context.fillText(msg,ctx.canvas.clientWidth/2,150);
}

function winMsg (ctx) {
  this.context.font = "50px Calibri";
  this.context.fillStyle = "green";
  this.context.textAlign="center";
  let msg = this.name + " WINS!";
  this.context.fillText(msg,ctx.canvas.clientWidth/2,ctx.canvas.clientHeight/2);
}
