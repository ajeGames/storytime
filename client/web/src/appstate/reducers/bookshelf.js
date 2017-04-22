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

const story = (state = {}, action) => {
  switch (action.type) {
    case actions.FETCH_STORY_SUMMARY_RESPONSE:
      return {
        ...state,
        summary: summary(state.summary, action)
      };
    case action.FETCH_CHAPTER_RESPONSE:
      const chapterId = action.payload.chapter.chapterId;
      return {
        ...state,
        chapters: {
          [chapterId]: chapter(state.chapters[action.chapterId], action.chapter)
        }
      };
    default:
      return state;
  }
}

export const bookshelf = (state = {}, action) => {
  console.log(action);
  switch (action.type) {
    case actions.FETCH_STORY_SUMMARY_RESPONSE:
    case actions.FETCH_CHAPTER_RESPONSE:
      const storyKey = action.payload.storyKey;
      return {
        ...state,
        [storyKey]: story(state[storyKey], action)
      };
    default:
      return state;
  }
}

export default bookshelf;
