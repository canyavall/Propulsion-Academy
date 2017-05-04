import {Board} from './board.js';
import {Level} from './level.js';
import {Pacman} from './pacman.js';

export class Game {
  constructor() {
    this.ctx = null;
    this.width = 300;
    this.height = 400;
    this.intervalId = 0

    this.prepareDOM();
    this.board = new Board(this.ctx);
    this.pacman = new Pacman(this.ctx);
  }

  /**
   * Play the game
   */
  play(){
    this.board.render();
    this.pacman.render();
    this.listeners();
    this.intervalId = setInterval(this.resetCanvas.bind(this), 20);
  }

  /**
   * Start the Canvas, ti saves the canvas context
     */
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
  }

  /**
   * Reset all the canvas to do the move effect
   */
  resetCanvas(){
    this.board.render();
    this.pacman.move();
    this.pacman.render();
  }

  /**
   * Listen for any event in the game
   * @return {[type]} [description]
   */
   listeners () {
    document.addEventListener('keydown', (event) => {
      this.changePropertyEvent (event.keyCode, true)
    });

    document.addEventListener('keyup', (event) => {
      this.changePropertyEvent (event.keyCode, false)
    });
  }

  /**
   * Change the move controllers depending the user
   * @param  {[integer]} keyCode keycode pressed or unpressed
   * @param  {[boolean]} value   change the value of the controller
   */
  changePropertyEvent (keyCode, value){
    switch(keyCode) {
      case 37:
        this.pacman.direction[2] = value;
        break;
      case 38:
        this.pacman.direction[0] = value;
        break;
      case 39:
        this.pacman.direction[3] = value;
        break;
      case 40:
        this.pacman.direction[1] = value;
        break;
    }
  }
}
