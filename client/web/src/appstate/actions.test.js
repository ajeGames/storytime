import * as actions from './actions';

describe('fetch story summaries actions', () => {
  it('creates request action', () => {
    expect(actions.requestStorySummaries()).toEqual({
      type: actions.REQUEST_STORY_SUMMARIES
    });
  });

  it('creates failure action', () => {
    const error = new TypeError('this is so wrong');
    expect(actions.receiveStorySummaries(error)).toEqual({
      type: actions.RECEIVE_STORY_SUMMARIES,
      payload: error,
      error: true
    });
  });

  it('creates response action', () => {
    const summaries = [
      { storyKey: 'a', title: 'a story' },
      { storyKey: 'b', title: 'b story' }
    ];
    expect(actions.receiveStorySummaries(summaries)).toEqual({
      type: actions.RECEIVE_STORY_SUMMARIES,
      payload: summaries
    });
  });
});

describe('fetch story summaries asynchronous action', () => {
  it('returns summaries', () => {
    // return fetchStorySummaries().then(??)
  });
});

describe('fetch story summary actions', () => {
  it('creates request action', () => {
    const storyKey = 'abc123';
    expect(actions.fetchStorySummary(storyKey)).toEqual({
      type: actions.FETCH_STORY_SUMMARY,
      payload: storyKey
    });
  });

  it('creates failure action', () => {
    const storyKey = 'abc123';
    const errorMsg =`Story with key ${storyKey} not found`;
    const error = new TypeError(errorMsg);
    expect(actions.fetchStorySummaryResponse(error)).toEqual({
      type: actions.FETCH_STORY_SUMMARY_RESPONSE,
      payload: error,
      error: true
    });
  });

  it('creates response action', () => {
    const summary = { storyKey: 'abc123', title: 'a great story' };
    expect(actions.fetchStorySummaryResponse(summary)).toEqual({
      type: actions.FETCH_STORY_SUMMARY_RESPONSE,
      payload: summary
    });
  });
});

describe('fetch chapter actions', () => {
  it('creates request action', () => {
    const storyKey = 'abc123';
    const chapterId = '42';
    expect(actions.fetchChapter(storyKey, chapterId)).toEqual({
      type: actions.FETCH_CHAPTER,
      payload: {
        storyKey,
        chapterId
      }
    });
  });

  it('creates failure action', () => {
    const storyKey = 'abc123';
    const chapterId = '42'
    const errorMsg =`Chapter ${chapterId} of story ${storyKey} not found`;
    const error = new TypeError(errorMsg);
    expect(actions.fetchChapterResponse(error)).toEqual({
      type: actions.FETCH_CHAPTER_RESPONSE,
      payload: error,
      error: true
    });
  });

  it('create response action', () => {
    const storyKey = 'abc123';
    const chapter = { chapterId: '42', title: 'surprise!' };
    expect(actions.fetchChapterResponse(storyKey, chapter)).toEqual({
      type: actions.FETCH_CHAPTER_RESPONSE,
      payload: {
        storyKey,
        chapter
      }
    });
  });
});

describe('show story and chapter actions', () => {
  it('indicates key of story to show', () => {
    expect(actions.showStory('abc123')).toEqual({
      type: actions.SHOW_STORY,
      payload: 'abc123'
    });
  });

  it('indicates id of chapter to show', () => {
    expect(actions.showChapter('42')).toEqual({
      type: actions.SHOW_CHAPTER,
      payload: '42'
    });
  });
});
