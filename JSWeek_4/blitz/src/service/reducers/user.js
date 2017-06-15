const initialUser = {
  "token": "",
  "username": "",
  "avatar": ""
};

const user = (state = initialUser, action) => {
  switch (action.type) {

    case 'GET_USER':
    const newState = { ...state }
    newState.token = action.content.token;
    newState.username = action.content.username;
    newState.avatar = action.content.avatar;
      return newState;

    case 'USER_LOGOUT':
      return {
        "token": null,
        "username": null,
        "avatar": null
      };

    case 'GET_USER_INFO':
      return action.content

    default:
      return state;
  }
}

export default user;
