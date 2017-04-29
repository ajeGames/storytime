import { createAction } from 'redux-actions';
import fetch from 'isomorphic-fetch';
// import { fetchStorySummaries } from '../apidata/storytimeApi';

/*
 * Asynchronously processes sequence of actions to fetch story summaries
 * locally if available and up to date, from a remote server, or from a mock
 * (if testing).
 */
export const REQUEST_STORY_SUMMARIES = 'REQUEST_STORY_SUMMARIES';
export const RECEIVE_STORY_SUMMARIES = 'RECEIVE_STORY_SUMMARIES';

export const requestStorySummaries = createAction(REQUEST_STORY_SUMMARIES);
export const receiveStorySummaries = createAction(RECEIVE_STORY_SUMMARIES);

export const fetchStorySummaries = () => {
  return dispatch => {
    dispatch(requestStorySummaries());
    return fetch(`{ storytimeServerEndpoint }/stories/summaries`)
      .then(response => {
        dispatch(receiveStorySummaries(response.json));
      })
      .catch(response => {
        dispatch(receiveStorySummaries(new Error(response.json)))
      });
  };
};

// action types

export const FETCH_STORY_SUMMARY = 'FETCH_STORY_SUMMARY';
export const FETCH_STORY_SUMMARY_RESPONSE = 'FETCH_STORY_SUMMARY_RESPONSE';
export const FETCH_CHAPTER = 'FETCH_CHAPTER';
export const FETCH_CHAPTER_RESPONSE = 'FETCH_CHAPTER_RESPONSE';
export const SHOW_STORY = 'SHOW_STORY';
export const SHOW_CHAPTER = 'SHOW_CHAPTER';

export const fetchStorySummary = createAction(FETCH_STORY_SUMMARY);
export const fetchStorySummaryResponse = createAction(FETCH_STORY_SUMMARY_RESPONSE);
export const fetchChapter = createAction(FETCH_CHAPTER,
  (storyKey, chapterId) => ({ storyKey, chapterId }));
export const fetchChapterResponse = createAction(FETCH_CHAPTER_RESPONSE,
  (storyKey, chapter) => ({ storyKey, chapter }));
export const showStory = createAction(SHOW_STORY);
export const showChapter = createAction(SHOW_CHAPTER);
