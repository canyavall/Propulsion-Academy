const ADD = 'add';
const DEL = 'del';
const INC = 'inc';
const DEC = 'dec';

const initialState = {
  todos: [],
  counter: 0
}

const reducer = (state = initialState, action) => {

  switch (action.type) {
    case ADD:
    console.log(action.text);
      state.todos.push(action.text);
      break;
    case DEL:
      state -= action.amount;
      break;
    case INC:
      state.counter += action.amount;
      break;
    case DEC:
      state.counter -= action.amount;
      break;
    default:
  }
  return state;
}

const store = Redux.createStore(reducer);

const increment = {
  type: INC,
  amount: 1
}

const decrement = {
  type: DEC,
  amount: 1
}

function addTodo(textValue){
  return {
        type: ADD,
        text: textValue
      };
}

function delTodo(){
  let text = document.getElementById('todoText');
  store.dispatch({
        type: ADD,
        text: text.value
      });
  text.value = "";
}

function render() {
    const state = store.getState();

  //Counter
  const counterEl = document.getElementById('counter');
  counterEl.innerHTML = state.counter;
  //List
  const listEl = document.getElementById('todoList');
  listEl.innerHTML = "";
  if (state.todos.length > 0){
    state.todos.forEach((todo) => {
      var li = document.createElement("li");
      li.innerHTML = todo;
      listEl.appendChild(li);
    });
  }
}

render();

store.subscribe(render);

document.getElementById('increment').addEventListener('click', (e)=>{
  store.dispatch(increment);
})

document.getElementById('decrement').addEventListener('click', (e)=>{
  store.dispatch(decrement);
})

document.getElementById('addTodoButton').addEventListener('click', (e)=>{
  let text = document.getElementById('todoText');
  text.value = "";
  store.dispatch(addTodo(text.value));
})
