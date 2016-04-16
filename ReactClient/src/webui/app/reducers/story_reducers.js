import {Map, List} from 'immutable';
import StoryReducers from './story_reducers';

const INITIAL_STATE = Map();

export function loadStory(state = INITIAL_STATE, storyFromServer) {
  console.log('from server: ' + storyFromServer);
  let story = state.merge('story', {});
  return state.setIn(['story','summary'], mapSummary(storyFromServer.summary))
      .setIn(['story','chapters'], mapChapters(storyFromServer.chapters))
      .setIn(['story', 'signpost'], mapSignpost(storyFromServer.chapters));
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
