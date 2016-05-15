import React from 'react';
import Catalog from './Catalog';

class CatalogContainer extends React.Component {

  getInitialState() {
    return {
      catalog: [],
    };
  }

  componentDidMount() {
    const _this = this;
    const endpoint = '/api/storytime/stories';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: function (summaries) {
        _this.setState({ catalog: summaries });
      }.bind(_this),
      error: function (xhr, status, err) {
        console.error(endpoint, status, err.toString());
      }.bind(_this),
    });
  }

  render() {
    return (<Catalog summaries={this.state.catalog} />);
  }
}

export default CatalogContainer;
