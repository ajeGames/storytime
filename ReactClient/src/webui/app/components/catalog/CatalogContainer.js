import React from 'react';
import Catalog from './Catalog';
import { fetchCatalogFromRemote } from '../../actions/story_actions';

class CatalogContainer extends React.Component {

  componentDidMount() {
    fetchCatalogFromRemote();
  }

  render() {
    return (<Catalog summaries={getState().catalog} />);
  }
}

export default CatalogContainer;
