import { loadStorySummary, LOAD_STORY_SUMMARY } from '../index.js';

it('creates loadStorySummary with correct payload', () => {
  const action = loadStorySummary({ message: 'golden', title: 'Dune' });
  console.log(action);
  expect(action.type).toEqual(LOAD_STORY_SUMMARY);
  expect(action.payload.message).toEqual('golden');
});
