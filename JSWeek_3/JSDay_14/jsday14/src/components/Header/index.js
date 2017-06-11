import React from 'react';
import logo from './logo.svg';
import './index.css';

export default class Header extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      title: "..."
    }
  }
  componentDidMount() {
  fetch("http://ron-swanson-quotes.herokuapp.com/v2/quotes")
    .then(res => res.json())
    .then(quotes => {
      this.setState( {
        title: quotes[0]
      })
    })
  }
  render(){
    return(
      <div className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h2>{this.state.title}</h2>
      </div>
    )
  }
}
