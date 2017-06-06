const myReady = () => {
  let filmData = "";
  let starShipsData = [];
  let pilots = [];

  //Get movie data from API
  fetch("http://swapi.co/api/films?format=json")
  .then((res)=> {
    return res.json();
  }).then((data)=>{
    filmData = data;
    data.results.forEach((movie, i)=>{
      $("#movieSelect").append('<option value="'+i+'">'+movie.title+'</option>');
    })
  });

  //Prepare movie selector
  $('#movieSelect').change(function()	{
    //Clean the starship selector
    $('#starshipSelect')
    .find('option')
    .remove()
    .end()
    .append('<option value="-1">Select One</option>')

    //Get the info from the movie
		let movieSelected = $(this).find('option:selected').val();
    let text = '';
    console.log(filmData.results[movieSelected]['starships']);
    for (let key in filmData.results[movieSelected]) {
      if (key != 'characters' && key != 'planets' &&
          key != 'starships' && key != 'vehicles' &&
          key != 'species' && key != 'url')
      text += "<b>" + key + "</b>: " + filmData.results[movieSelected][key] + "<br \><br \>";
    }

    //Add to info
    $('#movieInfo').html(text);

    //Prepare the list of startships
    fetch("http://swapi.co/api/starships?format=json")
    .then((res)=> {
      return res.json();
    }).then((data)=>{
      starShipsData = data;
      data.results.forEach((starship, i)=>{
        if (filmData.results[movieSelected]['starships'].indexOf(starship.url) > -1)
        $("#starshipSelect").append('<option value="'+i+'">'+starship.name+'</option>');
      })
    });
	});

  $('#starshipSelect').change(function()	{
      //Get the info from the starship
    let starshipSelected = $(this).find('option:selected').val();
    let text = '';
    for (let key in starShipsData.results[starshipSelected]) {
      if (key != 'films' && key != 'pilots' )
      text += "<b>" + key + "</b>: " + starShips.results[starshipSelected][key] + "<br \><br \>";
    }

    //Add to info
    $('#starshipInfo').html(text);
	});

}

$(myReady);
