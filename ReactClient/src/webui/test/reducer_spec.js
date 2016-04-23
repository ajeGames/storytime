//import {expect} from 'chai';
//import {List, Map, fromJS} from 'immutable';
//
//import reducer from '../app/reducers/reducers';
//
//describe('storytime reducer', () => {
//
//  it('has an initial state', () => {
//    const action = {type: 'SET_TITLE', title: 'LOST'};
//    const nextState = reducer(undefined, action);
//    expect(nextState).to.equal(fromJS({
//      title: 'LOST'
//    }));
//  });
//
//  it('has unknown action', () => {
//    const action = { type: 'UNKNOWN' };
//    const state = Map({bubba: 'hello'});
//    const nextState = reducer(state, action);
//    expect(nextState).to.equal(fromJS(state));
//  });
//
//});
