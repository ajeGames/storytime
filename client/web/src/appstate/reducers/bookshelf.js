import * as actions from '../actions';

const summary = (state = {}, action) => {
  switch (action.type) {
    case actions.FETCH_STORY_SUMMARY_RESPONSE:
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
    case actions.FETCH_CHAPTER_RESPONSE:
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

export const bookshelf = (state = {}, action) => {
  console.log(action);
  switch (action.type) {
    case actions.FETCH_STORY_SUMMARY_RESPONSE:
      return {
        ...state,
        [action.storyKey]: summary(state[action.storyKey], action)
      };
    case actions.FETCH_CHAPTER_RESPONSE:
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
