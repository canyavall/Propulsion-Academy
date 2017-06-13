import React, { Component } from 'react';
import { connect } from 'react-redux';
import Todolist from '../ListTodo/index';
import NewTodo from '../NewTodo/index';
import Header from '../Header/index';
import Filter from '../FilterTodo/index'
import './index.css';

class App extends Component {



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
  render() {
    console.log(this.props);
    return (
      <div className="App">
        <Header/>
        <NewTodo addTodo={this.addTodo}></NewTodo>
        <Filter />
        <Todolist todoList={this.props.todos}
                  completed={this.setComplete}
                  deleteTodo={this.deleteTodo}
        ></Todolist>
      </div>
    );
  }

}

const mapStateToProps = (state) => {
  return {
    todos: state.list.todos,
  }
}

export default connect(mapStateToProps)(App);
// export default App;
