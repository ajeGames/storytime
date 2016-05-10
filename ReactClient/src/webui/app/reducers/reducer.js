import { Map } from 'immutable';
import { mapStory } from './backend_payload_converter';
import { draft } from './draft_reducer';

// TODO CREATE_STORY, SAVE_STORY, ADD_CHAPTER, SAVE_CHAPTER

const INITIAL_STATE = new Map();

export default function (state = INITIAL_STATE, action) {
  let out;
  const chapter = state.getIn(['story', 'chapters', action.chapterId.toString()]);
  switch (action.type) {
    case 'LOAD_STORY':
      out = state.delete('draft');
      return out.set('story', mapStory(action.story));
    case 'EDIT_SUMMARY':
      return state.set('draft', new Map({ summary: state.getIn(['story', 'summary']) }));
    case 'EDIT_CHAPTER':
      if (chapter !== undefined) {
        return state.setIn(['draft', 'chapter'], chapter);
      } else {
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
}
