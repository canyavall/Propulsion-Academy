const reducerTodo = (state = [], action) => {
  switch (action.type) {
    case ADD:
    console.log(action.text);
      state.push(action.text);
      break;
    default:
  }
  return state;
}
