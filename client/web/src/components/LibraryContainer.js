import { connect } from 'react-redux';
import { fetchStorySummaries, failFetchStorySummaries } from '../appstate/actions';
import Library from './Library';

const mapStateToProps = (state) => {
  return {
    summaries: state.library.storySummariesToShow,
    loading: state.library.fetchingSummaries
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    loadStories: () => {
      dispatch(fetchStorySummaries());
    },
    cancelLoadStories: () => {
      dispatch(failFetchStorySummaries('User canceled'));
    }
  }
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library)

export default LibraryContainer;
