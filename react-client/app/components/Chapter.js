import React from 'react';
import SignPost from './SignPost'

class Chapter extends React.Component {
  render() {
    return (
        <div>
          <div className="chapterTitle">{this.props.chapter.heading}</div>
          <div id="prose">
            {this.props.chapter.prose}
          </div>
          <h3>Choose what to do next</h3>
        </div>
    );
  };
}

export default Chapter;
