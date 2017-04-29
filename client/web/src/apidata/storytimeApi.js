import fetch from 'isomorphic-fetch';
import storytimeServerEndpoint from '../env';
import storySummaries from './storySummaries';

const testing = true;

const simFetchStorySummaries = new Promise(
  (resolve, reject) => {
    console.log('simulate server request for story summaries');
    window.setTimeout(
      () => {
        resolve(storySummaries);
      }, 1000);
  }
);

const simFetchStorySummary = new Promise(
  (resolve, reject) => {
    console.log('simulate server request for story summaries');
    window.setTimeout(
      () => {
        resolve(storySummaries[0]);
      }, 1000);
  }
);

export function fetchStorySummaries() {
  if (testing) {
    return simFetchStorySummaries();
  }
  return fetch(`{ storytimeServerEndpoint }/stories/summaries`);
}

export function fetchStory(storyKey) {
  if (testing) {
    return simFetchStorySummary();
  }
  return fetch(`${ storytimeServerEndpoint }/stories/${ storyKey }`);
}

export function fetchChapter(storyKey, chapterId) {
  return fetch(`${ storytimeServerEndpoint }/stories/${ storyKey }/chapters/${ chapterId }`);
}
