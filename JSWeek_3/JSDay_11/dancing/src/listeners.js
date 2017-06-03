//add listener
document.addEventListener('keydown', (e) => {
  console.log(e.keyCode);
  switch (e.keyCode) {
    case 87://W
      ($('#' + prev).attr("row") == 1) ? move(prev*1 + 20) : move(prev*1 - 5);
      break;
    case 65: //A
      ($('#' + prev).attr("col") == 1) ?   move(prev*1 + 4) : move(prev*1 - 1);
      break;
    case 68: //D
      ($('#' + prev).attr("col") == 5) ?   move(prev*1 - 4) : move(prev*1 + 1);
      break;
    case 83: //S
      ($('#' + prev).attr("row") == 5) ? move(prev*1 - 20) : move(prev*1 + 5);
      break;
    case 81: //Q
      move(prev*1 - 6);
      break;
    case 69: //E
      move(prev*1 - 4);
      break;
    case 90: //Z
      move(prev*1 + 4);
      break;
    case 67: //C
      move(prev*1 + 6);
      break;
    default:
  }
});
