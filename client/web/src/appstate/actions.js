import { createAction } from 'redux-actions';

// action types

export const FETCH_STORY_SUMMARIES = 'FETCH_STORY_SUMMARIES';
export const FETCH_STORY_SUMMARIES_RESPONSE = 'FETCH_STORY_SUMMARIES_RESPONSE';
export const FETCH_STORY_SUMMARY = 'FETCH_STORY_SUMMARY';
export const FETCH_STORY_SUMMARY_RESPONSE = 'FETCH_STORY_SUMMARY_RESPONSE';
export const FETCH_CHAPTER = 'FETCH_CHAPTER';
export const FETCH_CHAPTER_RESPONSE = 'FETCH_CHAPTER_RESPONSE';
export const SHOW_STORY = 'SHOW_STORY';
export const SHOW_CHAPTER = 'SHOW_CHAPTER';

// action creators

export const fetchStorySummaries = createAction(FETCH_STORY_SUMMARIES);
export const fetchStorySummariesResponse = createAction(FETCH_STORY_SUMMARIES_RESPONSE);
export const fetchStorySummary = createAction(FETCH_STORY_SUMMARY);
export const fetchStorySummaryResponse = createAction(FETCH_STORY_SUMMARY_RESPONSE);
export const fetchChapter = createAction(FETCH_CHAPTER,
  (storyKey, chapterId) => ({ storyKey, chapterId }));
export const fetchChapterResponse = createAction(FETCH_CHAPTER_RESPONSE,
  (storyKey, chapter) => ({ storyKey, chapter }));

export const showStory = createAction(SHOW_STORY);
export const showChapter = createAction(SHOW_CHAPTER);
