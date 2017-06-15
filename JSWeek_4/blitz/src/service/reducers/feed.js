const feed = (state = {}, action) => {
  switch (action.type) {
    case 'GET_FEED':
      return action.content;
    default:
      return state;
  }
}

export default feed;
