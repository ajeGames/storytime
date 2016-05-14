import React from 'react';
import TitleBar from './TitleBar';
import Chapter from './Chapter';
import { connect } from 'react-redux';

const Reader = (props) => (
  <div className="reader">
    <TitleBar title={props.summary.title} author={props.summary.author} />
    <Chapter chapter={props.chapter} storyKey={props.storyKey} />
  </div>
);

Reader.propTypes = {
  storyKey: React.PropTypes.string,
  summary: React.PropTypes.object,
  chapter: React.PropTypes.object,
};

function mapStateToProps(state) {
  const openChapter = state.getIn(['story', 'openChapter']);
  return {
    storyKey: state.getIn(['story', 'summary', 'key']),
    summary: state.getIn(['story', 'summary']),
    chapter: state.getIn(['story', 'chapters', openChapter]),
  };
}

export const ReaderContainer = connect(mapStateToProps)(Reader);
