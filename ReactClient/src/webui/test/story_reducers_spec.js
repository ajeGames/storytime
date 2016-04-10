import {expect} from 'chai';
import {mapSummary} from '../app/reducers/story_reducers';

describe('story mappers to convert from server payload to internal state', () => {

  it('map summary', () => {
    const story = {
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
      }
    };
    let transformed = mapSummary(story.summary);
    expect(transformed).to.be.ok;
    expect(transformed.get('key')).to.equal('ABCD1234');
  });

});
