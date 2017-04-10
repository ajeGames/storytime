import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { normalStory as story } from '../apidata/normalStory';

function Sign(props) {
  return (
    <li>
      <Link to={`/reader/${props.storyKey}/${props.destination.chapterId}`}>
        {props.destination.teaser}
      </Link>
    </li>
  );
}

Sign.propTypes = {
  storyKey: React.PropTypes.string.isRequired,
  destination: React.PropTypes.shape({
    chapterId: React.PropTypes.number,
    teaser: React.PropTypes.string,
  }).isRequired,
};

function TheEnd(props) {
  return (
    <div>
      <p>You are at the end of the line.</p>
      <ul>
        <li><Link to={`/story/${props.storyKey}`}>Return to Chapter One</Link></li>
        <li><Link to="/">Choose Another Story</Link></li>
      </ul>
    </div>
  );
}

TheEnd.propTypes = {
  storyKey: React.PropTypes.string.isRequired,
};

function SignPost(props) {
  if (props.signs.length === 0) {
    return (<TheEnd storyKey={props.storyKey} />);
  }
  return (
    <ul>
      {props.signs.map(destination =>
        <Sign
          key={destination.chapterId}
          storyKey={props.storyKey}
          destination={destination}
        />)}
    </ul>
  );
}

SignPost.propTypes = {
  storyKey: React.PropTypes.string.isRequired,
  signs: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};

function Chapter(props) {
  return (
    <div className="container">
      <h2>{props.chapter.title}</h2>
      <p>{props.chapter.prose}</p>
      <hr />
      <SignPost storyKey={props.storyKey} signs={props.chapter.signPost} />
    </div>
  );
}

Chapter.propTypes = {
  storyKey: React.PropTypes.string.isRequired,
  chapter: React.PropTypes.shape({
    title: React.PropTypes.string,
    prose: React.PropTypes.string,
    signPost: React.PropTypes.array,
  }).isRequired,
};

class Reader extends Component {
  constructor() {
    super();
    this.state = {
      story: story.summary,
      chapter: story.chapter,
    };
  }

  handleChangeChapter(chapter) {
    this.setState({ chapter });
  }

  render() {
    return (
      <div className="panel panel-default">
        <div className="panel-heading">
          <h3 className="text-center panel-title">
            <b>{this.state.story.title}</b> <em>by {this.state.story.author}</em></h3>
        </div>
        <div className="panel-body">
          <Chapter storyKey={this.state.story.key} chapter={this.state.chapter} />
        </div>
      </div>
    );
  }
}

export default Reader;
