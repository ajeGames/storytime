'use strict'

const awsHelpers = require('./awsHelpers')

class Chapters {
  constructor (db, chapterTableName) {
    this.db = db
    this.chapterTableName = chapterTableName
  }

  getChapters (storyKey, callback) {
    const params = {
      TableName: this.chapterTableName,
      AttributesToGet: [ 'details' ],
      ConsistentRead: true
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        callback(null, awsHelpers.buildSuccess(res.Items))
      }
    }
    this.db.scan(params, processResults)
  }

  createChapter (storyKey, detailsIn, callback) {
    // validate input
    if (detailsIn.title === undefined) {
      callback(null, awsHelpers.buildErrorRequiredField('title'))
      return
    }
    if (typeof detailsIn.title !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('title', 'string'))
      return
    }
    if (typeof detailsIn.prose !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('prose', 'string'))
      return
    }

    // save
    const details = {
      title: detailsIn.title,
      prose: detailsIn.prose,
      signPost: []
    }

    const params = {
      TableName: this.storyTableName,
      Item: {
        storyKey: storyKey,
        chapterId: chapterId,  // FIXME generate next ID -- consider switching to UUIDs, or at least do not rely on sequence (use HASH for chapters, too)
        details: details
      },
      ConditionExpression: 'attribute_not_exists(storyKey)' // fail if key is in use -- worth the risk
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        callback(null, awsHelpers.buildSuccess(summary, 201)) // FIXME change to return what was stored
      }
    }
    this.db.put(params, processResults)

    callback(null, awsHelpers.buildErrorNotImplemented())
  }

  getChapter (storyKey, chapterId, callback) {
    const params = {
      TableName: this.chapterTableName,
      Key: {
        storyKey: storyKey,
        chapterId: chapterId
      }
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        if (res.Item === undefined) {
          callback(null, awsHelpers.buildErrorNotFound(storyKey + ':' + chapterId))
        } else {
          callback(null, awsHelpers.buildSuccess(res.Item.details))
        }
      }
    }
    this.db.get(params, processResults)
  }

  updateChapter (storyKey, chapterId, details, callback) {
    callback(null, awsHelpers.buildErrorNotImplemented())
  }
}

module.exports = Chapters
