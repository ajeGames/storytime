import {expect} from 'chai';
import {List, Map, fromJS} from 'immutable';

import reducer from '../app/reducers/reducers';

describe('storytime reducer', () => {

  it('has an initial state', () => {
    const action = {type: 'SET_TITLE', title: 'LOST'};
    const nextState = reducer(undefined, action);
    expect(nextState).to.equal(fromJS({
      title: 'LOST'
    }));
  });

  it('handles SET_TITLE', () => {
    const initialState = Map();
    const action = {type: 'SET_TITLE', title: 'My Wild Adventure'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      title: 'My Wild Adventure'
    }));
  });

  it('handles SET_AUTHOR', () => {
    const initialState = Map();
    const action = {type: 'SET_AUTHOR', author: 'Mark Twain'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      author: 'Mark Twain'
    }));
  });

  it('handles SET_TAG_LINE', () => {
    const initialState = Map();
    const action = {type: 'SET_TAG_LINE', tagLine: 'What troubles lie ahead.'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      tagLine: 'What troubles lie ahead.'
    }));
  });

  it('handles SET_ABOUT', () => {
    const initialState = Map();
    const action = {type: 'SET_ABOUT', about: 'About this story...'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      about: 'About this story...'
    }));
  });

});
