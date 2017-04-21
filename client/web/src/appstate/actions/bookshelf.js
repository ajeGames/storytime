export const LOAD_STORY_SUMMARY = 'LOAD_STORY_SUMMARY';
export const LOAD_CHAPTER = 'LOAD_CHAPTER';

export const loadStorySummary = (summary) => {
  return {
    type: LOAD_STORY_SUMMARY,
    payload: summary
  }
}

export const loadChapter = (storyKey, chapter) => {
  return {
    type: LOAD_CHAPTER,
    payload: {
      storyKey,
      chapter
    }
  }
}
