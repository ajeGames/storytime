import { createStore } from 'redux';
import { rootReducer } from './reducers/storytime_reducer';

export const store = createStore(rootReducer);
