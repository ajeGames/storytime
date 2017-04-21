/*
  bookshelf: {
    astorykey: {
      ...summary,
      chapters: {
        achapterid: {},
        bchapterid: {},
        cchapterid: {},
      }
    },
    bstorykey: {
      ...summary,
      chapters: {
        achapterid: {},
        bchapterid: {},
      }
    }
  }
}
*/

import { LOAD_STORY_SUMMARY, LOAD_CHAPTER } from '../actions';
import { shortStory } from '../../apidata';

let initialState = {};
initialState[shortStory.summary.storyKey] = {
  summary: shortStory.summary,
  chapters: shortStory.chapters
};

function prepSummaryForStorage(summary) {
  let node = {};
  node[summary.storyKey] = {
    summary
  };
  return node;
}

const bookshelf = (state = initialState, action) => {
  switch (action.type) {
    case LOAD_STORY_SUMMARY:
      console.log('From bookshelf reducer: ' + JSON.stringify(action));
      return Object.assign({}, state,
         prepSummaryForStorage(action.payload));
    case LOAD_CHAPTER:
    default:
      return state;
  }
}

export default bookshelf;
