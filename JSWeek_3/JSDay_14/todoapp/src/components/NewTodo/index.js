import React from 'react';

export default class newtodo extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      newTodo: ''
    };
  }

  render(){
    return(
      <div>
        <form onSubmit={this.handleAddTodo}>
          <input type="text" value={ this.state.newTodo } onChange={this.handleNewTodo}/>
          <button type="submit">Create new Todo</button>
        </form>
      </div>
    )
  }

  handleNewTodo = (e) => {
    const newTodo = e.currentTarget.value;
    this.setState({ newTodo });
  }

  handleAddTodo = (e) => {
    e.preventDefault();
    this.props.addTodo(this.state.newTodo);
    this.setState({ newTodo: '' });
  }

}
