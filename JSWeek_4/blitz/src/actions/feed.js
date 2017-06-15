export const getFeed = (feed) => {
  return {
    type: 'GET_FEED',
    content: feed
  }
}


export const getFeedList = () => (dispatch, getState) => {
  const token = getState().user.token;
  const URL = "https://propulsion-blitz.herokuapp.com/api/feed";
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
    .then(feed => {
      if (feed !== false){
        const action = getFeed(feed);
        dispatch(action);
      }
    })
    .catch(err => {
          console.log('error: ', err);
      });


}
