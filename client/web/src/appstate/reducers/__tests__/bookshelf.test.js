import { bookshelf } from '../bookshelf';
import { loadStorySummary } from '../../actions';

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

// const testChapter = {
//   chapterId: 'chapter123',
//   title: 'Danger Lies Within',
//   prose: 'blah blah blah blah blah blah with some kind of handlebars for styling, image placement, etc.',
//   signpost: [
//     {
//       destination: 'uniquechapterkey3',
//       teaser: 'Take this path, sucker.'
//     },
//     {
//       destination: 'uniquechapterkey4',
//       teaser: 'You are making the right choice, dupe.'
//     }
//   ]
// }

it('loads single story correctly', () => {
  const after = bookshelf(undefined, loadStorySummary(testSummary));
  expect(after['story123']).toBeDefined();
  expect(after['story123'].summary).toEqual(testSummary);
});

it('loads multiple stories correctly', () => {
  const first = bookshelf(undefined, loadStorySummary(testSummary));
  const anotherStory = Object.assign({}, testSummary, { storyKey: 'blargy' });
  let next = bookshelf(first, loadStorySummary(anotherStory));
  expect(next[testSummary.storyKey]).toBeDefined();
  expect(next[anotherStory.storyKey]).toBeDefined();
})
//
// it('load a chapter correctly', () => {
//   const after = bookshelf(undefined, loadChapter('story456', testChapter));
// });
