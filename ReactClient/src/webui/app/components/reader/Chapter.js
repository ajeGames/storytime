import React from 'react';
import DecisionPoint from './DecisionPoint'

class Chapter extends React.Component {
  render() {
    let chapter = this.props.chapter;

    return (
        <div id="chapter" className="section">
          <div className="chapter_title">{chapter.heading}</div>
          <div id="prose">
            {chapter.prose}
          </div>
          <DecisionPoint storyKey={this.props.storyKey} nextOptions={chapter.nextChapterOptions} />
        </div>
    );
  };
}

export default Chapter;
