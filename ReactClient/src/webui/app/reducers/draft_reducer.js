import { Map, List } from 'immutable';

const INITIAL_STATE = Map();

export const draft = (state = INITIAL_STATE, action) => {
  return Map({
    summary: summary(state.get('summary'), action),
    chapter: chapter(state.get('chapter'), action)
  });
};

export const summary = (state = INITIAL_STATE, action) => {
  switch(action.type) {
    case 'SET_TITLE':
      return state.set('title', action.title);
    case 'SET_AUTHOR':
      return state.set('author', action.author);
    case 'SET_TAG_LINE':
      return state.set('tagLine', action.tagLine);
    case 'SET_ABOUT':
      return state.set('about', action.about);
    default:
      return state;
  }
};

export const chapter = (state = INITIAL_STATE, action) => {
  switch(action.type) {
    case 'SET_HEADING':
      return state.set('heading', action.heading);
    case 'SET_PROSE':
      return state.set('prose', action.prose);
    case 'ADD_SIGN':
      return state.set('signPost', addSign(state.get('signPost'), action.nextChapterId, action.teaser));
    default:
      return state;
  }
};

const addSign = (signPost = List(), nextChapterId, teaser) => {
  return signPost.push(Map({nextChapterId: nextChapterId, teaser: teaser}));
};
