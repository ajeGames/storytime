import React from 'react';
import Catalog from './Catalog';
import { fetchCatalogFromRemote } from '../../actions/story_actions';

class CatalogContainer extends React.Component {

  componentDidMount() {
    fetchCatalogFromRemote();
  }

  render() {
    const { store } = this.context;
    return (<Catalog summaries={store.catalog} />);
  }
}
CatalogContainer.contextTypes = {
  store: React.PropTypes.object,
};

export default CatalogContainer;
