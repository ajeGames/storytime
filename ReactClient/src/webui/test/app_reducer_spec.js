import { expect } from 'chai';
import { fromJS } from 'immutable';
import { reduce } from '../app/reducers/app_reducer';
import { SAMPLE2 } from './SampleData';

describe('app reducer', () => {

  it('loads story from server', () => {
    const action = { type: 'LOAD_STORY', story: SAMPLE2 };
    const nextState = reduce(undefined, action);
    expect(nextState).to.be.ok;
  });

  it('clears draft only on load', () => {
    const init = fromJS({
      user: {
        name: 'Bubba'
      },
      story: {},
      draft: {
        summary: {
          title: 'Bah'
        }
      },
      stats: {
        visits: 42
      }
    });
    const action = { type: 'LOAD_STORY', story: SAMPLE2 };
    const nextState = reduce(init, action);
    expect(nextState.get('draft')).to.equal(undefined);
    expect(nextState.getIn(['story', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['user', 'name'])).to.equal('Bubba');
    expect(nextState.getIn(['stats', 'visits'])).to.equal(42);
  });

  it('places story in edit mode', () => {
    let action = { type: 'LOAD_STORY', story: SAMPLE2 };
    let nextState = reduce(undefined, action);
    nextState = reduce(nextState, { type: 'EDIT_SUMMARY' });
    expect(nextState.getIn(['draft', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['draft', 'summary'])).to.equal(nextState.getIn(['story', 'summary']));
  });
});