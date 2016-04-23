import {Map} from 'immutable';
import { loadStory, setAbout, setAuthor, setTagLine, setTitle } from './story_reducers';

const INITIAL_STATE = Map();

export default function reducer(state = INITIAL_STATE, action) {
  switch (action.type) {
    case 'LOAD_STORY':
      return loadStory(state, action.story);
  }
  return state;
}
