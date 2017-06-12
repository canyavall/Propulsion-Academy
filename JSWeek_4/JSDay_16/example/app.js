const INC = 'inc';
const DEC = 'dec';

const reducer = (state = 0, action) => {
  switch (action.type) {
    case INC:
      state + action.amount;
      break;
    case DEC:
      state - action.amount;
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

function render() {
  const counterEl = document.getElementById('counter');
  console.log(counterEl);
  const state = store.getState;
  counterEl.innerHTML = state;
}

render();

store.subscribe(render);

document.getElementById('increment').addEventListener('click', (e)=>{
  store.dispatch(increment);
})

document.getElementById('decrement').addEventListener('click', (e)=>{
  store.dispatch(decrement);
})
