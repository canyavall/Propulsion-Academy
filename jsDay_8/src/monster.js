import {Mob} from './mob.js';
export class Monster extends Mob{
  constructor(ctx) {
    super(ctx);
    this.position = [100,300];
  }
  render(){
    this.ctx.fillStyle = 'pink';
    this.ctx.fillRect(this.position[0], this.position[1], 20, 15);
    this.ctx.beginPath();
    this.ctx.arc(this.position[0]+10, this.position[1], 10, 1 * Math.PI, 0 * Math.PI, false);
    // this.ctx.fillStyle = "pink";
    this.ctx.fill();
  }
}
