export const fetchStorySummaries = () => {
  return {
    type: 'FETCH_STORY_SUMMARIES'
  }
}

export const failFetchStorySummaries = (error) => {
  return {
    type: 'FAIL_FETCH_STORY_SUMMARIES',
    error: true,
    payload: new Error(error)
  }
}

export const loadStorySummaries = (storySummaries) => {
  return {
    type: 'LOAD_STORY_SUMMARIES',
    payload: {
      stories: storySummaries
    }
  }
}

export const loadStorySummary = (storySummary) => {
  return {
    type: 'LOAD_STORY_SUMMARY',
    payload: {
      story: storySummary
    }
  }
}
