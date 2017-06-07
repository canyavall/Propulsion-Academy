$(()=> {
  let scrollClicked = 0;
  let windowWidth = $(window).width();
  const scrollPicSize = 154;
  let scrollCountItems = $(".scrollItem").length;
  let scrollCountMax = scrollCountItems - Math.floor(windowWidth/scrollPicSize);

//On widows resize
  $(window).on('resize', function(){
     if($(this).width() != windowWidth){
        windowWidth = $(this).width();
        scrollCountMax = scrollCountItems - Math.floor(windowWidth/scrollPicSize);
     }
  });

//For scoll horizontal
  $(".arrowLeftScroll").on("click", () => {
    scrollClicked--;
    setTransform ();
  })

  $(".arrowRightScroll").on("click", () => {
    scrollClicked++;
    setTransform ();
  })

  function setTransform () {
    if (scrollClicked == -1) scrollClicked = scrollCountMax;
    if (scrollClicked == scrollCountMax + 1) scrollClicked = 0;
    $(".horizontal-scroll").css("transform", "translateX(" + scrollPicSize * scrollClicked * -1 + "px)");
  }

})
