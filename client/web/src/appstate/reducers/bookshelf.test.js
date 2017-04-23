import { bookshelf } from './bookshelf';
import { fetchStorySummaryResponse, fetchChapterResponse } from '../actions';

const testSummary = {
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

const testChapter = {
  id: 'uniquechapterkey2',
  title: 'Danger Lies Within',
  prose: 'blah blah blah',
  signpost: [
    {
      destination: 'uniquechapterkey3',
      teaser: 'Take this path, sucker.'
    },
    {
      destination: 'uniquechapterkey4',
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
          uniquechapterkey2: testChapter
        }
      }
    };
    console.log(JSON.stringify(afterChapter, null, 2));
    expect(afterChapter).toEqual(expectedResult);
  });
});
