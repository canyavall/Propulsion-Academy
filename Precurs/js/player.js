//Create Player class
function Player () {
	this.tracks = {};
	this.current = 1;
	this.key = 0;
}

// Add a new track, we need the name of the song
Player.prototype.add = function (track) {
	  //Increment the key
  	this.key = this.key + 1;
	this.tracks[this.key] = {};
  	this.tracks[this.key] = track;

}

Player.prototype.play = function () {
  	console.log("Playing: " + this.tracks[this.current]["title"] + " by " + this.tracks[this.current]["artist"]);
}

Player.prototype.next = function () {
	//Let's control "next" to not overexceed the number of tracks in the play list, if it does, let's jump to track 1
	this.current = this.current + 1;

	if (this.current >this. key){
		this.current = 1;
	}
}

Player.prototype.selectTrack = function (trackName) {
  	for (key in this.tracks){
  		if (this.tracks[key].title === trackName){
  			console.log("Playing: " + this.tracks[key]["title"] + " by " + this.tracks[key]["artist"]);
  		}
  	}
  	
}

//Create Track class
function Track (artist, title, album) {
	this.artist = artist;
	this.title = title;
	this.album = album;
}

Track.prototype.play = function () {
	console.log("Playing: " +this.title + " by " + this.artist);	
}


// Command line
var player = new Player ();
var track = new Track ();
var driveTrack = new Track('Incubus', 'Drive', 'Make Yourself');
var laBambaTrack = new Track('Ritchie Valens', 'La Bamba', 'La Bamba');
player.add(driveTrack);
player.add(laBambaTrack);
player.play();
driveTrack.play();
player.selectTrack("La Bamba");
// I'm sorry but I'm out of time, so I'll try to finish bonuses when I've finish all the tasks, as I'm short on time

