import { createStore } from 'redux';
import { reducer } from './reducers/app_reducer';

export const store = createStore(reducer);
