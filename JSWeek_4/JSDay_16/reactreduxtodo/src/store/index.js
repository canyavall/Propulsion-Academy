import { createStore } from 'redux';
import { combineReducers } from 'redux';
import filter from './reducers/filter';
import list from './reducers/list';

const combinedRed = combineReducers({
  filter,
  list
})

const store = createStore(combinedRed);

export default store;
