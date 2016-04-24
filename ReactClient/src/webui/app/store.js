import { createStore } from 'redux';
import { reduce } from './reducers/app_reducer';

export const store = createStore( reduce );

