import React, { Component } from 'react';
import './App.css';
import Header from './components/Header/index';
import ToDoList from "./components/ToDoList/index";

export default class App extends Component {
  render() {
    return (
      <div className="App">
        <Header title = "Goodbye JQuery"/>
          <ToDoList/>
      </div>
    );
  }
}
