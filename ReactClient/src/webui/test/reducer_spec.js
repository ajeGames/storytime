import {expect} from 'chai';
import {List, Map, fromJS} from 'immutable';

import reducer from '../app/reducers/reducers';

describe('storytime reducer', () => {

  it('has an initial state', () => {
    const action = {type: 'SET_TITLE', title: 'LOST'};
    const nextState = reducer(undefined, action);
    expect(nextState).to.equal(fromJS({
      title: 'LOST'
    }));
  });

  it('can load story from server', () => {
    const initialState = Map();
    const action = {
      type: 'LOAD_STORY',
      story: {
        summary: {
          key: "Key",
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
                teaser: "Chapter 2"
              },
              {
                targetChapterId: 3,
                teaser: "Chapter 3"
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
      }
    };
    const nextState = reducer(initialState, action);
    expect(nextState).to.equal(fromJS({
      storySummary: {
        key: "Key",
        title: "Title",
        author: "Author",
        tagLine: "Tag Line",
        about: "About",
        firstChapter: 1
      },
      chapters: [],
      signpost: []
      //chapters: [
      //  {
      //    1: {
      //      heading: "Heading 1",
      //      prose: "Prose 1"
      //    }
      //  }, {
      //    2: {
      //      heading: "Heading 2",
      //      prose: "Prose 2"
      //    }
      //  }, {
      //    3: {
      //      heading: "Heading 3",
      //      prose: "Prose 3"
      //    }
      //  }
      //],
      //signpost: [
      //  {
      //    1: [
      //      {
      //        chapterId: 2,
      //        teaser: "Chapter 2"
      //      }, {
      //        chapterId: 3,
      //        teaser: "Chapter 3"
      //      }
      //    ]
      //  }
      //]
    }));
  });

  it('handles SET_TITLE', () => {
    const initialState = Map();
    const action = {type: 'SET_TITLE', title: 'My Wild Adventure'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      title: 'My Wild Adventure'
    }));
  });

  it('handles SET_AUTHOR', () => {
    const initialState = Map();
    const action = {type: 'SET_AUTHOR', author: 'Mark Twain'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      author: 'Mark Twain'
    }));
  });

  it('handles SET_TAG_LINE', () => {
    const initialState = Map();
    const action = {type: 'SET_TAG_LINE', tagLine: 'What troubles lie ahead.'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      tagLine: 'What troubles lie ahead.'
    }));
  });

  it('handles SET_ABOUT', () => {
    const initialState = Map();
    const action = {type: 'SET_ABOUT', about: 'About this story...'};
    const nextState = reducer(initialState, action);

    expect(nextState).to.equal(fromJS({
      about: 'About this story...'
    }));
  });

});
