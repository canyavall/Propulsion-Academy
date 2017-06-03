function createGrid(){
  let wrapper = $('.wrapper');
  for (let i = 0; i < 25; i++) {
    let cell = $('<div>');
    cell.addClass("cell");
    cell.css('background',randomColor());
    wrapper.append(cell);
  }
}

function danceFloor(){
  $('.cell').each((i, e)=> e.style.backgroundColor = randomColor());
}

function randomColor () {
  let rint = Math.round(0xffffff * Math.random());
  return ('#0' + rint.toString(16)).replace(/^#0([0-9a-f]{6})$/i, '#$1');
}

$(createGrid);

setInterval(() => $(danceFloor), 1000);
