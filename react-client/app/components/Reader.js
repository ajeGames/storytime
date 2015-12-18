import React from 'react';
import ReactDOM from 'react-dom';
import TitleBar from './TitleBar';
import Chapter from './Chapter';
import STORY1 from './SampleData';  // local test data

class Reader extends React.Component {
  constructor() {
    super();

    // establish story and chapter being read
    let chapterIndex = new Map();
    STORY1.chapters.forEach(chapter => {
      chapterIndex.set(chapter.id.toString(), chapter);
    });

    this.state = {
      summary: STORY1.summary,
      chapters: chapterIndex,
    };
  }

  render() {
    let storyKeyParam = this.props.params.storyKey;
    let chapterIdParam = this.props.params.chapterId;

    let openChapter = chapterIdParam || this.state.summary.firstChapter.targetChapterId.toString();

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
        <Chapter chapter={this.state.chapters.get(openChapter)} storyKey={this.state.summary.key} />
      </div>
    );
  }
}

export default Reader;
