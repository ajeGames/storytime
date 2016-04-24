import { expect } from 'chai';
import { reduce } from '../app/reducers/app_reducer';
import { SAMPLE2 } from './SampleData';

describe('app reducer', () => {

  it('loads story from server', () => {
    const action = { type: 'LOAD_STORY', story: SAMPLE2 };
    const nextState = reduce(undefined, action);
    expect(nextState).to.be.ok;
  });
});