import {expect} from 'chai';
import {Map, List, fromJS} from 'immutable';
import {mapSummary, mapChapters, mapSignpost} from '../app/reducers/story_reducers';

describe('mappers to convert story from server payload to internal state', () => {

  const STORY_IN_SERVER_FORMAT = {
    summary: {
      key: "ABCD1234",
      title: "Title",
      author: "Author",
      tagLine: "Tag Line",
      about: "About",
      firstChapter: {
        targetChapterId: 1,
        teaser: "Teaser"
      }
    },
    chapters: [
      {
        id: 1,
        heading: "Heading 1",
        prose: "Prose 1",
        nextChapterOptions: [
          {
            targetChapterId: 2,
            teaser: "Teaser 1-1"
          }, {
            targetChapterId: 3,
            teaser: "Teaser 1-2"
          }
        ]
      }, {
        id: 2,
        heading: "Heading 2",
        prose: "Prose 2",
        nextChapterOptions: []
      }, {
        id: 3,
        heading: "Heading 3",
        prose: "Prose 3",
        nextChapterOptions: []
      }
    ]
  };

  const expectedStoryMapping = Map({
    key: "ABCD1234",
    title: "Title",
    author: "Author",
    tagLine: "Tag Line",
    about: "About",
    firstChapter: 1
  });

  const expectedChapterMapping = {
    1: {
      heading: "Heading 1",
      prose: "Prose 1"
    },
    2: {
      heading: "Heading 2",
      prose: "Prose 2"
    },
    3: {
      heading: "Heading 3",
      prose: "Prose 3"
    }
  };

  const expectedSignpostMapping = fromJS({
        1000: [
          {
            chapterId: 2,
            teaser: "Teaser 1-1"
          }, {
            chapterId: 3,
            teaser: "Teaser 1-2"
          }
        ]
      }
  );

  it('maps summary correctly', () => {
    let transformed = mapSummary(STORY_IN_SERVER_FORMAT.summary);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(expectedStoryMapping);
  });

  it('maps chapters correctly', () => {
    let transformed = mapChapters(STORY_IN_SERVER_FORMAT.chapters);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(fromJS(expectedChapterMapping));
  });

  it('creates signpost correctly', () => {
    let transformed = mapSignpost(STORY_IN_SERVER_FORMAT.chapters);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(expectedSignpostMapping);
  });

  it('loads story correctly', () => {
    const expectedStory = fromJS()
  });
});
