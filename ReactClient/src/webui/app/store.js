import { createStore } from 'redux';

// TODO understand why tests do not see reducer as function when it is
const root = require('./reducers/storytime_reducer.js').default;

export const store = createStore(root);
