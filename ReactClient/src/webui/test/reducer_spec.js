import { expect } from 'chai';
import { fromJS } from 'immutable';
import { reducer } from '../app/reducers/reducer';
import { SAMPLE2 } from './SampleData';

describe('reducer', () => {

  it('loads story from server', () => {
    const action = {type: 'LOAD_STORY', story: SAMPLE2};
    const nextState = reducer(undefined, action);
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
    const action = {type: 'LOAD_STORY', story: SAMPLE2};
    const nextState = reducer(init, action);
    expect(nextState.get('draft')).to.be.undefined;
    expect(nextState.getIn(['story', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['user', 'name'])).to.equal('Bubba');
    expect(nextState.getIn(['stats', 'visits'])).to.equal(42);
  });

  const loadSampleStory = () => {
    return reducer(undefined, {type: 'LOAD_STORY', story: SAMPLE2});
  };

  it('places story in edit mode', () => {
    const initState = loadSampleStory();
    const nextState = reducer(initState, {type: 'EDIT_SUMMARY'});
    expect(nextState.getIn(['draft', 'summary', 'title'])).to.equal(SAMPLE2.summary.title);
    expect(nextState.getIn(['draft', 'summary'])).to.equal(nextState.getIn(['story', 'summary']));
  });

  it('places chapter in edit mode', () => {
    const initState = loadSampleStory();
    const chapterIdToEdit = 1;
    const action = {
      type: 'EDIT_CHAPTER',
      chapterId: chapterIdToEdit
    };
    const nextState = reducer(initState, action);
    expect(nextState).is.not.undefined;
    expect(nextState.getIn(['draft', 'chapter'])).is.not.undefined;
    expect(nextState.getIn(['draft', 'chapter'])).to.equal(nextState.getIn(['story', 'chapters', '1']));
  });

  it('understands draft edits', () => {
    const draftValues = {
      summary: {
        title: 'Deep Blue Sea',
        author: 'Captain Nemo',
        tagLine: "It doesn't get deeper",
        about: 'Read this if you like adventure.'
      },
      chapter: {
        heading: 'Launch',
        prose: 'Ooop, forgot the corkscrew again.'
      }
    };
    let nextState = reducer(undefined, {type: 'SET_TITLE', title: draftValues.summary.title});
    nextState = reducer(nextState, {type: 'SET_AUTHOR', author: draftValues.summary.author});
    nextState = reducer(nextState, {type: 'SET_TAG_LINE', tagLine: draftValues.summary.tagLine});
    nextState = reducer(nextState, {type: 'SET_ABOUT', about: draftValues.summary.about});
    nextState = reducer(nextState, {type: 'SET_HEADING', heading: draftValues.chapter.heading});
    nextState = reducer(nextState, {type: 'SET_PROSE', prose: draftValues.chapter.prose});
    expect(nextState.get('draft')).to.equal(fromJS(draftValues));

    nextState = reducer(nextState, {type: 'ADD_SIGN', nextChapterId: 42, teaser: 'Hello, World!'});
    expect(nextState.getIn(['draft', 'chapter', 'signPost', 0, 'teaser'])).to.equal('Hello, World!');
  });

});