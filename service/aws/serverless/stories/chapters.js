'use strict'

const awsHelpers = require('./awsHelpers')
const chapterIdLength = 8

class Chapters {
  constructor (db, chapterTableName) {
    this.db = db
    this.chapterTableName = chapterTableName
  }

  getChapters (storyId, callback) {
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

  createChapter (storyId, detailsIn, callback) {
    // validate input
    if (typeof detailsIn.title !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('title', 'string'))
      return
    }
    if (typeof detailsIn.prose !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('prose', 'string'))
      return
    }

    // save
    const chapterId = awsHelpers.generateRandomId(chapterIdLength)
    const details = {
      chapterId: chapterId,
      title: detailsIn.title,
      prose: detailsIn.prose,
      signPost: []
    }
    const params = {
      TableName: this.chapterTableName,
      Item: {
        storyId: storyId,
        chapterId: chapterId,
        details: details
      },
      ConditionExpression: 'attribute_not_exists(storyId) AND attribute_not_exists(chapterId)'
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        callback(null, awsHelpers.buildSuccess(details, 201))
      }
    }
    this.db.put(params, processResults)
  }

  getChapter (storyId, chapterId, callback) {
    const params = {
      TableName: this.chapterTableName,
      Key: {
        storyId: storyId,
        chapterId: chapterId
      }
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        if (res.Item === undefined) {
          callback(null, awsHelpers.buildErrorNotFound(storyId + ':' + chapterId))
        } else {
          callback(null, awsHelpers.buildSuccess(res.Item.details))
        }
      }
    }
    this.db.get(params, processResults)
  }

  updateChapter (storyId, chapterId, detailsIn, callback) {
    const fieldsToUpdate = ['title', 'prose']  // TODO deal with signPost, probably as a different resource
    let update = awsHelpers.buildUpdateExpressions(fieldsToUpdate, detailsIn)

    // complain about noops
    if (update.isEmpty) {
      callback(null, awsHelpers.buildErrorRequiredField('any or all of [' + fieldsToUpdate + ']'))
      return
    }

    // save updates
    const params = {
      TableName: this.storyTableName,
      Key: {
        storyId: storyId,
        chapterId: chapterId
      },
      UpdateExpression: update.expression,
      ExpressionAttributeValues: update.values,
      ReturnValues: 'ALL_NEW'
    }
    const processResults = (err, res) => {
      if (err) {
        // TODO find graceful way to respond when not found
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        callback(null, awsHelpers.buildSuccess(res.Attributes.details))
      }
    }
    this.db.update(params, processResults)
  }
}

module.exports = Chapters
