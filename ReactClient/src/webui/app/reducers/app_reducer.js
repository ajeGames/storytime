import { Map } from 'immutable';
import { mapStory } from './backend_payload_converter';

const INITIAL_STATE = Map();

export const reduce = (state = INITIAL_STATE, action) => {
  switch(action.type) {
    case 'LOAD_STORY':
      return state.set('story', mapStory(action.story));
    //case 'CLEAR_DRAFT':
    //  return state.delete('draft');
    default:
      return state;
  }
};

