import { bookshelf } from './bookshelf';
import { fetchStorySummaryResponse } from '../actions';

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

it('loads single story correctly', () => {
  const after = bookshelf(undefined, fetchStorySummaryResponse(testSummary));
  expect(after['story123']).toBeDefined();
  expect(after['story123'].summary).toEqual(testSummary);
});

// it('loads multiple stories correctly', () => {
//   const first = bookshelf(undefined, fetchStorySummaryResponse(testSummary));
//   const anotherStory = Object.assign({}, testSummary, { storyKey: 'blargy' });
//   let next = bookshelf(first, fetchStorySummaryResponse(anotherStory));
//   expect(next[testSummary.storyKey]).toBeDefined();
//   expect(next[anotherStory.storyKey]).toBeDefined();
// })
//
// it('load a chapter correctly', () => {
//   const after = bookshelf(undefined, loadChapter('story456', testChapter));
// });
