import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { AppBar } from 'material-ui';
import RaisedButton from 'material-ui/RaisedButton';

class Result extends Component {

  render() {
      return <div>
              <div>
                <AppBar
                  title="Welcome to e-trivial"
                  iconClassNameRight="muidocs-icon-navigation-expand-more"
                />
              </div>
              <div className="questionContainer">
                <span className = "statistics inblock">Final statistics</span>
                <span className = "statistics inblock">Questions answered: { this.props.totalQuestions}</span>
                <span className = "statistics green inblock">Questions right: { this.props.rightQuestions}</span>
                <span className = "statistics red inblock">Questions wrong: { this.props.totalQuestions - this.props.rightQuestions}</span>
                <Link to="/"><RaisedButton className = "statistics inblock" label="Play again" secondary={true} /></Link>
              </div>
            </div>
  }
}

const mapStateToProps = (state) => {
  return state.users;
}

export default connect(mapStateToProps)(Result);
