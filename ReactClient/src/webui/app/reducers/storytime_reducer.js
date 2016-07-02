import { combineReducers } from 'redux';
import { Map } from 'immutable';
import { FETCH_CATALOG, FETCH_CATALOG_ERR, LOAD_CATALOG } from '../actions/story_actions';
import { mapStory } from './backend_payload_converter';
import { draft } from './draft_reducer';

export const INITIAL_CATALOG_STATE = {
  isFetching: false,
  stories: [],
};

function catalog(state = INITIAL_CATALOG_STATE, action) {
  switch (action.type) {
    case FETCH_CATALOG:
      return Object.assign({}, state, {
        isFetching: true,
      });
    case FETCH_CATALOG_ERR:
      return Object.assign({}, state, {
        isFetching: false,
        error: {
          message: action.payload.message,
        },
      });
    case LOAD_CATALOG:
      return Object.assign({}, state, {
        isFetching: false,
        stories: action.payload.stories,
      });
    default:
      return state;
  }
}

const EDITOR_INITIAL_STATE = new Map();

function editor(state = EDITOR_INITIAL_STATE, action) {
  let out;
  const chapter = state.getIn(['story', 'chapters', action.chapterId]);
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

const rootReducer = combineReducers({
  catalog,
  editor,
});

export default rootReducer;
