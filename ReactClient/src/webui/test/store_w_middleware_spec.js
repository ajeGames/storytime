/* global define, it, describe */
import { expect } from 'chai';
import { configureStore } from '../app/configure_store';

describe('store with middleware', () => {
  it('functions as expected', () => {
    const store = configureStore(undefined);
    expect(store.getState()).is.notnull;
    expect(store.getState().catalog.isFetching).equals(false);
  });
});
