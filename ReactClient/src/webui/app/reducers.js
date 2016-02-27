import {Map} from 'immutable';

const INITIAL_STATE = Map();

export default function reducer(state = INITIAL_STATE, action) {
  switch (action.type) {
    case 'SET_TITLE':
      return setTitle(state, action.title);
    case 'SET_AUTHOR':
      return setAuthor(state, action.author);
    case 'SET_TAG_LINE':
      return setTagLine(state, action.tagLine);
    case 'SET_ABOUT':
      return setAbout(state, action.about);
  }
  return state;
}

export function setTitle(state, title) {
  return state.set('title', title);
}

export function setAuthor(state, author) {
  return state.set('author', author);
}

export function setTagLine(state, tagLine) {
  return state.set('tagLine', tagLine);
}

export function setAbout(state, about) {
  return state.set('about', about);
}
