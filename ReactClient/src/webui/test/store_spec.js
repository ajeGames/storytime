/* global define, it, describe */
import { expect } from 'chai';
import { store } from '../app/store';

describe('redux store', () => {
  it('is a functioning store with callback enabled', () => {
    let callback = false;
    store.subscribe(() => {
      callback = true;
    });
    expect(callback).to.equal(false);
    store.dispatch({ type: 'BUGGA_BOO' });
    expect(callback).to.equal(true);
  });
});
