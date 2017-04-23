import { FETCH_STORY_SUMMARIES, FETCH_STORY_SUMMARIES_RESPONSE } from '../actions';

const initialState = {
  fetchingSummaries: false,
  storySummariesToShow: []
};

const library = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_STORY_SUMMARIES:
      return {
        ...state,
        fetchingSummaries: true
      };
    case FETCH_STORY_SUMMARIES_RESPONSE:
      const summaryKeys = action.payload.map(summary => {
        return summary.storyKey;
      });
      return {
        ...state,
        fetchingSummaries: false,
        storySummariesToShow: summaryKeys
      };
    default:
      return state;
  }
};

export default library;
