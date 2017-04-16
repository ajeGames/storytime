import { connect } from 'react-redux';
// import { storySummaries } from '../apidata/storySummaries';
import Library from './Library';

// class LibraryContainer extends Component {
//   render() {
//     const summaries = storySummaries;
//     return (
//       <Library summaries={ summaries } />
//     )
//   }
// }
//
const mapStateToProps = (state) => {
  return {}
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

const LibraryContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(Library);

export default LibraryContainer;
