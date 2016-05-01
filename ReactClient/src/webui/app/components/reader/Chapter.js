import React from 'react';
import DecisionPoint from './DecisionPoint'

class Chapter extends React.Component {
  render() {
    return (
        <div id="chapter" className="section">
          <div className="chapter_title">{this.props.chapter.heading}</div>
          <div id="prose">
            {this.props.chapter.prose}
          </div>
          <DecisionPoint storyKey={this.props.storyKey} nextOptions={this.props.chapter.signPost} />
        </div>
    );
  };
}

export default Chapter;
