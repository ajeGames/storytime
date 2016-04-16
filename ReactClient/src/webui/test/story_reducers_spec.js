import { expect } from 'chai';
import { Map, List, fromJS } from 'immutable';
import { mapSummary, mapChapters, mapSignpost, loadStory } from '../app/reducers/story_reducers';
import { SAMPLE2 } from './SampleData';

describe('mappers to convert story from server payload to internal state', () => {

  const expectedSummaryMapping = fromJS({
    key: "ABCD1234",
    title: "Title",
    author: "Author",
    tagLine: "Tag Line",
    about: "About",
    firstChapter: 1
  });

  const expectedChapterMapping = fromJS({
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
  });

  const expectedSignpostMapping = fromJS({
    1: [
      {
        chapterId: 2,
        teaser: "Teaser 1-1"
      }, {
        chapterId: 3,
        teaser: "Teaser 1-2"
      }
    ]
  });

  it('maps summary correctly', () => {
    let transformed = mapSummary(SAMPLE2.summary);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(expectedSummaryMapping);
  });

  it('maps chapters correctly', () => {
    let transformed = mapChapters(SAMPLE2.chapters);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(expectedChapterMapping);
  });

  it('creates signpost correctly', () => {
    let transformed = mapSignpost(SAMPLE2.chapters);
    expect(transformed).to.be.ok;
    expect(transformed).to.equal(expectedSignpostMapping);
  });

  it('loads story correctly', () => {
    let transformed = loadStory(undefined, SAMPLE2);
    expect(transformed).to.be.ok;
    console.log(transformed);
    expect(transformed.get('storySummary')).to.equal(expectedSummaryMapping);
    expect(transformed.get('chapters')).to.equal(expectedChapterMapping);
    expect(transformed.get('signpost')).to.equal(expectedSignpostMapping);
  });
});
