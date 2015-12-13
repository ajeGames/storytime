import React from 'react';
import ReactDOM from 'react-dom';
import TitleBar from './TitleBar';
import Chapter from './Chapter';
import STORY1 from './SampleData';  // local test data

class Reader extends React.Component {
  constructor() {
    this.state = {};
  }

  render() {
    let storyKeyParam = this.props.params.storyKey;
    let chapterIdParam = this.props.params.chapterId;

    // use local test data for now
    const summary = STORY1.summary;
    const chapter = STORY1.chapters[0];

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
        <TitleBar summary={summary} />
        <p>(story key: {storyKeyParam}, chapter ID: {chapterIdParam})</p>
        <Chapter chapter={chapter} storyKey={summary.key} />
      </div>
    );
  }
}

export default Reader;
