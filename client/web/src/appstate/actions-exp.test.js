import * as actions from './actions-exp';

describe('fetchStorySummaries', () => {
  it('creates correct action w/o payload', () => {
    expect(actions.fetchStorySummaries()).toEqual({
      type: actions.FETCH_STORY_SUMMARIES
    });
  });

  it('creates failure payload correctly', () => {
    const error = new TypeError('this is so wrong');
    expect(actions.fetchStorySummaries(error)).toEqual({
      type: actions.FETCH_STORY_SUMMARIES,
      payload: error,
      error: true
    });
  });

  it('creates success action w/payload', () =>{
    const summaries = [
      { storyKey: 'a', title: 'a story' },
      { storyKey: 'b', title: 'b story' }
    ];
    expect(actions.fetchStorySummaries(summaries)).toEqual({
      type: actions.FETCH_STORY_SUMMARIES,
      payload: summaries,
    })
  });
});
