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
          <SignPost signs={this.props.chapter.nextChapterOptions} />
        </div>
    );
  };
}

export default Chapter;
