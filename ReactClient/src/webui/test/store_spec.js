import { Map, fromJS } from 'immutable';
import { expect } from 'chai';

import { store } from '../app/store';

describe('redux store', () => {

  let callback = false;

  // make sure setup is correct
  store.subscribe(() => {
    //console.log(store.getState());
    callback = true;
  });

  it('is a functioning Redux store with empty default state', () => {
    store.dispatch({type: 'BUGGA_BOO'});  // try with action that does not exist to get default state
    expect(callback).to.equal(true);
    expect(store.getState()).to.equal(fromJS({summary: {}, chapter: {}}));
  });

  it('allows independent updates to different parts of store', () => {
    store.dispatch({type: 'SET_TITLE', title: 'Zero to One'});
    store.dispatch({type: 'SET_PROSE', prose: 'It was another long day at the ranch.'});
    expect(store.getState().getIn(['summary', 'title'])).to.equal('Zero to One');
    expect(store.getState().getIn(['chapter', 'prose'])).to.equal('It was another long day at the ranch.');
  });

});
