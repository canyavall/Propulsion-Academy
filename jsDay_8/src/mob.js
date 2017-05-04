export class Mob {
  constructor(ctx, random) {
    this.position = [0,0];
    this.ctx = ctx;
    this.radius = 10;
    this.speed = 1;
    //If true, the move is random
    this.random = random;
    // "up", "down", "left", "right" Direction to move
    this.direction = [false, false, false, false];//
    this.go = [true, true, true, true];

    //If random, we move it
    if (this.random) this.direction = [false,true, false, false];//
  }
  /**
   * Change the position of the Pacman depending on the direction
   */
  move(level){
    //prepare variables
    let xPositionPlusRadius = this.position[0] + this.radius;
    let xPositionMinusRadius = this.position[0] - this.radius;
    let yPositionPlusRadius = this.position[1] + this.radius;
    let yPositionMinusRadius = this.position[1] - this.radius;
    this.go = [true, true, true, true];

    //Check Collisions and move if random is activated
    this.boardCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius);
    this.wallCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius, level);
    if (this.random) this.randomMove();

    //Modify direction
    if (this.direction[0] && this.go[0]) this.position[1] -= this.speed;
    if (this.direction[1] && this.go[1]) this.position[1] += this.speed;
    if (this.direction[2] && this.go[2]) this.position[0] -= this.speed;
    if (this.direction[3] && this.go[3]) this.position[0] += this.speed;
  }
/**
 * [boardCollision description]
 * @param  {[integer]} xPositionPlusRadius  Radius plus x position
 * @param  {[integer]} xPositionMinusRadius Radius minus x position
 * @param  {[integer]} yPositionPlusRadius  Radius plus y position
 * @param  {[integer]} yPositionMinusRadius Radius minus y position
  */
  boardCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius){
    if (yPositionMinusRadius == 0) this.go[0] = false;
    if (yPositionPlusRadius == this.ctx.canvas.clientHeight) this.go[1] = false;
    if (xPositionMinusRadius == 0) this.go[2] = false;
    if (xPositionPlusRadius == this.ctx.canvas.clientWidth) this.go[3] = false;
  }

  wallCollision(xPositionPlusRadius, xPositionMinusRadius, yPositionPlusRadius, yPositionMinusRadius, level) {
    //let verticalWall = false;
      for (let i = 0; i < level.walls.length; i++) {
        let startX = level.walls[i].start[0],
            startY = level.walls[i].start[1],
            endX = level.walls[i].end[0],
            endY = level.walls[i].end[1],
            vWall = false;
      // if (startX === endX) vWall = true;
      // if (vWall) {
        if (yPositionMinusRadius === endY && xPositionMinusRadius <= endX && xPositionPlusRadius >= endX) this.go[0] = false;
        if (yPositionPlusRadius === startY && xPositionMinusRadius <= endX && xPositionPlusRadius >= endX) this.go[1] = false;
        if (startX === endX && xPositionMinusRadius === startX && yPositionPlusRadius >= startY && yPositionMinusRadius <= endY) this.go[2] = false;
      // }else{
        if (yPositionMinusRadius === endY && xPositionMinusRadius <= endX && xPositionPlusRadius >= startX) this.go[0] = false;
        if (startX != endX && yPositionPlusRadius === endY && xPositionMinusRadius <= endX && xPositionPlusRadius >= startX) this.go[1] = false;
        if (xPositionMinusRadius === endX && yPositionPlusRadius >= startY && yPositionMinusRadius <= endY) this.go[2] = false;
      // }
      if (xPositionPlusRadius === startX && yPositionPlusRadius >= startY && yPositionMinusRadius <= endY) this.go[3] = false;
    }
  }

  /**
   * If random  is true, then we move the mob randomly when he collides
   * @return {[type]} [description]
   */
  randomMove(){
    let possibleDirections = [];

    for (let i = 0; i < this.go.length; i++) {
      if (this.go[i]) possibleDirections.push(i);
    }
    if (possibleDirections.length < 4){
      this.direction = [false, false, false, false];
      let ii = Math.floor(Math.random() * possibleDirections.length);
      console.log(ii);
      this.direction[possibleDirections[ii]] = true;
    }
  }
}
