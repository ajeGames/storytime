import React from 'react';
import { Link } from 'react-router';

class Sign extends React.Component {

//<li>{this.props.option.teaser}</li>

  render() {
    let uri = "/reader/" + this.props.storyKey + "/" + this.props.option.targetChapterId;
    return (
        <li><a href={uri}>{this.props.option.teaser}</a></li>
    );
  }
}

class DecisionPoint extends React.Component {
  render() {

    let storyKey = this.props.storyKey;

    // TODO different options if end of story
    //<ul>
    //  <li><a href="#/reader/{this.props.storyKey}">Return to Chapter One</a></li>
    //  <li><a href="#/catalog">Choose Another Story</a></li>
    //</ul>

    return (
      <ul id="decisionPoint">
          {this.props.nextOptions.map(function(option) {
            return <Sign key={option.targetChapterId} storyKey={storyKey} option={option} />;
          })}
      </ul>
    );
  }
}

export default DecisionPoint;
