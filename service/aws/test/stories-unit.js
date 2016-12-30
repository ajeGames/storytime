var assert = require('assert');
var Stories = require('../serverless/stories/stories');

var db = {
  scan: function(params, results) {
    var mockScanResults = {
      "Items": {
        "summary": {
          "title": "test title",
          "author": "test author"
        }
      }
    };
    results(null, mockScanResults);
  }
}

describe('getSummaries', function() {
  describe('normal', function() {
    it('should return summaries from database', function(done) {
      var stories = new Stories(db, 'testStoryTable');
      stories.getSummaries(done);
    });
  });
});
