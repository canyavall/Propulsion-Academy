import React, { Component } from 'react';
import { connect } from 'react-redux';
import RaisedButton from 'material-ui/RaisedButton';
import { incTotalQuestion, incRightQuestion } from '../actions/actions';

class Question extends Component {

  render() {
      const currentQuestion = this.props.questions[this.props.questionId*1];
    return (
      <div>
        <div className="questionTitle">
          { currentQuestion[0] }
        </div>
        <div>
        { Object.keys(currentQuestion[1]).map((key, index) =>
          <RaisedButton key={key} onClick={() => this.answerClicked(key)} label= {currentQuestion[1][key][0]} />

        )}
        </div>
      </div>
    );
  }

  answerClicked = (key) => {
    console.log(this.props);
    const currentQuestion = this.props.questions[this.props.questionId*1];
    this.props.dispatch(incTotalQuestion());
    if (currentQuestion[1][key][1]) this.props.dispatch(incRightQuestion());
    if(Object.keys(this.props.questions).length !== (this.props.questionId*1)) {
      this.props.history.push(this.props.questionId*1+1);
      console.log(this.props.history); //Tengo que llamar la funcion al padre
    }
  }
}

const mapStateToProps = (state) => {
  return state;
}

export default connect(mapStateToProps)(Question);
