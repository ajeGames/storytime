export const loadSummariesAction = (summaries) => {
  return {
    type: 'LOAD_SUMMARIES',
    payload: {
      summaries
    }
  }
}

export const loadSummaryAction = (summary) => {
  return {
    type: 'LOAD_SUMMARY',
    payload: {
      summary
    }
  }
}
