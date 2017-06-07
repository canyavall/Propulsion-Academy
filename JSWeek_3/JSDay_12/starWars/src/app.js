async function myReady () {

  //Get movie data from API
  let data = await fetch("http://swapi.co/api/films?format=json");
  if(data.status != 200) return "error";
  let res = await data.json();
  let filmData = res.results;

  //Get airship data from API
  data = await fetch("http://swapi.co/api/starships?format=json");
  if(data.status != 200) return "error";
  res = await data.json();
  let starShipsData = res.results;
console.log(res);
  //Print movies
  filmData.forEach((movie, i)=>{
    $("#movieSelect").append('<option value="'+i+'">'+movie.title+'</option>');
  })

  //Prepare movie selector
  $('#movieSelect').change(function()	{
    //Clean the starship selector
    $('#starshipSelect')
      .find('option')
      .remove()
      .end()
      .append('<option value="-1">Select One</option>');

    //Get the info from the movie
		let movieSelected = $(this).find('option:selected').val();
    let text = '';
    for (let key in filmData[movieSelected]) {
      if (key != 'characters' && key != 'planets' &&
          key != 'starships' && key != 'vehicles' &&
          key != 'species' && key != 'url')
      text += "<b>" + key + "</b>: " + filmData[movieSelected][key] + "<br \><br \>";
    }
    //Add to info
    $('#movieInfo').html(text);

    //Prepare starship data select
    console.log(filmData[movieSelected]['starships'].length + "/ " + starShipsData.length);
    starShipsData.forEach((starship, i)=>{
      console.log(starship['url']);
          if (filmData[movieSelected]['starships'].indexOf(starship['url']) > -1){
            console.log("po");
            $("#starshipSelect").append('<option value="'+i+'">'+starship.name+'</option>');
          }

        })

    $('#starshipSelect').change(function()	{
        //Get the info from the starship
      let starshipSelected = $(this).find('option:selected').val();
      let text = '';
      for (let key in starShipsData[starshipSelected]) {
        if (key != 'films' && key != 'pilots' )
        text += "<b>" + key + "</b>: " + starShipsData[starshipSelected][key] + "<br \><br \>";
      }

      //Add to info
      $('#starshipInfo').html(text);
	  });
  });
};

$(() => {
  myReady();
});
