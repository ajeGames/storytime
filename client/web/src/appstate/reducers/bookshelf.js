import { LOAD_STORY_SUMMARY, LOAD_CHAPTER } from '../actions';

const summary = (state = {}, action) => {
  switch (action.type) {
    case LOAD_STORY_SUMMARY:
      const story = action.payload;
      return {
        storyKey: story.storyKey,
        title: story.title,
        author: {
          id: story.author.id,
          penName: story.author.penName
        },
        tagLine: story.tagLine,
        about: story.about,
        firstChapter: story.firstChapter
      };
    default:
      return state;
  }
}

const chapter = (state = {}, action) => {
  switch (action.type) {
    case LOAD_CHAPTER:
      const chapter = action.payload;
      const mySignpost = (chapter.signpost)
        ? chapter.signpost.map(sign => {
          return {
            destination: sign.destination,
            teaser: sign.teaser
          }
        })
        : [];
      return {
        id: chapter.id,
        title: chapter.title,
        prose: chapter.prose,
        signpost: mySignpost
      };
    default:
      return state;
  }
}

export const story = {
  summary,
  chapters: {
    // ...chaptersById
  }
};

export const bookshelf = (state = {}, action) => {
  switch (action.type) {
    case LOAD_STORY_SUMMARY:
      const storySummary = summary(undefined, action);
      let node = {};
      node[storySummary.storyKey] = {
        summary: storySummary
      }
      return Object.assign({}, state, node);
    case LOAD_CHAPTER:
      // const storyKey = action.payload.storyKey;
      // const chapter = action.payload.chapter;
      // return Object.assign({}, state, {
      //   state[storyKey]: {
      //     chapters: prepChapterForStorage(chapter)
      //   }
      // });
      return state;
    default:
      return state;
  }
}

export default bookshelf;
