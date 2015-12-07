import React from 'react';

class Sign extends React.Component {
  render() {
    return (
        <div key='nextChapter{this.props.sign.targetChapterId}' className="nextChapterOption"><a href="#STORY_KEY/{this.props.sign.targetChapterId}">{this.props.sign.teaser}</a></div>
    );
  };
}

class DecisionPoint extends React.Component {
  render() {
    let choices = [];

    // TODO different options if end of story

    //this.props.nextOptions.forEach(function(sign) {
    //  choices.push(<Sign option={sign} />)
    //});

    return (
        <div id="decisionPoint">
          <ul>
            <li><a href="#/reader/{this.props.storyKey}">Return to Chapter One</a></li>
            <li><a href="#/catalog">Choose Another Story</a></li>
          </ul>
          {choices}
        </div>
    );
  }
}

export default DecisionPoint;
