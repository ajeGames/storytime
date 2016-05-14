import { Map, List } from 'immutable';

export function mapSummary(summary) {
  return new Map({
    key: summary.key,
    title: summary.title,
    author: summary.author,
    tagLine: summary.tagLine,
    about: summary.about,
    firstChapter: summary.firstChapter.targetChapterId,
  });
}

function mapSignpost(options) {
  let signs = new List();
  options.forEach(option => {
    signs = signs.push(new Map({
      chapterId: option.targetChapterId,
      teaser: option.teaser,
    }));
  });
  return signs;
}

export function mapChapters(chapters) {
  let out = new Map();
  chapters.forEach(chapter => {
    out = out.set(chapter.id.toString(), new Map({
      heading: chapter.heading,
      prose: chapter.prose,
    }));
    if (chapter.nextChapterOptions && chapter.nextChapterOptions.length > 0) {
      out = out.setIn([chapter.id.toString(), 'signPost'], mapSignpost(chapter.nextChapterOptions));
    }
  });
  return out;
}

export function mapStory(storyFromServer) {
  return new Map({
    summary: mapSummary(storyFromServer.summary),
    chapters: mapChapters(storyFromServer.chapters),
    openChapter: storyFromServer.summary.firstChapter,
  });
}
