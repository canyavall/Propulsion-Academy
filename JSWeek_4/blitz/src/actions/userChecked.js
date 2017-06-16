export const getUser = (user) => {
  return {
    type: 'GET_USERCHECKED',
    content: user
  }
}

export const getUserChecked = (id) => (dispatch, getState) => {
  const token = getState().currentuser.token;
  const URL = `https://propulsion-blitz.herokuapp.com/api/users/${id}`;
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
    .then(user => {
      if (user !== false){
        const action = getUser(user);
        dispatch(action);
      }
    })
    .catch(err => {
          console.log('error: ', err);
      });


}
