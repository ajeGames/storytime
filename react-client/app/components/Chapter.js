import React from 'react';
import DecisionPoint from './DecisionPoint'

class Chapter extends React.Component {
  render() {
    let chapter = this.props.chapter;

    return (
        <div id="chapter" className="section">
          <div className="chapterTitle">{chapter.heading}</div>
          <div id="prose">
            {chapter.prose}
          </div>
          <h3>Choose what to do next</h3>
          <DecisionPoint storyKey={this.props.storyKey} nextOptions={chapter.nextChapterOptions} />
        </div>
    );
  };
}

export default Chapter;
