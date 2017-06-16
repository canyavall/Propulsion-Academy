export const getUsers = (users) => {
  return {
    type: 'GET_USERS',
    content: users
  }
}

export const getUsersList = () => (dispatch, getState) => {
  const token = getState().currentuser.token;
  const URL = "https://propulsion-blitz.herokuapp.com/api/users";
  const config = {
    headers: {
      Authorization: `Bearer ${token}`
    }
  };

  return fetch(URL, config)
    .then(res => {
      if (res.status === 200) return res.json();
        return res.status;
    })
    .then(users => {
      if (users !== false){
        const action = getUsers(users);
        dispatch(action);
      }
    })
    .catch(err => {
          console.log('error: ', err);
      });


}
