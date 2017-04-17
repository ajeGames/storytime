import { connect } from 'react-redux';
// import { fetchStorySummaries, failFetchStorySummaries, loadStorySummaries } from '../appstate/actions';
import Reader from './Reader';

const sampleStory = {
  storyKey: "uniquestorykey",
  title: "The Big One",
  author: {
    penName: "Bubba Gump"
  },
  tagLine: "Read this, you fool.",
  about: "What do you think this is about?  I'll tell you.",
  firstChapter: "uniquechapterkey"
};

const sampleChapter = {
  chapterKey: "uniquechapterkey",
  title: "Uh Oh.",
  prose: "This is all of the stuff that happens in the chapter.",
  signpost: [
    {
      destination: "uniquechapterkey",
      teaser: "It's groundhogs day all over again. Try to escape."
    }
  ]
};

const mapStateToProps = (state) => {
  return {
    story: sampleStory,
    chapter: sampleChapter
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
