import {Mob} from './mob.js';
export class Pacman extends Mob {
  constructor(ctx) {
    super(ctx);
    this.position = [100,100];
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


}
