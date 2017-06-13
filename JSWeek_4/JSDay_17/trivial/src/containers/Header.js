import React, { Component } from 'react';
import { connect } from 'react-redux';
import Subheader from 'material-ui/Subheader';

class Header extends Component {

  render() {
      return <div>
        <div>
          <Subheader>Player Statistics</Subheader>
          <span className = "statistics">Questions answered: { this.props.totalQuestions}</span>
          <span className = "statistics green">Questions right: { this.props.rightQuestions}</span>
          <span className = "statistics red">Questions wrong: { this.props.totalQuestions - this.props.rightQuestions}</span>
        </div>
      </div>
  }
}

const mapStateToProps = (state) => {
  return state.users;
}

export default connect(mapStateToProps)(Header);
