import { connect } from 'react-redux';
import { requestStorySummaries, receiveStorySummaries } from '../appstate/actions';
import { storySummaries } from '../apidata';
import Library from './Library';

const mapStateToProps = (state) => {
  const summaries = state.library.storySummariesToShow.map(storyKey => {
    return state.bookshelf[storyKey].summary;
  })
  console.log(JSON.stringify(summaries, null, 2));
  return {
    loading: state.library.fetchingSummaries,
    summaries: summaries
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    refreshStories: () => {
      dispatch(requestStorySummaries());
    },
    cancelRefreshStories: () => {
      dispatch(receiveStorySummaries(new Error('User canceled')));
    },
    completeRefreshStories: () => {
      dispatch(receiveStorySummaries(storySummaries));  // TODO have this call the server
    }
  }
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library)

export default LibraryContainer;
