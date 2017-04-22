export const LOAD_STORY_SUMMARY = 'LOAD_STORY_SUMMARY';
export const LOAD_CHAPTER = 'LOAD_CHAPTER';
export const FETCH_STORY_SUMMARIES = 'FETCH_STORY_SUMMARIES';
export const FAIL_FETCH_STORY_SUMMARIES = 'FAIL_FETCH_STORY_SUMMARIES';
export const LOAD_STORY_SUMMARIES = 'LOAD_STORY_SUMMARIES';
export const SHOW_STORY = 'SHOW_STORY';
export const FAIL_SHOW_STORY = 'FAIL_SHOW_STORY';
export const SHOW_CHAPTER = 'SHOW_CHAPTER';
export const FAIL_SHOW_CHAPTER = 'FAIL_SHOW_CHAPTER'

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

export const fetchStorySummaries = () => {
  return {
    type: FETCH_STORY_SUMMARIES
  }
}

export const failFetchStorySummaries = (errorMessage) => {
  return {
    type: FAIL_FETCH_STORY_SUMMARIES,
    error: true,
    payload: {
      errorMessage
    }
  }
}

export const loadStorySummaries = (storySummaries) => {
  return {
    type: LOAD_STORY_SUMMARIES,
    payload: {
      stories: storySummaries
    }
  }
}

export const showStory = (storyKey) => {
    return {
      type: SHOW_STORY,
      payload: {
        storyKey
      }
    }
}

export const failShowStory = (errorMessage) => {
  return {
    type: FAIL_SHOW_STORY,
    error: true,
    payload: {
      errorMessage
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

export const failShowChapter = (errorMessage) => {
  return {
    type: FAIL_SHOW_CHAPTER,
    error: true,
    payload: {
      errorMessage
    }
  }
}
