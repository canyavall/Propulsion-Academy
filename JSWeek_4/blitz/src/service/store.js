import { combineReducers } from 'redux';
import { createStore, applyMiddleware } from 'redux'; // check we also require `applyMiddleware`
import thunk from 'redux-thunk'; // require the Middleware
import feed from './reducers/feed';
import user from './reducers/user';

const combinedRed = combineReducers({
  user,
  feed
})

const store = createStore(combinedRed, applyMiddleware(thunk));

export default store;
