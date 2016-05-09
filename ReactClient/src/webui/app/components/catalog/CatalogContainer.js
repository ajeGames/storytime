import React from 'react';
import $ from 'jquery';
import Catalog from './Catalog';

const CatalogContainer = React.createClass({

  getInitialState: function() {
    return {
      storySummaries: []
    }
  },

  componentDidMount: function() {
    var _this = this;
    let endpoint = '/api/storytime/stories';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: function (summaries) {
        _this.setState({storySummaries: summaries})
      }.bind(_this),
      error: function (xhr, status, err) {
        console.error(endpoint, status, err.toString());
      }.bind(_this)
    });
  },

  render: function() {
    return (<Catalog summaries={this.state.storySummaries} />);
  }

});

export default CatalogContainer;
