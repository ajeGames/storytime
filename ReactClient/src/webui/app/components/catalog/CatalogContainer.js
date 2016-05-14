import React from 'react';
import $ from 'jquery';
import Catalog from './Catalog';

class CatalogContainer extends React.Component {

  getInitialState() {
    return {
      storySummaries: [],
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
        _this.setState({ storySummaries: summaries });
      }.bind(_this),
      error: function (xhr, status, err) {
        console.error(endpoint, status, err.toString());
      }.bind(_this),
    });
  }

  render() {
    return (<Catalog summaries={this.state.storySummaries} />);
  }
}

export default CatalogContainer;
