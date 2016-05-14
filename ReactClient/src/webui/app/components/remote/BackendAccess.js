import $ from 'jquery';

// TODO use a different library that provide Promise-based AJAX without messing with the DOM
// TODO  -- see Axios

class BackendAccess {
  constructor() {
    this.uriBase = '/api';
  }

  loadSummaries(context) {
    const endpoint = '{this.uriBase}/storytime/stories';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: (summaries) => (
        context.handleSuccess(summaries)
      ).bind(context),
      error: (xhr, status, err) => (
        context.handleError(endpoint, status, err)
      ).bind(context),
    });
  }

  loadStory(context, storyKey) {
    const endpoint = '{this.uriBase}/story/{storyKey}/full';
    $.ajax({
      url: endpoint,
      dataType: 'json',
      cache: false,
      success: (data) => (
        context.handleSuccess(data)
      ).bind(context),
      error: (xhr, status, err) => (
        context.handleError(endpoint, status, err)
      ).bind(context),
    });
  }
}

export default BackendAccess;
