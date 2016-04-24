import { Map, List } from 'immutable';

export const loadStory = (storyFromServer) => {
  return Map({
    summary: mapSummary(storyFromServer.summary),
    chapters: mapChapters(storyFromServer.chapters)
  });
};

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
    if (chapter.nextChapterOptions && chapter.nextChapterOptions.length > 0) {
      out = out.setIn([chapter.id.toString(), "signPost"], mapSignpost(chapter.nextChapterOptions));
    }
  });
  return out;
}

function mapSignpost(options) {
  let signs = List();
  options.forEach((option) => {
    signs = signs.push(Map({
      chapterId: option.targetChapterId,
      teaser: option.teaser
    }));
  });
  return signs;
}
