import { FETCH_STORY_SUMMARIES, FETCH_STORY_SUMMARIES_RESPONSE } from '../actions';

const initialState = {
  fetchingSummaries: false
};

const library = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_STORY_SUMMARIES:
      return {
        ...state,
        fetchingSummaries: true
      };
    case FETCH_STORY_SUMMARIES_RESPONSE:
    return {
      ...state,
      fetchingSummaries: false
    };
    default:
      return state;
  }
};

export default library;
