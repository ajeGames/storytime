import { connect } from 'react-redux';
import Library from './Library';

const mapStateToProps = (state) => {
  return {
    summaries: state.library.storySummariesToShow,
    loading: state.library.fetchingSummaries
  }
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library)

export default LibraryContainer;
