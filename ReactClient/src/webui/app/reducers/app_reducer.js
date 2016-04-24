import { Map } from 'immutable';

const INITIAL_STATE = Map();

export const reducer = (state = INITIAL_STATE, action) => {
  switch(action.type) {
    case 'LOAD_STORY':
      return state;
    case 'CLEAR_DRAFT':
      return state.delete('draft');
    default:
      return state;
  }
};

