function move (id){
    $('#' + id).css('background','black');
    if (prev != 0 ) $('#' + prev).css('background','white');
    prev = id;
}

//create a random color
function randomColor () {
  let rint = Math.round(0xffffff * Math.random());
  return ('#0' + rint.toString(16)).replace(/^#0([0-9a-f]{6})$/i, '#$1');
}
