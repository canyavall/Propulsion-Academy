$(()=> {
  let clicked = 0;
  let countMax = $(".item").length - 4;

  $(".arrowLeft").on("click", () => {
    clicked--;
    setTransform ();
  })

  $(".arrowRight").on("click", () => {
    clicked++;
    setTransform ();
  })

  function setTransform () {
    if (clicked == -1) clicked = countMax;
    if (clicked == countMax + 1) clicked = 0;
    $(".horizontal-scroll").css("transform", "translateX(" + clicked * 154 * -1 + "px)");
  }

})
