'use strict'

const awsHelpers = require('./awsHelpers')
const storyIdLength = 12

class Stories {
  constructor (db, storyTableName) {
    this.db = db
    this.storyTableName = storyTableName
  }

  getSummaries (callback) {
    const params = {
      TableName: this.storyTableName,
      AttributesToGet: [ 'summary' ],
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

  getStory (storyId, callback) {
    const params = {
      TableName: this.storyTableName,
      Key: {
        storyId: storyId
      }
    }
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err))
      } else {
        if (res.Item === undefined) {
          callback(null, awsHelpers.buildErrorNotFound(storyId))
        } else {
          callback(null, awsHelpers.buildSuccess(res.Item.summary))
        }
      }
    }
    this.db.get(params, processResults)
  }

  createStory (summaryIn, callback) {
    // validate input
    if (summaryIn.title === undefined) {
      callback(null, awsHelpers.buildErrorRequiredField('title'))
      return
    }
    if (typeof summaryIn.title !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('title', 'string'))
      return
    }
    if (typeof summaryIn.author !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('author', 'string'))
      return
    }
    if (typeof summaryIn.tagLine !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('tagLine', 'string'))
      return
    }
    if (typeof summaryIn.about !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('about', 'string'))
      return
    }

    // save
    const storyId = awsHelpers.generateRandomId(storyIdLength)
    const details = {
      storyId: storyId,
      title: summaryIn.title,
      author: summaryIn.author,
      tagLine: summaryIn.tagLine,
      about: summaryIn.about,
      firstChapter: 'unknown'  // should be updated after first chapter is created
    }
    const params = {
      TableName: this.storyTableName,
      Item: {
        storyId: storyId,
        details: details
      },
      ConditionExpression: 'attribute_not_exists(storyId)' // fail if key is in use -- worth the risk
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

  updateStory (storyId, updateIn, callback) {
    const fieldsToUpdate = ['title', 'author', 'tagLine', 'about', 'firstChapter']

    // construct update expressions
    let updExpr = 'set '
    const offset = updExpr.length
    let exprAttrValues = {}
    const numFields = fieldsToUpdate.length
    for (let i = 0; i < numFields; i++) {
      let fieldName = fieldsToUpdate[i]
      let bodyFieldValue = updateIn[fieldName]
      if (bodyFieldValue === undefined || bodyFieldValue === '') {
        continue
      }
      if (updExpr.length > offset) {
        updExpr += ', '
      }
      let placeholder = ':' + fieldName
      updExpr += 'details.' + fieldName + ' = ' + placeholder
      exprAttrValues[placeholder] = bodyFieldValue
    }

    // complain about noops
    if (updExpr.length === offset) {
      callback(null, awsHelpers.buildErrorRequiredField('any or all of [' + fieldsToUpdate + ']'))
      return
    }

    // save updates
    const params = {
      TableName: this.storyTableName,
      Key: {
        storyId: storyId
      },
      UpdateExpression: updExpr,
      ExpressionAttributeValues: exprAttrValues,
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

module.exports = Stories
