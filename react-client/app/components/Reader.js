import React from 'react';
import ReactDOM from 'react-dom';
import TitleBar from './TitleBar';
import Chapter from './Chapter';
import STORY1 from './SampleData';  // local test data

class Reader extends React.Component {
  constructor() {
    super();

    let chapterIndex = new Map();
    STORY1.chapters.forEach(chapter => {
      chapterIndex.set(chapter.id, chapter);
    });

    this.state = {
      summary: STORY1.summary,
      chapters: chapterIndex,
      currentChapterId: STORY1.summary.firstChapter.targetChapterId
    };
  }

  // TODO respond to change in chapter by updating currentChapterId

  render() {
    let storyKeyParam = this.props.params.storyKey;
    let chapterIdParam = this.props.params.chapterId;

    // use local test data for now
    //const summary = STORY1.summary;
    //const chapter = STORY1.chapters[0];

    if (storyKeyParam === undefined) {
      return (
          <div id="reader">
            <h1>Unknown Story</h1>
          </div>
      );
    } else {
      // go fetch the story
    }

    return (
      <div id="reader">
        <TitleBar summary={this.state.summary} />
        <p>(story key: {storyKeyParam}, chapter ID: {chapterIdParam})</p>
        <Chapter chapter={this.state.chapters.get(this.state.currentChapterId)} storyKey={this.state.summary.key} />
      </div>
    );
  }
}

export default Reader;
