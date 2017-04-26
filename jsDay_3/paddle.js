function Paddle (context) {
  this.context = context;
  this.render = function () {
    this.context.fillStyle = 'white';
    this.context.fillRect(this.context.canvas.clientWidth/2, this.context.canvas.clientHeight-20, 50, 10);
  }
}
