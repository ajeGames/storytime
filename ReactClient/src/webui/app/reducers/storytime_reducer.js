import { combineReducers } from 'redux';
import { FETCH_CATALOG, FETCH_CATALOG_ERR, LOAD_CATALOG } from '../actions/story_actions';

const INITIAL_CATALOG_STATE = {
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
          message: action.message,
        },
      });
    case LOAD_CATALOG:
      return Object.assign({}, state, {
        isFetching: false,
        stories: action.stories,
        lastUpdated: action.receivedAt,
      });
    default:
      return state;
  }
}

const rootReducer = combineReducers({
  catalog,
});

export default rootReducer;
