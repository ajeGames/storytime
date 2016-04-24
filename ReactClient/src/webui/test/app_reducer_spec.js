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
    expect(nextState.get('draft')).to.be.undefined;
    expect(nextState.getIn(['story', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['user', 'name'])).to.equal('Bubba');
    expect(nextState.getIn(['stats', 'visits'])).to.equal(42);
  });

  const loadSampleStory = () => {
    return reduce(undefined, { type: 'LOAD_STORY', story: SAMPLE2 });
  };

  it('places story in edit mode', () => {
    const initState = loadSampleStory();
    const nextState = reduce(initState, { type: 'EDIT_SUMMARY' });
    expect(nextState.getIn(['draft', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['draft', 'summary'])).to.equal(nextState.getIn(['story', 'summary']));
  });

  it('places chapter in edit mode', () => {
    const initState = loadSampleStory();
    const chapterIdToEdit = 1;  // TODO initState.getIn(['story', 'chapters', 0, 'id']);
    console.log('chapter to edit: ' + initState.getIn(['story', 'chapters', '1']));
    const action = {
      type: 'EDIT_CHAPTER',
      chapterId: chapterIdToEdit
    };
    const nextState = reduce(initState, action);
    expect(nextState).is.not.undefined;
    expect(nextState.getIn(['draft', 'chapter'])).is.not.undefined;
    expect(nextState.getIn(['draft', 'chapter'])).to.equal(nextState.getIn(['story', 'chapters', '1']));
  })
});