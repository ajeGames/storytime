import { Map, List } from 'immutable';

const INITIAL_STATE = new Map();

export const summary = (state = INITIAL_STATE, action) => {
  switch (action.type) {
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

const addSign = (signPost = new List(), nextChapterId, teaser) => (
  signPost.push(new Map({ nextChapterId, teaser }))
);

export const chapter = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case 'SET_HEADING':
      return state.set('heading', action.heading);
    case 'SET_PROSE':
      return state.set('prose', action.prose);
    case 'ADD_SIGN':
      return state.set('signPost', addSign(state.get('signPost'), action.nextChapterId,
        action.teaser));
    default:
      return state;
  }
};

export const draft = (state = INITIAL_STATE, action) => (
  new Map({
    summary: summary(state.get('summary'), action),
    chapter: chapter(state.get('chapter'), action),
  })
);
