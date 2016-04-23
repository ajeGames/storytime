import { expect } from 'chai';
import { Map, List, fromJS } from 'immutable';
import { summary, chapter, draft } from '../app/reducers/story_reducers';

describe('summary details', () => {

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

describe('chapter details', () => {

  const START_CHAPTER = Map({
    id: 1000,
    heading: 'heading in',
    prose: 'prose in'
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
    let action = {type: 'ADD_SIGN', nextChapterId: 1001, teaser: 'Next chapter'};
    let nextState = chapter(START_CHAPTER, action);
    expect(nextState.getIn(['signPost', 0, 'nextChapterId'])).to.equal(1001);
    expect(nextState.getIn(['signPost', 0, 'teaser'])).to.equal('Next chapter');

    action = {type: 'ADD_SIGN', nextChapterId: 1002, teaser: 'Another choice'};
    nextState = chapter(nextState, action);
    expect(nextState.getIn(['signPost', 1, 'nextChapterId'])).to.equal(1002);
    expect(nextState.getIn(['signPost', 1, 'teaser'])).to.equal('Another choice');
  });


});
