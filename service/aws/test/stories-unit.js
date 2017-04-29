var describe = require('mocha').describe
var it = require('mocha').it
var expect = require('chai').expect
var Stories = require('../serverless/stories/stories')

var db = {
  scan: function (params, results) {
    var mockScanResults = {
      'Items': {
        'summary': {
          'title': 'test title',
          'author': 'test author'
        }
      }
    }
    results(null, mockScanResults)
  }
}

describe('getSummaries', function () {
  describe('normal', function () {
    it('should return summaries from database', function (done) {
      var stories = new Stories(db, 'testStoryTable')
      stories.getSummaries(function (err, results) {
        if (err) {
          return done(err)
        }
        console.log(results)
        expect(results.statusCode).to.equal(200)
        expect(results.headers).to.exist
        expect(results.body).to.exist
        var body = JSON.parse(results.body)
        expect(body.summary.title).to.equal('test title')
        done()
      })
    })
  })
})
