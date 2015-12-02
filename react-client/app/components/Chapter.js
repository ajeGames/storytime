import React from 'react';

class Chapter extends React.Component {
  render() {
    return (
        <div>
          <div className="chapterTitle">{this.props.chapter.targetChapterId}</div>
          <div id="prose">
            {this.props.chapter.teaser}
          </div>
        </div>
    );
  };
}

export default { Chapter };
