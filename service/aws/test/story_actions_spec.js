import { expect } from 'chai';
import { createStory, getStory } from '../src/story_actions';

const SAMPLE_STORY = {
  title: 'Blargy',
  author: 'Bubba Gump',
  tagLine: 'Read it now.',
  about: 'This is amazing!!!',
};

describe('CRUD operations for stories', () => {
  it('Retrieves a story from persistence', () => {
    const story = createStory(SAMPLE_STORY);
    const storyReturned = getStory(story.storyID);
    expect(storyReturned).to.exist;
  });
});
