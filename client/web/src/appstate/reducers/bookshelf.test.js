import { bookshelf } from './bookshelf';
import {
  fetchStorySummaryResponse,
  fetchChapterResponse,
  fetchStorySummariesResponse
} from '../actions';

export const testSummary = {
  storyKey: 'story123',
  title: 'hello world',
  author: {
    id: 'author::1234',
    penName: 'Bubba Gump'
  },
  tagLine: 'every little thing is gonna be alright',
  about: 'this should draw you in',
  firstChapter: 'chapter123'
}

export const testChapter = {
  id: 'chapter123',
  title: 'Danger Lies Within',
  prose: 'blah blah blah',
  signpost: [
    {
      destination: 'chapter234',
      teaser: 'Take this path, sucker.'
    },
    {
      destination: 'chapter345',
      teaser: 'You are making the right choice, dupe.'
    }
  ]
}

describe('bookshelf reducer', () => {
  it('loads story summary onto empty bookshelf', () => {
    const after = bookshelf(undefined, fetchStorySummaryResponse(testSummary));
    expect(after['story123']).toBeDefined();
    expect(after['story123'].summary).toEqual(testSummary);
  });

  it('loads chapter onto empty bookshelf', () => {
    const after = bookshelf(undefined,
      fetchChapterResponse(testSummary.storyKey, testChapter));
    expect(after['story123'].chapters[testChapter.id]).toBeDefined();
    expect(after['story123'].chapters[testChapter.id]).toEqual(testChapter);
  });

  it('loads summary and chapter', () => {
    const afterSummary = bookshelf(undefined,
      fetchStorySummaryResponse(testSummary));
    const afterChapter = bookshelf(afterSummary,
      fetchChapterResponse(testSummary.storyKey, testChapter));
    const expectedResult = {
      story123: {
        summary: testSummary,
        chapters: {
          chapter123: testChapter
        }
      }
    };
    expect(afterChapter).toEqual(expectedResult);
  });

  const testChapter2 = {
    id: 'chapter234',
    title: 'The End',
    prose: 'That choice was...unhealthy.',
    signpost: []
  };

  it('loads multiple chapters', () => {
    let after = bookshelf(undefined,
      fetchChapterResponse(testSummary.storyKey, testChapter));
    after = bookshelf(after,
      fetchChapterResponse(testSummary.storyKey, testChapter2));
    const chapters = after[testSummary.storyKey].chapters;
    expect(chapters['chapter123']).toBeDefined();
    expect(chapters['chapter123']).toEqual(testChapter);
    expect(chapters['chapter234']).toBeDefined();
    expect(chapters['chapter234']).toEqual(testChapter2);
  });

  it('loads multiple summaries', () => {
    const testSummaries = [
      testSummary,
      Object.assign({}, testSummary, { storyKey: 'blargy1' }),
      Object.assign({}, testSummary, { storyKey: 'blargy2' }),
      Object.assign({}, testSummary, { storyKey: 'blargy3' }),
    ];
    let after = bookshelf(undefined, fetchStorySummariesResponse(testSummaries));
    expect(after['story123']).toBeDefined();
    expect(after['blargy1']).toBeDefined();
    expect(after['blargy2']).toBeDefined();
    expect(after['blargy3']).toBeDefined();
  });
});
