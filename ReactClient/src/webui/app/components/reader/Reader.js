import React from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';
import TitleBar from './TitleBar';
import Chapter from './Chapter';

export default class Reader extends React.Component {

  render() {
    if (true) {
      return (
          <div class="reader">
            <header>Story Reader Goes Here</header>
          </div>
      )
    } else {
      return (
          <div class="reader">
            <TitleBar summary={this.props.summary} />
            <Chapter chapter={this.props.chapter} storyKey={this.props.storyKey} />
          </div>
      )
    }
  }
}

function mapStateToProps(state) {
  let openChapter = state.getIn(['story', 'openChapter']);
  console.log('open chapter:' + openChapter);
  console.log(state.getIn(['story', 'chapters', openChapter.toString()]));
  return {
    storyKey: state.getIn(['story', 'summary', 'key']),
    summary: state.getIn(['story', 'summary']),
    chapter: state.getIn(['story', 'chapters', openChapter])
  }
}

export const ReaderContainer = connect(mapStateToProps)(Reader);
