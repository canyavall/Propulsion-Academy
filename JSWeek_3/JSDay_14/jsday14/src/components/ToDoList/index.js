import React from 'react';

export default class ToDoList extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      todos: ["Learn JS", "Learn Redux", "Learn React"],
      todos2: ["Learn JS", "Learn Redux", "Learn React"],
      todos3: ["Learn JS", "Learn Redux", "Learn React"],
      inputVal: ""
    }
  }

  render(){
    const todosItems = this.state.todos.map(todo => {
      return <li key = { todo }> { todo } </li>;
    });
    return(
      <div>
        <div>
          <input type="text" value = { this.state.inputVal }  onChange= {this.handleInput}/>
          <button onClick={ this.addTodo } >Add Todo</button>
        </div>
        <div>
          <ul>
              { todosItems }
              { this.renderTodos() }
               {this.state.todos3.map(todo => {
                return <li key = { todo }> { todo } </li>;
              }) }
          </ul>
        </div>
      </div>
    );
  }

  renderTodos (){
    return this.state.todos2.map(todo => {
      return <li key = { todo }> { todo } </li>;
    })
  }

  addTodo = () => {
    const newTodos = [...this.state.todos ];
    newTodos.push(this.state.inputVal);
    this.setState({
      todos: newTodos,
      inputVal: ""
    })
  }

  handleInput = (e) => {
    this.setState({
      inputVal: e.currentTarget.value
    })
  }
}
