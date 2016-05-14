import { createStore } from 'redux';
// import { rootReducer } from './reducers/storytime_reducer';

const root = require('./reducers/storytime_reducer.js').default;

export const store = createStore(root);
