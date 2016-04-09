import {List, Map} from 'immutable';

export function setStory(state, story) {

  return state;
}

function setSummary(state, summary) {

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
