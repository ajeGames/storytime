import {Map, fromJS} from 'immutable';
import {expect} from 'chai';

import makeStore from '../app/store';

describe('store', () => {

  it('is a Redux store configured with the correct reducer', () => {
    const store = makeStore();
    expect(store.getState()).to.equal(Map());

    store.dispatch({
      type: 'SET_TITLE',
      title: 'Around the World in 80 Days'
    });
    expect(store.getState()).to.equal(fromJS({
      title: 'Around the World in 80 Days'
    }))
  });

});
