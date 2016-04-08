import $ from 'jquery';

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
