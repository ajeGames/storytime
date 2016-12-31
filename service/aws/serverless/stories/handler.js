'use strict'

const AWS = require('aws-sdk')
const awsHelpers = require('./awsHelpers')
const Stories = require('./stories')
const Chapters = require('./chapters')

const dynamodbClient = new AWS.DynamoDB.DocumentClient()
const storyTableName = 'stories_v1'
const chapterTableName = 'chapters_v1'
const version = '0.8.0'

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
 * Returns the story with the given storyId or 404 if not found.
 */
module.exports.getStory = (event, context, callback) => {
  const storyId = event.pathParameters.storyId
  stories.getStory(storyId, callback)
}

/**
 * Adds a new story with a unique storyId to database.
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
  const storyId = event.pathParameters.storyId
  let body
  try {
    body = JSON.parse(event.body)
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput())
    return
  }
  stories.updateStory(storyId, body, callback)
}

module.exports.getChapters = (event, context, callback) => {
  const storyId = event.pathParameters.storyId
  chapters.getChapters(storyId, callback)
}

module.exports.createChapter = (event, context, callback) => {
  const storyId = event.pathParameters.storyId
  let body
  try {
    body = JSON.parse(event.body)
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput())
    return
  }
  chapters.createChapter(storyId, body, callback)
}

module.exports.getChapter = (event, context, callback) => {
  const storyId = event.pathParameters.storyId
  const chapterId = event.pathParameters.chapterId
  chapters.getChapter(storyId, chapterId, callback)
}

module.exports.updateChapter = (event, context, callback) => {
  const storyId = event.pathParameters.storyId
  const chapterId = event.pathParameters.chapterId
  let body
  try {
    body = JSON.parse(event.body)
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput())
    return
  }
  chapters.updateChapter(storyId, chapterId, body, callback)
}
