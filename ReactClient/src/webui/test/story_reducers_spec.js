import { expect } from 'chai';
import { Map, List, fromJS } from 'immutable';
import { summary, chapter, draft, mapSummary, mapChapters, mapSignpost, loadStory } from '../app/reducers/story_reducers';
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
    const nextState = summary(undefined, { type: 'BLARBY_GARBY' });
    expect(nextState).to.equal(Map());
  });

  it('handles unknown action', () => {
    const nextState = summary(START_SUMMARY, { type: 'BLARBY_GARBY' });
    expect(nextState).to.equal(START_SUMMARY);
  });

  it('handles SET_TITLE', () => {
    const action = {type: 'SET_TITLE', title: 'My Wild Adventure'};
    const nextState = summary(START_SUMMARY, action);
    expect(nextState.get('title')).to.equal('My Wild Adventure');
  });

  it('handles SET_AUTHOR', () => {
    const action = {type: 'SET_AUTHOR', author: 'Mark Twain'};
    const nextState = summary(START_SUMMARY, action);
    expect(nextState.get('author')).to.equal('Mark Twain');
  });

  it('handles SET_TAG_LINE', () => {
    const action = {type: 'SET_TAG_LINE', tagLine: 'What troubles lie ahead.'};
    const nextState = summary(START_SUMMARY, action);
    expect(nextState.get('tagLine')).to.equal('What troubles lie ahead.');
  });

  it('handles SET_ABOUT', () => {
    const action = {type: 'SET_ABOUT', about: 'About this story...'};
    const nextState = summary(START_SUMMARY, action);
    expect(nextState.get('about')).to.equal('About this story...');
  });

});

describe('setting chapter details', () => {

  const START_CHAPTER = Map({
    id: 1000,
    heading: 'heading in',
    prose: 'prose in.'
  });

  it('return initial state when none given', () => {
    const nextState = chapter(undefined, { type: 'BLARBY_GARBY' });
    expect(nextState).to.equal(Map());
  });

  it('handles unknown action', () => {
    const nextState = chapter(START_CHAPTER, { type: 'BLARBY_GARBY' });
    expect(nextState).to.equal(START_CHAPTER);
  });

  it('handles SET_HEADING', () => {
    const action = {type: 'SET_HEADING', heading: 'A New Beginning'};
    const nextState = chapter(START_CHAPTER, action);
    expect(nextState.get('heading')).to.equal('A New Beginning');
    expect(nextState.get('id')).to.equal(START_CHAPTER.get('id'));
    expect(nextState.get('prose')).to.equal(START_CHAPTER.get('prose'));
  });

  it('handles SET_PROSE', () => {
    const action = {type: 'SET_PROSE', prose: 'It started out as any summer does.'};
    const nextState = chapter(START_CHAPTER, action);
    expect(nextState.get('prose')).to.equal('It started out as any summer does.');
    expect(nextState.get('id')).to.equal(START_CHAPTER.get('id'));
    expect(nextState.get('heading')).to.equal(START_CHAPTER.get('heading'));
  });

  it('handles ADD_SIGN', () => {
    const action = {type: 'ADD_SIGN', teaser: 'Next chapter'};
    const nextState = chapter(START_CHAPTER, action);
    expect(nextState.getIn(['signPost', 0, 'teaser'])).to.equal('Next chapter');
  });
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
