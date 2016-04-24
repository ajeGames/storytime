import { Map } from 'immutable';
import { mapStory } from './backend_payload_converter';
import { draft } from './draft_reducer';

// TODO CREATE_STORY, SAVE_STORY, ADD_CHAPTER, SAVE_CHAPTER

const INITIAL_STATE = Map();

export const reduce = (state = INITIAL_STATE, action) => {
  let out;
  switch (action.type) {
    case 'LOAD_STORY':
      out = state.delete('draft');
      return out.set('story', mapStory(action.story));
    case 'EDIT_SUMMARY':
      return state.set('draft', Map({summary: state.getIn(['story', 'summary'])}));
    case 'EDIT_CHAPTER':
      const chapter = state.getIn(['story', 'chapters', action.chapterId.toString()]);
      if (chapter !== undefined) {
        return state.setIn(['draft', 'chapter'], chapter);
      } else {
        console.log('Chapter not found: ' + action.chapterId);
        return state;
      }
    case 'SET_TITLE':
    case 'SET_AUTHOR':
    case 'SET_TAG_LINE':
    case 'SET_ABOUT':
    case 'SET_HEADING':
    case 'SET_PROSE':
    case 'ADD_SIGN':
      return state.set('draft', draft(state.get('draft'), action));
    default:
      return state;
  }
};
