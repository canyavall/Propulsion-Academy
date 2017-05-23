'use strict';
let categories = ["Geography", "Gastronomy", "Sports", "Science"];
let random


/**
 * This class defines the game
 */
function Trivial () {
  this.questionList = [];
  this.allowedQuestionList = [];
  this.currentQuestion = 0;
  this.currentPlayer = 0;
  this.playerManager = null;
  this.answeredQuestions = [];
  /**
   * IF true, the random of the questions is random
   * if false, it is serial
   * @type {Boolean}
   */
  this.random = true;
  /**
   * IF the questions can be repeated or not
   * To stop it, we will finish when the user has 1 score at least in every category
   *
   * @type {Boolean}
   */
  this.repeatQuestions = false;
  this.selectedCategories = [];

  /**
   * Defines they playermanager that is going to be used
   * @param  {[type]} playermanager [description]
   */
  this.setPlayerManager = function (playermanager) {
    this.playerManager = playermanager;
  };

  /**
   * Players that will play in this trivial game
   * We will save them in the playermanager object
   * @return {[type]} [description]
   */
  this.setPlayers = function (){
    let sign = prompt("Insert new player name");
    let newPlayer = new Player (sign);
    this.playerManager.addPlayer (newPlayer);
    let confirmMorePlayers = confirm ("Add more players?");
    if (confirmMorePlayers) {
      this.setPlayers();
    }
  };

  /**
   * Add questions into the question list of the trivial
   * @param  {[question]} question [question]
   */
  this.addQuestion = function (question) {
    this.questionList.push(question);
  };

  //Ask que user for the question
  this.askQuestion = function (questionId){
    let choosedQuestion = this.allowedQuestionList[questionId];
    if (choosedQuestion.choices === true){
      return confirm('Question for: ' + this.playerManager.playerList[this.currentPlayer].Player.name  + " \n " +
                        choosedQuestion.title + "? " + " \n ");
    }else{
      let sign = prompt('Question for: ' + this.playerManager.playerList[this.currentPlayer].Player.name  + " \n " +
                        choosedQuestion.title + "? " + " \n " +
                        choosedQuestion.choices[0] + " \n " +
                        choosedQuestion.choices[1]);
        return sign.toLowerCase() === choosedQuestion.correctAns.toLowerCase();
      }
  };

  //Define if game is random or serial
  this.askRandom = function (random) {
    this.random = confirm("You want random questions for users?");
  };

  //Define if we want to repeat questions
  this.askRepeatedQuestions = function (repeat) {
    this.repeatQuestions = confirm("You want repeated questions for users?");
  };

  /**
   * Define the categories to be shown
   * @type {[array]}
   */
  this.defineCategoriesGame = function (){
    for (let i = 0; i < categories.length; i++) {
      var categoryAccepted = confirm("Do you want to play with category: " + categories[i] + "?");
      if (categoryAccepted) {
        this.selectedCategories.push(categories[i]);
      }
    }
  };

  /**
   * This is the main function where we define the game and its behaviour
   * @return {[type]} [description]
   */
  this.play = function () {
    //the first time, we will choose randomly the player
    var maxPlayers = this.playerManager.playerId - 1;
    this.currentPlayer = Math.floor(Math.random() * maxPlayers) + 0;

    //Create new pool of questions with allowed categories
    for (let i = 0; i < this.questionList.length; i++) {
      if (this.selectedCategories.indexOf(this.questionList[i].category) >= 0){
        this.allowedQuestionList.push(this.questionList[i]);
      }
    }

    //Check if we want to show the questions randomly or serial
    // if (this.random === true){
    //
    // }else{
      while (this.currentQuestion < this.allowedQuestionList.length){
        let questionResult = this.askQuestion(this.currentQuestion);
        if (questionResult) {
          this.playerManager.playerList[this.currentPlayer][this.allowedQuestionList[this.currentQuestion].category]++;
        }else{
          if (this.currentPlayer === maxPlayers) {
            this.currentPlayer = 0;
          }else{
            this.currentPlayer++;
          }
        }
        this.currentQuestion++;
      }
    // }

    // Return results by player
    for (let key in this.playerManager.playerList) {
      let categoryString = '';
      for (let i = 0; i < this.selectedCategories.length; i++) {
        categoryString += '\n' + this.selectedCategories[i] + ': ' + this.playerManager.playerList[key][this.selectedCategories[i]] + " points";
      }
      confirm ('\nPlayer: ' + this.playerManager.playerList[key].Player.name + categoryString);
    }
    return;
  };

}

//Create class question
function Question (title, category, choices, correctAns) {
  if (categories.indexOf(category) >= 0){
    this.title = title;
    this.category = category;
    this.choices = choices;
    this.correctAns = correctAns;
  } else {
    console.log("Category doesn't exist for " + title);
  }

}

/**
 * Class that defines the player name, could define more things
 * @param {[type]} name [description]
 */
function Player (name) {
  this.name = name;
}

/**
 * This class controls the players for a trivial game
 * and the scores of them for every category.
 * The category is taken from the array categories
 * and we save the score for every category and every player
 */
function PlayerManager () {
  this.playerList = {};
  this.playerId = 0;

  //Add a player into playerList
  this.addPlayer = function (player) {
    this.playerList[this.playerId] = {};
    this.playerList[this.playerId]['Player'] = player;

    //We need to create 1 score for every category
    //We are going to use an array and save it in the setPlayerManager
    //with same elements than in the initial array
    for (let i = 0; i < categories.length; i++){
      this.playerList[this.playerId][categories[i]] = 0;
    }
    this.playerId++;
  }
}


//Body code
let trivial = new Trivial();
trivial.setPlayerManager(new PlayerManager ());
trivial.setPlayers();
trivial.askRandom(true);
trivial.askRepeatedQuestions(false);

let question1 = new Question('Capital of France', 'Geography', ['A - Paris', 'B - Rome'], 'A');
let question2 = new Question('Capital of Spain', 'Geography', ['A - Madrid', 'B - Barcelona'], 'A');
let question3 = new Question('Capital of Italy', 'Geography', ['A - Milan', 'B - Rome'], 'B');
let question4 = new Question('What\'s a food name', 'Gastronomy', ['A - Hummus', 'B - Pen'], 'A');
let question5 = new Question('Where was created the pizza', 'Gastronomy', ['A - USA', 'B - Italy'], 'A');
let question6 = new Question('Is a tomato a fruit?', 'Gastronomy', true, true);
let question7 = new Question('Who\'s the best player in the worlds', 'Sports', ['A - C.Ronaldo', 'B - Messi'], 'B');
let question8 = new Question('Where is playing Dybala', 'Sports', ['A - Juventus', 'B - Paris St. Germain'], 'A');
let question9 = new Question('Max. number of players of a basketball team?', 'Sports', ['A - 11', 'B - 12'], 'B');
let question10 = new Question('Can a man breath without nose?', 'Science', true, true);
let question11 = new Question('Can an atom kill a human being?', 'Science', true, false);
let question12 = new Question('How many subatomic particles exists?', 'Science', ['A - 3', 'B - 4'], 'A');
trivial.addQuestion(question1);
trivial.addQuestion(question2);
trivial.addQuestion(question3);
trivial.addQuestion(question4);
trivial.addQuestion(question5);
trivial.addQuestion(question6);
trivial.addQuestion(question7);
trivial.addQuestion(question8);
trivial.addQuestion(question9);

trivial.defineCategoriesGame();
//console.log(trivial);

//console.log(playerManager);
trivial.play();
//console.log(trivial.questionList);
