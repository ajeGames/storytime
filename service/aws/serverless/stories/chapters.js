'use strict'

const awsHelpers = require('./awsHelpers')

class Chapters {
  constructor (db, chapterTableName) {
    this.db = db
    this.chapterTableName = chapterTableName
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
          callback(null, awsHelpers.buildSuccess(res.Item))
        }
      }
    }
    this.db.get(params, processResults)
  }
}

module.exports = Chapters
