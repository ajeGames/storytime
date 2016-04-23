import React from 'react';
import ReactDOM from 'react-dom';
import { connect } from 'react-redux';
import TitleBar from './TitleBar';
import Chapter from './Chapter';
import BackendAccess from './../remote/BackendAccess';

class Reader extends React.Component {
  constructor() {
    super();
    this.state = {
      loaded: false
    };
  }

  componentDidMount() {
    let backend = new BackendAccess();
    backend.loadStory(this, this.props.params.storyKey);
  }

  _handleSuccess(story) {

    let chapterIndex = new Map();
    story.chapters.forEach(chapter => {
      chapterIndex.set(chapter.id.toString(), chapter);
    });

    this.setState(
        {
          summary: story.summary,
          chapters: chapterIndex,
          loaded: true
        });
  }

  mapStateToProps(state) {
    return {
      summary: state.getIn(['story', 'summary']),
      chapters: state.getIn(['story', 'chapters']),
      signpost: state.getIn(['story', 'signpost'])
    }
  }

  render() {
    // short circuit until loaded
    if (!this.state.loaded) {
      return (
          <div id="reader">
            <h1>Loading...</h1>
          </div>
      );
    }

    let storyKeyParam = this.props.params.storyKey;
    let chapterIdParam = this.props.params.chapterId;
    let openChapter = chapterIdParam || this.state.summary.firstChapter.targetChapterId.toString();

    if (storyKeyParam === undefined) {
      return (
          <div id="reader">
            <h1>Unknown Story</h1>
          </div>
      );
    } else {
      // go fetch the story
    }

    return (
        <div id="reader">
          <TitleBar summary={this.state.summary} />
          <Chapter chapter={this.state.chapters.get(openChapter)} storyKey={this.state.summary.key} />
        </div>
    );
  }
}

export default Reader;
