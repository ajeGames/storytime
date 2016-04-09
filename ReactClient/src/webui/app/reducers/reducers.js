import {Map} from 'immutable';
import { loadStory, setAbout, setAuthor, setTagLine, setTitle } from './story_reducers';

const INITIAL_STATE = Map();

export default function reducer(state = INITIAL_STATE, action) {
  switch (action.type) {
    case 'LOAD_STORY':
      return loadStory(state, action.story);
    case 'SET_TITLE':
      return setTitle(state, action.title);
    case 'SET_AUTHOR':
      return setAuthor(state, action.author);
    case 'SET_TAG_LINE':
      return setTagLine(state, action.tagLine);
    case 'SET_ABOUT':
      return setAbout(state, action.about);
  }
  return state;
}
