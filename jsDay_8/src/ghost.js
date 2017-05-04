import {Mob} from './mob.js';
export class Ghost extends Mob{
  constructor(ctx, random) {
    super(ctx, random);
    this.position = [100,300];
  }
  render(){
    this.ctx.fillStyle = 'pink';
    this.ctx.fillRect(this.position[0], this.position[1], 20, 10);
    this.ctx.beginPath();
    this.ctx.arc(this.position[0]+10, this.position[1], this.radius, 1 * Math.PI, 0 * Math.PI, false);
    this.ctx.fillStyle = "pink";
    this.ctx.fill();
    this.ctx.beginPath();
    this.ctx.arc(this.position[0]+6, this.position[1], 2, 0 * Math.PI, 1.75 * Math.PI, false);
    this.ctx.fillStyle = "black";
    this.ctx.fill();
    this.ctx.beginPath();
    this.ctx.arc(this.position[0]+14, this.position[1], 2, 0 * Math.PI, 1.75 * Math.PI, false);
    this.ctx.fillStyle = "black";
    this.ctx.fill();
  }
}
