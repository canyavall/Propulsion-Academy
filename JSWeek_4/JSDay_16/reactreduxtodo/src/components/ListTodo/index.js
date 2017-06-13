import React from 'react';
import "./index.css";

export default class todo extends React.Component {

  constructor(props){
    super(props);
    this.state = {
    }

  }
  render(){
    return(
      <div>
        <ul>
          {this.props.todoList.map(todo => {
            switch (this.state.listShow) {
              case "Complete":
                if (todo.completed === false) return false;
                break;
              case "Nocomplete":
                if (todo.completed === true) return false;
                break;
              default:
            }
             return <li key = { todo['id'] }><span
                        className = {todo['completed'] ? 'TodoItem-completed' : ''}
                        onClick = {() => this.props.completed(todo['id'])}>
                      { todo['content'] }
                      </span>
                      <span onClick = {() => this.props.deleteTodo(todo['id'])}> - Delete</span>
                    </li>;
          })}
        </ul>
      </div>
    )
  }
}
