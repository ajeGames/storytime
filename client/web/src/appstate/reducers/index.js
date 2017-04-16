import { combineReducers } from 'redux';
import library from './library';
import bookshelf from './bookshelf';
import reader from './reader'

const storyTimeApp = combineReducers({
  library,
  reader,
  bookshelf,
});

export default storyTimeApp;
