import React from 'react';
import "./index.css";

export default class todo extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      listShow: "All"
    }

  }
  render(){
    return(
      <div>
        <div>
          <label htmlFor="all">All</label>
            <input type="radio" name="filter" id="all" onClick={() => this.setState({listShow: "All"})}/>
          <label htmlFor="complete">Complete</label>
            <input type="radio" name="filter" id="complete" onClick={() => this.setState({listShow: "Complete"})}/>
          <label htmlFor="nocomplete">No Completed</label>
            <input type="radio" name="filter" id="notcomplete" onClick={() => this.setState({listShow: "Nocomplete"})}/>
        </div>
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
      </div>
    )
  }
}
