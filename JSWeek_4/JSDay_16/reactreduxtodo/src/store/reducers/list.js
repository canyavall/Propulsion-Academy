
const initialTodos = {
    todos: [
          {id: 1, content: "Clean the house", completed: false},
          {id: 2, content: "Warter the flowers", completed: false},
          {id: 3, content: "Check the E-Mail", completed: true}
        ]
};

const list = (state = initialTodos, action) => {
  switch (action.type) {
    case "ADD_TODO":
      const newId = state.todos.length+1;
      const obj = { id: newId,
                    content: action.content,
                    completed: false
                  }
      const todos = [...state.todos ];
      todos.push(obj);
      return {todos};

    default:
      return state;
  }
}

export default list;
