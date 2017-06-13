import { createStore } from 'redux';
import { combineReducers } from 'redux';
import questions from './reducers/questions';
import users from './reducers/users';

const combinedRed = combineReducers({
  users,
  questions
})

const store = createStore(combinedRed);

export default store;
