import { connect } from 'react-redux';
import { fetchStorySummaries, fetchStorySummariesResponse } from '../appstate/actions';
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
      dispatch(fetchStorySummariesResponse(new Error('User canceled')));
    },
    completeRefreshStories: () => {
      dispatch(fetchStorySummariesResponse(storySummaries));  // TODO have this call the server
    }
  }
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library)

export default LibraryContainer;
