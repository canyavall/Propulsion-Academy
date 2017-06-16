const users = (state = {}, action) => {
  switch (action.type) {
    case 'GET_USERS':
      return action.content;
    default:
      return state;
  }
}

export default users;
