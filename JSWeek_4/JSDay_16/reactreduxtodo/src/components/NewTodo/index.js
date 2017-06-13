import React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import addNewTodo from '../../actions/addNewTodo'

class newtodo extends React.Component {

  render(){
    return(
      <div>
      <Link to="test">Testing</Link>
        <form onSubmit={ this.handleAddTodo }>
          <input id = "inputAddTodo" type="text"/>
          <button type="submit">Create new Todo</button>
        </form>
      </div>
    )
  }


  handleAddTodo = (e) => {
    const text = document.getElementById('inputAddTodo');
    e.preventDefault();
    this.props.dispatch(addNewTodo(text.value));
    text.value = "";
  }

}

export default connect()(newtodo);
