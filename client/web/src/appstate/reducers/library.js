import { FETCH_STORY_SUMMARIES } from '../actions/storySummaries';
// import storySummaries from '../../apidata/storySummaries';

const initialState = {
  library: {
    fetchingSummaries: false,
    storySummariesToShow: []
  }
};

const library = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_STORY_SUMMARIES:
      return Object.assign({}, state, {
        fetchingSummaries: true
      })
    default:
      return state;
  }
};

export default library;

// export const summary = (state = {}, action) => {
//   const summaryIn = action.payload.summary;
//   switch (action.type) {
//     case 'LOAD_SUMMARY':
//       return {
//         storyKey: summaryIn.storyKey,
//         author: summaryIn.author,
//         tagLine: summaryIn.tagLine,
//         about: summaryIn.about,
//         firstChapter: summaryIn.firstChapter
//       };
//     default:
//       return state;
//   }
// }
//
// export const summaries = (state = [], action) => {
//   switch (action.type) {
//     case 'LOAD_SUMMARIES':
//       // TODO does this create new objects?  need to ensure data shape?
//       return action.payload.summaries.map(summary =>
//         summary(undefined, loadSummaryAction(summary))
//       )
//       // return [
//       //   ...(action.payload.summaries)
//       // ];
//     default:
//       return state;
//   }
// }
