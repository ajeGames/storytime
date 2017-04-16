export const SHOW_STORY = 'SHOW_STORY';
export const FAIL_SHOW_STORY = 'FAIL_SHOW_STORY';
export const SHOW_CHAPTER = 'SHOW_CHAPTER';
export const FAIL_SHOW_CHAPTER = 'FAIL_SHOW_CHAPTER'

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
