import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { story } from '../api/sample-stories';

const Sign = (props) => (
  <li>
    <Link to={`/reader/${props.storyKey}/${props.destination.chapterId}`}>
      {props.destination.teaser}
    </Link>
  </li>
);

Sign.propTypes = {
  storyKey: React.PropTypes.string,
  destination: React.PropTypes.shape({
    chapterId: React.PropTypes.number,
    teaser: React.PropTypes.string,
  }),
};

const EndOfLine = (props) => {
  return (
    <div>
      <p>You are at the end of the line.</p>
      <ul>
        <li><Link to="/story/{props.storyKey}">Return to Chapter One</Link></li>
        <li><Link to="/">Choose Another Story</Link></li>
      </ul>
    </div>
  );
}

EndOfLine.propTypes = {
  storyKey: React.PropTypes.string,
};

const SignPost = (props) => {
  if (props.signs.length === 0) {
    return <EndOfLine />
  }
  return (
    <ul>
      {props.signs.map(destination =>
        <Sign
          key={destination.chapterId}
          storyKey={props.storyKey}
          destination={destination} />)}
    </ul>
  )
};

SignPost.propTypes = {
  storyKey: React.PropTypes.string,
  signs: React.PropTypes.arrayOf(React.PropTypes.object),
};

const Chapter = (props) => (
  <div className="container">
    <h1>{props.chapter.title}</h1>
    <p>{props.chapter.prose}</p>
    <hr />
    <SignPost storyKey={props.storyKey} signs={props.chapter.signPost} />
  </div>
)

class Reader extends Component {
  render() {
    return (
      <div className="panel panel-default">
        <div className="panel-heading">
          <h3 className="text-center panel-title">
            <b>{story.summary.title}</b> <em>by {story.summary.author}</em></h3>
        </div>
        <div className="panel-body">
          <Chapter storyKey={story.summary.key} chapter={story.chapter} />
        </div>
      </div>
    );
  }
}

export default Reader;
