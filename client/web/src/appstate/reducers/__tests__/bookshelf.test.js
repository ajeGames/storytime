import bookshelf from '../bookshelf';
import { loadStorySummary } from '../../actions';

it('loads story correctly', () => {
  const testSummary = {
    storyKey: '123',
    title: 'hello world',
    author: 'bubba gump'
  }
  const after = bookshelf(undefined, loadStorySummary(testSummary));
  console.log(after);
  expect(after['123'].summary.title).toEqual(testSummary.title);
});
