/* global define, it, describe */
import { expect } from 'chai';
import { catalog, INITIAL_CATALOG_STATE } from '../app/reducers/storytime_reducer';
import { fetchCatalog, fetchCatalogErr, loadCatalog } from '../app/actions/story_actions';

const DEMO_STORIES = [
  {
    key: '11111111',
    title: 'Story 1',
    author: 'Bubba Gump 1',
    tagLine: 'Read me 1',
    about: 'About 1',
    firstChapter: 1,
  },
  {
    key: '22222222',
    title: 'Story 2',
    author: 'Bubba Gump 2',
    tagLine: 'Read me 2',
    about: 'About 2',
    firstChapter: 1000,
  },
  {
    key: '33333333',
    title: 'Story 3',
    author: 'Bubba Gump 3',
    tagLine: 'Read me 3',
    about: 'About 3',
    firstChapter: 10000,
  },
];

describe('storytime reducer', () => {
  it('returns initial state given none', () => {
    const stateOut = catalog(undefined, { type: 'BLARGY' });
    expect(stateOut).to.equal(INITIAL_CATALOG_STATE);
  });

  it('changes indicator when fetching', () => {
    const stateOut = catalog(undefined, fetchCatalog());
    expect(stateOut.isFetching).to.equal(true);
  });

  it('changes indicator when fetching', () => {
    const stateOut1 = catalog(undefined, fetchCatalog());
    const stateOut2 = catalog(stateOut1, fetchCatalogErr('boom'));
    expect(stateOut2.error.message).to.equal('boom');
    expect(stateOut2.isFetching).to.equal(false);
    expect(stateOut1).is.not.equal(stateOut2);
  });

  it('loads story summaries', () => {
    const stateOut1 = catalog(undefined, fetchCatalog());
    expect(stateOut1.isFetching).to.equal(true);
    const stateOut2 = catalog(stateOut1, loadCatalog(DEMO_STORIES));
    expect(stateOut2.isFetching).to.equal(false);
    expect(stateOut2.stories[1].author).is.equal('Bubba Gump 2');
  });
});
