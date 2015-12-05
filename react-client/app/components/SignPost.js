import React from 'react';

class Sign extends React.Component {
  render() {
    return (
        <div className="nextChapterOption"><a href="#STORY_KEY/{this.props.sign.targetChapterId}">{this.props.sign.teaser}</a></div>
    );
  };
}

class SignPost extends React.Component {
  render() {
    let choices = [];

    // TODO different options if end of story

    this.props.signs.forEach(function(sign) {
      choices.push(<Sign option={sign} />)
    });

    return (
        <div id="nextChapters">
          {choices}
        </div>
    );
  }
}

export default SignPost;
