// WARNING: This is an experiment that I might use once it stops giving me a headache.
// FAIL: This does not make sense, and there are no easy-to-find examples.

import { createActions } from 'redux-actions';

// action types

export const FETCH_STORY_SUMMARIES = 'FETCH_STORY_SUMMARIES';
export const FETCH_STORY_SUMMARY = 'FETCH_STORY_SUMMARY';
export const FETCH_CHAPTER = 'FETCH_CHAPTER';
export const SHOW_STORY = 'SHOW_STORY';
export const SHOW_CHAPTER = 'SHOW_CHAPTER';

// action creators

export const { actionOne, actionTwo, actionThree } = createActions({
  // function form; payload creator defined inline
  ACTION_ONE: (key, value) => ({ [key]: value }),

  // array form
  ACTION_TWO: [
    (first) => [first],             // payload
    (first, second) => ({ second }) // meta
  ],

  // trailing action type string form; payload creator is the identity
}, 'ACTION_THREE');

export const {
    fetchStorySummaries,
    fetchStorySummary,
    fetchChapter
  } = createActions({
    FETCH_STORY_SUMMARIES: () => ({}),
    FETCH_STORY_SUMMARY: () => ({}),
    FETCH_CHAPTER: () => ({})
  });

export const showStory = (storyKey) => {
    return {
      type: SHOW_STORY,
      payload: {
        storyKey
      }
    }
}

export const showChapter = (chapterId) => {
    return {
      type: SHOW_CHAPTER,
      payload: {
        chapterId
      }
    }
}
