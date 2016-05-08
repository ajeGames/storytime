import React from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';
import TitleBar from './TitleBar';
import Chapter from './Chapter';

export default class Reader extends React.Component {

  render() {
    let key = this.props.params.storyKey;
    let chapterId = this.props.params.chapterId || "1";

    if (key === undefined) {
      return (
          <div class="reader">
            <header>Story Reader Goes Here</header>
          </div>
      )
    } else {
      return (
          <div class="reader">
            <header>Loading story {key}, chapter {chapterId} ...forever</header>
          </div>
      )
    }
  }
}
//<TitleBar summary={this.props.summary} />
//<Chapter chapter={this.props.chapter} storyKey={this.props.storyKey} />

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
