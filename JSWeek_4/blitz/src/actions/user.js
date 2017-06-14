export const loginUser = (user) => {
  return {
    type: 'LOGIN_USER',
    action: user
  }
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

  return fetch('https://propulsion-blitz.herokuapp.com/api/login', config)
    .then(res => res.json())
    .then(user => {
      const action = loginUser(user);
      dispatch(action);
      if (user.email) return "ok"
    })
    .catch(err => {
      console.log('in da error');
    })

}
