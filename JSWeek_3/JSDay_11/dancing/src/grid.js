//previous selected cell
let prev = 1;

/**
 * Create the grid and prepared all the cells.
 * @return {[type]} [description]
 */
function createGrid(){
  //Create grid
  let wrapper = $('.wrapper');
  let rowCounter = 1;
  let colCounter = 1;
  for (let i = 1; i <= 25; i++) {
    let cell = $('<div>');
    cell.attr("id", i);
    cell.attr("row", rowCounter);
    cell.attr("col", colCounter);
    cell.addClass("cell");
    wrapper.append(cell);
    colCounter++;
    if (colCounter == 6){
      rowCounter++;
      colCounter = 1;
    }
  }

  $('.cell').on('click', (e) => {
      e.currentTarget.style.backgroundColor = "black";
      if (prev != 0 ) $('#' + prev).css('background','white');
      prev = e.currentTarget.id;
    }
  );
}
