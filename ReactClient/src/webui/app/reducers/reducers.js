import {Map} from 'immutable';
import StoryReducers from './story_reducers';

const INITIAL_STATE = Map();

export default function reducer(state = INITIAL_STATE, action) {
  switch (action.type) {
    case 'LOAD_STORY':
      return StoryReducers.loadStory(state, action.story);
    case 'SET_TITLE':
      return StoryReducers.setTitle(state, action.title);
    case 'SET_AUTHOR':
      return StoryReducers.setAuthor(state, action.author);
    case 'SET_TAG_LINE':
      return StoryReducers.setTagLine(state, action.tagLine);
    case 'SET_ABOUT':
      return StoryReducers.setAbout(state, action.about);
  }
  return state;
}
