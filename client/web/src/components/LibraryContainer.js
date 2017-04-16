import { connect } from 'react-redux';
import { fetchStorySummaries, failFetchStorySummaries, loadStorySummaries } from '../appstate/actions';
import { storySummaries } from '../apidata';
import Library from './Library';

const mapStateToProps = (state) => {
  return {
    summaries: state.library.storySummariesToShow,
    loading: state.library.fetchingSummaries
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    refreshStories: () => {
      dispatch(fetchStorySummaries());
    },
    cancelRefreshStories: () => {
      dispatch(failFetchStorySummaries('User canceled'));
    },
    completeRefreshStories: () => {
      dispatch(loadStorySummaries(storySummaries));  // TODO have this call the server
    }
  }
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library)

export default LibraryContainer;
