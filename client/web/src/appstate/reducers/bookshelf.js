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

let initialState = {}
initialState[shortStory.summary.storyKey] = {
  summary: shortStory.summary,
  chapters: shortStory.chapters
};

const bookshelf = (state = initialState, action) => {
  switch (action.type) {
    case LOAD_STORY_SUMMARY:
      return Object.assign({}, state, {
        story: action.payload.summary
      });
    case LOAD_CHAPTER:
    default:
      return state;
  }
}

export default bookshelf;
