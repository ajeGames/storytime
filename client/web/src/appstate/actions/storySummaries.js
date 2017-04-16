export const FETCH_STORY_SUMMARIES = 'FETCH_STORY_SUMMARIES';
export const FAIL_FETCH_STORY_SUMMARIES = 'FAIL_FETCH_STORY_SUMMARIES';
export const LOAD_STORY_SUMMARIES = 'LOAD_STORY_SUMMARIES';
export const LOAD_STORY_SUMMARY = 'LOAD_STORY_SUMMARY';

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

export const loadStorySummary = (storySummary) => {
  return {
    type: LOAD_STORY_SUMMARY,
    payload: {
      story: storySummary
    }
  }
}
