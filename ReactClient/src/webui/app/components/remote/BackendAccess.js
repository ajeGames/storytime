import $ from 'jquery';

// TODO use a different library that provide Promise-based AJAX without messing with the DOM -- see Axios

class BackendAccess {
  constructor() {
    this.uriBase = '/api';
  }

  loadSummaries(context) {
    let endpoint = this.uriBase + '/storytime/stories';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: function (summaries) {
        context._handleSuccess(summaries);
      }.bind(context),
      error: function (xhr, status, err) {
        console.error(endpoint, status, err.toString());
      }.bind(context)
    });
  }

  loadStory(context, storyKey) {
    let endpoint = this.uriBase + '/story/' + storyKey + '/full';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: function (data) {
        context._handleSuccess(data);
      }.bind(context),
      error: function (xhr, status, err) {
        console.error(endpoint, status, err.toString());
      }.bind(context)
    });
  }
}

export default BackendAccess;
