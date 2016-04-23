import { expect } from 'chai';
import { Map, List, fromJS } from 'immutable';
import { summary, mapSummary, mapChapters, mapSignpost, loadStory } from '../app/reducers/story_reducers';
import { SAMPLE2 } from './SampleData';

describe('setting summary details', () => {

  const START_SUMMARY = Map({
    key: 'BLARGY',
    title: 'title in',
    author: 'author in',
    tagLine: 'tag line in',
    about: 'about in'
  });

  it('returns initial state when none given', () => {
    const nextState = summary(undefined, { type: "BLARBY_GARBY" });
    expect(nextState).to.equal(Map());
  });

  it('handles unknown action', () => {
    const nextState = summary(START_SUMMARY, { type: "BLARBY_GARBY" });
    expect(nextState).to.equal(START_SUMMARY);
  });

  it('handles SET_TITLE', () => {
    const action = {type: 'SET_TITLE', title: 'My Wild Adventure'};
    const nextState = summary(START_SUMMARY, action);
    expect(nextState.get('title')).to.equal('My Wild Adventure');
  });

  //it('handles SET_AUTHOR', () => {
  //  const initialState = Map();
  //  const action = {type: 'SET_AUTHOR', author: 'Mark Twain'};
  //  const nextState = reducer(initialState, action);
  //
  //  expect(nextState).to.equal(fromJS({
  //    author: 'Mark Twain'
  //  }));
  //});
  //
  //it('handles SET_TAG_LINE', () => {
  //  const initialState = Map();
  //  const action = {type: 'SET_TAG_LINE', tagLine: 'What troubles lie ahead.'};
  //  const nextState = reducer(initialState, action);
  //
  //  expect(nextState).to.equal(fromJS({
  //    tagLine: 'What troubles lie ahead.'
  //  }));
  //});
  //
  //it('handles SET_ABOUT', () => {
  //  const initialState = Map();
  //  const action = {type: 'SET_ABOUT', about: 'About this story...'};
  //  const nextState = reducer(initialState, action);
  //
  //  expect(nextState).to.equal(fromJS({
  //    about: 'About this story...'
  //  }));
  //});

});

//describe('mappers to convert story from server payload to internal state', () => {
//
//  const expectedSummaryMapping = fromJS({
//    key: "ABCD1234",
//    title: "Title",
//    author: "Author",
//    tagLine: "Tag Line",
//    about: "About",
//    firstChapter: 1
//  });
//
//  const expectedChapterMapping = fromJS({
//    1: {
//      heading: "Heading 1",
//      prose: "Prose 1"
//    },
//    2: {
//      heading: "Heading 2",
//      prose: "Prose 2"
//    },
//    3: {
//      heading: "Heading 3",
//      prose: "Prose 3"
//    }
//  });
//
//  const expectedSignpostMapping = fromJS({
//    1: [
//      {
//        chapterId: 2,
//        teaser: "Teaser 1-1"
//      }, {
//        chapterId: 3,
//        teaser: "Teaser 1-2"
//      }
//    ]
//  });
//
//  it('maps summary correctly', () => {
//    let transformed = mapSummary(SAMPLE2.summary);
//    expect(transformed).to.be.ok;
//    expect(transformed).to.equal(expectedSummaryMapping);
//  });
//
//  it('maps chapters correctly', () => {
//    let transformed = mapChapters(SAMPLE2.chapters);
//    expect(transformed).to.be.ok;
//    expect(transformed).to.equal(expectedChapterMapping);
//  });
//
//  it('creates signpost correctly', () => {
//    let transformed = mapSignpost(SAMPLE2.chapters);
//    expect(transformed).to.be.ok;
//    expect(transformed).to.equal(expectedSignpostMapping);
//  });
//
//  it('loads story correctly', () => {
//    let transformed = loadStory(undefined, SAMPLE2);
//    expect(transformed).to.be.ok;
//    console.log(transformed);
//    expect(transformed.getIn(['story', 'summary'])).to.equal(expectedSummaryMapping);
//    expect(transformed.getIn(['story', 'chapters'])).to.equal(expectedChapterMapping);
//    expect(transformed.getIn(['story', 'signpost'])).to.equal(expectedSignpostMapping);
//  });
//});
