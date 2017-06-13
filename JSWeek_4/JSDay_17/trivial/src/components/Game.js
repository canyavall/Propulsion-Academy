import React from 'react';
import Question from '../containers/Question';
import Header from '../containers/Header'
import { AppBar } from 'material-ui';

const Game  = (props) => (
      <div>
        <AppBar
          title="Welcome to e-trivial"
          iconClassNameRight="muidocs-icon-navigation-expand-more"
        />
        <div>
          <Header />
        </div>
        <div className="questionContainer">
          <Question history={props.history} questionId = { props.match.params.questionId } nextQuestion = { nextQuestion } results = {results}/>
        </div>
      </div>
    );

  function nextQuestion () {
    const numQuestion = this.questionId*1+1;
    this.history.push("/game/" + numQuestion);
  }

  function results (){
    this.history.push("/result");
  }
export default Game;
