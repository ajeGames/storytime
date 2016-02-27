import {expect} from 'chai';
import {List, Map} from 'immutable';

import {setTitle, setAuthor, setTagLine, setAbout} from '../app/reducers';

describe('reducer logic', () => {

  describe('setTitle', () => {
    it('sets title', () => {
      const state = Map();
      const title = 'The Cave';
      const nextState = setTitle(state, title);
      expect(nextState.get('title')).to.equal(title);
    });
  });

  describe('setAuthor', () => {
    it('sets author', () => {
      const state = Map();
      const author = 'Bubba Gump';
      const nextState = setAuthor(state, author);
      expect(nextState.get('author')).to.equal(author);
    });
  });

  describe('setTagLine', () => {
    it('sets tag line', () => {
      const state = Map();
      const tagLine = 'It\'s dark in there';
      const nextState = setTagLine(state, tagLine);
      expect(nextState.get('tagLine')).to.equal(tagLine);
    });
  });

  describe('setAbout', () => {
    it('sets about', () => {
      const state = Map();
      const about = 'The Cave';
      const nextState = setAbout(state, about);
      expect(nextState.get('about')).to.equal(about);
    });
  });

});
