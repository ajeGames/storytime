import { expect } from 'chai';
import { fromJS } from 'immutable';
import { mapStory, mapSummary, mapChapters } from '../app/reducers/backend_payload_converter';
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
      prose: "Prose 1",
      signPost: [
        {
          chapterId: 2,
          teaser: "Teaser 1-1"
        }, {
          chapterId: 3,
          teaser: "Teaser 1-2"
        }
      ]
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

  it('loads story correctly', () => {
    let transformed = mapStory(SAMPLE2);
    expect(transformed).to.be.ok;
    expect(transformed.get('summary')).to.equal(expectedSummaryMapping);
    expect(transformed.get('chapters')).to.equal(expectedChapterMapping);
  });
});
