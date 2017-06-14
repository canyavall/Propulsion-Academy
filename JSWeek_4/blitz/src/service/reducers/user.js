const initialUser = {};
const user = (state = initialUser, action) => {
  switch (action.type) {
    case 'LOGIN_USER':
      return action;
    default:
      return state;
  }
}

export default user;
