$(()=> {
  //General
  let windowWidth = $(window).width();

  //For slide
  let arraySlidePictures = ["http://placekitten.com/1536/300", "http://placebeyonce.com/1536-300"];
  let currentSlidePicture = 0;

  $('.slidePicture').prepend("<img id = " + currentSlidePicture + " src=" +arraySlidePictures[currentSlidePicture] + ">");

  //For scroll horizontal
  let scrollClicked = 0;
  const scrollPicSize = 154;
  let scrollCountItems = $(".scrollItem").length;
  let scrollCountMax = scrollCountItems - Math.floor(windowWidth/scrollPicSize);

//On widows resize
  //For scroll horizontal
  $(window).on('resize', function(){
     if($(this).width() != windowWidth){
        windowWidth = $(this).width();
        scrollCountMax = scrollCountItems - Math.floor(windowWidth/scrollPicSize);
     }
  });

//For slide


//For scroll horizontal
  $(".scrollArrowLeft").on("click", () => {
    scrollClicked--;
    setTransform ();
  })

  $(".scrollArrowRigth ").on("click", () => {
    scrollClicked++;
    setTransform ();
  })

  function setTransform () {
    if (scrollClicked == -1) scrollClicked = scrollCountMax;
    if (scrollClicked == scrollCountMax + 1) scrollClicked = 0;
    $(".scrollHorizontal").css("transform", "translateX(" + scrollPicSize * scrollClicked * -1 + "px)");
  }

})
