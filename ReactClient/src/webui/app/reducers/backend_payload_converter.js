import { Map, List } from 'immutable';

const INITIAL_STATE = Map();

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
