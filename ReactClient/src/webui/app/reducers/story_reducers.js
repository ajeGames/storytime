import {Map, List} from 'immutable';

const INITIAL_STATE = Map();

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

export function loadStory(state = INITIAL_STATE, storyFromServer) {
  let stateOut = state.setIn(['story','summary'], mapSummary(storyFromServer.summary));
  stateOut = stateOut.setIn(['story','chapters'], mapChapters(storyFromServer.chapters));
  stateOut = stateOut.setIn(['story', 'signpost'], mapSignpost(storyFromServer.chapters));
  console.log('new state == ' + stateOut);
  return stateOut;
}

export function mapSummary(summary) {
  return Map({
    key: summary.key,
    title: summary.title,
    author: summary.author,
    tagLine: summary.tagLine,
    about: summary.about,
    firstChapter: summary.firstChapter.targetChapterId
  });
}

export function mapChapters(chapters) {
  let out = Map();
  chapters.forEach(function (chapter) {
    out = out.set(chapter.id.toString(), Map({
      heading: chapter.heading,
      prose: chapter.prose
    }));
  });
  return out;
}

export function mapSignpost(chapters) {
  let out = Map();
  let signs = List();
  chapters.forEach(function (chapter) {
    chapter.nextChapterOptions.forEach(function (option) {
      if (out.get(chapter.id.toString()) === undefined) {
        out = out.set(chapter.id.toString(), List());
      }
      signs = out.getIn(chapter.id.toString()).push(Map({
        chapterId: option.targetChapterId,
        teaser: option.teaser
      }));
      out = out.set(chapter.id.toString(), signs);
    });
  });
  return out;
}
