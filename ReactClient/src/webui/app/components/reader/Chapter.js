import React from 'react';
import DecisionPoint from './DecisionPoint';

const Chapter = (props) => (
  <div id="chapter" className="section">
    <div className="chapter_title">{props.chapter.heading}</div>
    <div id="prose">
      {props.chapter.prose}
    </div>
    <DecisionPoint storyKey={props.storyKey} nextOptions={props.chapter.signPost} />
  </div>
);

Chapter.propTypes = {
  chapter: React.PropTypes.shape({
    heading: React.PropTypes.string,
    prose: React.PropTypes.string,
    signPost: React.PropTypes.object,
  }),
  storyKey: React.PropTypes.string,
};

export default Chapter;
