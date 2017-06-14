import { combineReducers } from 'redux';
import { createStore, applyMiddleware } from 'redux'; // check we also require `applyMiddleware`
import thunk from 'redux-thunk'; // require the Middleware
import feeds from './reducers/feeds';
import user from './reducers/user';

const combinedRed = combineReducers({
  user,
  feeds
})

const store = createStore(combinedRed, applyMiddleware(thunk));

export default store;
