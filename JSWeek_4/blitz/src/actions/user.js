export const loginUser = (user) => {
  return {
    type: 'GET_USER',
    content: user
  }
}

export const userLogout = () => {
  return { type: 'USER_LOGOUT' }
}

export const checkLogin = ({ email, password }) => (dispatch, getState) => {
  const headers = {
    'Content-type': 'application/json'
  }

  const body = { email, password }

  const config = {
    method: 'POST',
    headers: headers,
    body: JSON.stringify(body)
  };
  const URL = "https://propulsion-blitz.herokuapp.com/api/login";
  return fetch(URL, config)
    .then(res => {
      if (res.status === 200) return res.json();
        return res.status;
    })
    .then(user => {
      if (user !== false){
        localStorage.setItem('userToken', user.token);
        localStorage.setItem('userAvatar', user.avatar);
        localStorage.setItem('username', user.username);
        const action = loginUser(user);
        dispatch(action);
      }
    })
    .catch(err => {
          console.log('error: ', err);
      });
}