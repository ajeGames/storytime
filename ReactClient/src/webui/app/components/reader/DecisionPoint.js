import React from 'react';
import { Link } from 'react-router';

const Sign = (props) => (
  <li>
    <Link to="/story/{props.storyKey}/{props.option.targetChapterId}">
      {props.option.teaser}
    </Link>
  </li>
);

Sign.propTypes = {
  storyKey: React.PropTypes.string,
  option: React.PropTypes.shape({
    targetChapterId: React.PropTypes.number,
    teaser: React.PropTypes.string,
  }),
};

const ReturnOptions = (props) => (
  <ul>
    <li><Link to="/story/{props.storyKey}">Return to Chapter One</Link></li>
    <li><Link to="/">Choose Another Story</Link></li>
  </ul>
);

ReturnOptions.propTypes = {
  storyKey: React.PropTypes.string,
};

const DecisionPoint = (props) => (
  <div id="signpost">
    <h3>Choose what to do next</h3>
    <ul>
      {props.nextOptions.map(option => <Sign storyKey={props.storyKey} option={option} />)};
    </ul>
    if (options === undefined || options.length === 0) {
      <ReturnOptions storyKey={props.storyKey} />
    };
  </div>
);

DecisionPoint.propTypes = {
  nextOptions: React.PropTypes.arrayOf(React.PropTypes.object),
  storyKey: React.PropTypes.string,
};

export default DecisionPoint;
