import React, { Component } from 'react';
import './App.css';
import Todolist from './components/TodoList/index';
import NewTodo from './components/NewTodo/index';
import Header from './components/Header/index';
import Store from './store';

export default class App extends Component {
  constructor (props){
    super(props);
    this.state = {
      todos: [{id: 1, content: "Clean the house", completed: false},
              {id: 2, content: "Warter the flowers", completed: false},
              {id: 3, content: "Check the E-Mail", completed: true}
            ]
    }
  }
  render() {
    return (
      <div className="App">
        <Header/>
        <NewTodo addTodo = {this.addTodo}></NewTodo>
        <Todolist todoList = {this.state.todos}
                  completed = {this.setComplete}
                  deleteTodo = {this.deleteTodo}
        ></Todolist>
      </div>
    );
  }

  addTodo = (newTodo) => {
    const newId = this.state.todos.length+1;
    const obj = { id: newId,
                  content: newTodo,
                  completed: false
                }
    const todos = [...this.state.todos ];
    todos.push(obj);
    this.setState({todos});
  }

  deleteTodo = (id) => {
    let arrayi = 0;
    const todos = [...this.state.todos ];
    for (let i = 0; i < todos.length; i++) {
      if (todos[i].id === id){
        arrayi = i;
        break;
      }
    }
    todos.pop(arrayi+1);
    this.setState({todos});
  }

  setComplete = (id) => {
    const todos = [...this.state.todos ];
    for (let i = 0; i < todos.length; i++) {
      if (todos[i].id === id){
        todos[i].completed = (todos[i].completed === true) ? false : true;
        break;
      }
    }
    this.setState({todos});
  }

}
