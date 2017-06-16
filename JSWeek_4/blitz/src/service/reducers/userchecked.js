const userchecked = (state = {}, action) => {
  switch (action.type) {
    case 'GET_USERCHECKED':
      return action.content;
    default:
      return state;
  }
}

export default userchecked;
