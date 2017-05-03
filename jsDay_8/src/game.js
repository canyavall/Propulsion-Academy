import {Board} from './board.js';
import {Pacman} from './pacman.js';

export class Game {
  constructor() {
    this.ctx = null;
    this.width = 300;
    this.height = 400;
    
    this.prepareDOM();
    this.board = new Board(this.ctx);
  }
  play(){

  }
  prepareDOM () {

    //create the canvas
    let canvas = document.createElement('canvas');
    canvas.id     = "canvas";
    canvas.width  = this.width;
    canvas.height = this.height;
    canvas.style = "border:1px solid #000000;";
    window.document.body.appendChild(canvas);

    //Get canvas
    this.ctx = canvas.getContext('2d');
  };
}
