import { connect } from 'react-redux';
// import { storyThatStartsAtTheEnd as myStory } from '../apidata';
import { shortStory as myStory } from '../apidata';
// import { fetchStorySummaries, failFetchStorySummaries, loadStorySummaries } from '../appstate/actions';
import Reader from './Reader';

const mapStateToProps = (state) => {
  return {
    story: myStory.summary,
    chapter: myStory.chapters[myStory.summary.firstChapter]
  }
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

const ReaderContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Reader);

export default ReaderContainer;
