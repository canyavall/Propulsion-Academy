const ADD = 'add';
const DEL = 'del';
const INC = 'inc';
const DEC = 'dec';

const combinedRed = Redux.combineReducers({
  reducerTodo,
  reducerScore
})


const increment = {
  type: INC,
  amount: 1
}

const decrement = {
  type: DEC,
  amount: 1
}


const store = Redux.createStore(combinedRed);


function addTodo(textValue){
  return {
        type: ADD,
        text: textValue
      };
}

function delTodo(){
  let text = document.getElementById('todoText');
  store.reducerTodo.dispatch({
        type: ADD,
        text: text.value
      });
  text.value = "";
}


function render() {
  const state = store.getState();
  //Counter
  const counterEl = document.getElementById('counter');
  counterEl.innerHTML = state.reducerScore;

  //List
  const listEl = document.getElementById('todoList');
  listEl.innerHTML = "";
  if (state.reducerTodo.length > 0){
    state.reducerTodo.forEach((todo) => {
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
  store.dispatch(addTodo(text.value));
  text.value = "";
})
