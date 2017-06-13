const reducerScore = (state = 0, action) => {

  switch (action.type) {
    case INC:
      return state + action.amount;
      break;
    case DEC:
      return state - action.amount;
      break;
    default:
  }
  return state;
}
