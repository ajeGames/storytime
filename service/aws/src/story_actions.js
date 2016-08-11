import { addStory } from './dynamodb/StoriesTable';

// create story
export function createStory(storySummary) {
  const result = addStory(storySummary);
  return result;
}

// get story
export function getStory() {
  return {};
}

// update story
