'use strict'

const awsHelpers = require('./awsHelpers')
const Stories = require('./stories')
const Chapters = require('./chapters')
const AWS = require('aws-sdk')

const dynamodbClient = new AWS.DynamoDB.DocumentClient()
const storyTableName = 'stories'
const chapterTableName = 'chapters'
const version = '0.7.0'

let stories = new Stories(dynamodbClient, storyTableName)
let chapters = new Chapters(dynamodbClient, chapterTableName)

/**
 * Checks the status of the service; returns signs of life if possible.
 */
module.exports.getStatus = (event, context, callback) => {
  const payload = {
    salutation: 'The StoryTime service is alive and well. Thanks for asking.',
    status: 'All systems are go.',
    version: version
  }
  callback(null, awsHelpers.buildSuccess(payload))
}

/**
 * Returns summaries of all stories in the system.  Someday this will have to
 * be limited with filters and pagination.
 */
module.exports.getSummaries = (event, context, callback) => {
  stories.getSummaries(callback)
}

/**
 * Returns the story with the given storyKey or 404 if not found.
 */
module.exports.getStory = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey
  stories.getStory(storyKey, callback)
}

/**
 * Adds a new story with a unique storyKey to database.
 */
module.exports.createStory = (event, context, callback) => {
  let body
  try {
    body = JSON.parse(event.body)
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput())
    return
  }
  stories.createStory(body, callback)
}

/**
 * Updates story with field values sent in body.
 */
module.exports.updateStory = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey
  let body
  try {
    body = JSON.parse(event.body)
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput())
    return
  }
  stories.updateStory(storyKey, body, callback)
}

module.exports.getChapter = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey
  const chapterId = parseInt(event.pathParameters.chapterId)
  chapters.getChapter(storyKey, chapterId, callback)
}

module.exports.updateChapter = (event, context, callback) => {
  callback(null, 'bah')
}
