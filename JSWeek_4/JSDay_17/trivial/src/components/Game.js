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
          <Question history={props.history} questionId = { props.match.params.questionId }/>
        </div>
      </div>
    )
export default Game;
