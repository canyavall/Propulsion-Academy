export class Pacman {
  constructor(ctx) {
    this.radius = 10;
    this.position = [100, 100];
    this.ctx = ctx;
    this.speed = 2;
    // "up", "down", "left", "right" Direction to move
    this.direction = [false, false, false, false];//

  };
  /**
   * Render the pacman in the screen depending on the position of the object
   * @return {[type]} [description]
   */
  render(){
    //Change mouth position
    let arc1Start = 0.25 * Math.PI,
        arc1End = 1.25 * Math.PI,
        arc2Start = 0.75 * Math.PI,
        arc2End = 1.75 * Math.PI;
    if (this.direction[0] === true){
      arc2Start = 1.75 * Math.PI;
      arc2End = 0.75 * Math.PI;
    }
    if (this.direction[1] === true){
      arc1Start = 0.75 * Math.PI;
      arc1End = 1.75 * Math.PI;
      arc2Start = 1.25 * Math.PI;
      arc2End = 0.25 * Math.PI;
    }
    if (this.direction[2] === true){
      arc1Start = 1.25 * Math.PI;
      arc1End = 0.25 * Math.PI;
      arc2Start = 1.75 * Math.PI;
      arc2End = 0.75 * Math.PI;
    }
    this.ctx.beginPath();
    this.ctx.arc(this.position[0], this.position[1], this.radius, arc1Start, arc1End, false);
    this.ctx.fillStyle = "rgb(255, 255, 0)";
    this.ctx.fill();
    this.ctx.beginPath();
    this.ctx.arc(this.position[0], this.position[1], this.radius, arc2Start, arc2End, false);
    this.ctx.fill();
  };

  /**
   * Change the position of the Pacman depending on the direction
   */
  move(){
    let xPositionPlusRadius = this.position[0] + this.radius;
    let xPositionMinusRadius = this.position[0] - this.radius;
    let yPositionPlusRadius = this.position[1] + this.radius;
    let yPositionMinusRadius = this.position[1] - this.radius;
    this.boardCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius);

    if (this.direction[0] === true) this.position[1] -= this.speed;
    if (this.direction[1] === true) this.position[1] += this.speed;
    if (this.direction[2] === true) this.position[0] -= this.speed;
    if (this.direction[3] === true) this.position[0] += this.speed;
  }
/**
 * [boardCollision description]
 * @param  {[integer]} xPositionPlusRadius  Radius plus x position
 * @param  {[integer]} xPositionMinusRadius Radius minus x position
 * @param  {[integer]} yPositionPlusRadius  Radius plus y position
 * @param  {[integer]} yPositionMinusRadius Radius minus y position
  */
  boardCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius){
    if (xPositionMinusRadius == 0) this.direction[2] = false;
    if (xPositionPlusRadius == this.ctx.canvas.clientWidth) this.direction[3] = false;
    if (yPositionMinusRadius == 0) this.direction[0] = false;
    if (yPositionPlusRadius == this.ctx.canvas.clientHeight) this.direction[1] = false;
  }

}
