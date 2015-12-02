import React from 'react';

class Chapter extends React.Component {
  render() {
    return (
        <div>
          <div className="chapterTitle">{this.props.chapter.heading}</div>
          <div id="prose">
            {this.props.chapter.prose}
          </div>
        </div>
    );
  };
}

export default Chapter;
