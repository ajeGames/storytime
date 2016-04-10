import {Map, List} from 'immutable';
import StoryReducers from './story_reducers';

export function loadStory(state, storyFromServer) {
  return state.set('storySummary', mapSummary(storyFromServer.summary))
      .set('chapters', List.of())
      .set('signpost', List.of());
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
