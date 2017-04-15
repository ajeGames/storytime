import { loadSummaryAction } from '../actions';

export const summary = (state = {}, action) => {
  const summaryIn = action.payload.summary;
  switch (action.type) {
    case 'LOAD_SUMMARY':
      return {
        storyKey: summaryIn.storyKey,
        author: summaryIn.author,
        tagLine: summaryIn.tagLine,
        about: summaryIn.about,
        firstChapter: summaryIn.firstChapter
      };
    default:
      return state;
  }
}

export const summaries = (state = [], action) => {
  switch (action.type) {
    case 'LOAD_SUMMARIES':
      // TODO does this create new objects?  need to ensure data shape?
      return action.payload.summaries.map(summary =>
        summary(undefined, loadSummaryAction(summary))
      )
      // return [
      //   ...(action.payload.summaries)
      // ];
    default:
      return state;
  }
}
