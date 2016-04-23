import { createStore } from 'redux';
import { draft } from './reducers/story_reducers';

export const store = createStore( draft );

