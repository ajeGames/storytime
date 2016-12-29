"use strict";

const awsHelpers = require('awsHelpers');
const Stories = require('stories');
const AWS = require('aws-sdk');

const dynamodbClient = new AWS.DynamoDB.DocumentClient();
const storyTableName = 'storiesTable';
const version = '0.6.0';

let stories = new Stories(dynamodbClient, storyTableName);

// const headers = {
//   'Content-Type': 'application/json',
//   'Access-Control-Allow-Origin' : '*' // Required for CORS support to work
// };
//
// function prettyJsonLog(thing, description) {
//   console.log(description, JSON.stringify(thing, null, 2));
// }
//
// function buildSuccess(payload, statusCode) {
//   let code = statusCode ? statusCode : 200;
//   return {
//     statusCode: code,
//     headers: headers,
//     body: JSON.stringify(payload)
//   };
// }
//
// function buildError(statusCode, errorCode, errorMessage) {
//   return {
//     statusCode: statusCode,
//     headers: headers,
//     body: JSON.stringify({
//       errorCode: errorCode,
//       message: errorMessage
//     })
//   };
// }
//
// function buildErrorRequiredField(fieldName) {
//   return buildError('400', 'MissingRequiredField',
//     'Request body missing required field: ' + fieldName);
// }
//
// function buildErrorMalformedInput() {
//   return buildError('400', 'MalformedInput', 'Unable to process input');
// }
//
// function buildErrorNotFound(key) {
//   return buildError('404', 'NotFound', 'Nothing found with key: ' + key);
// }
//
// function buildErrorDataAccess(err) {
//   prettyJsonLog(err, 'dynamodb err');
//   return buildError('500', 'DataAccess', err.message);
// }

/**
 * Checks the status of the service; returns signs of life if possible.
 */
module.exports.getStatus = (event, context, callback) => {
  const payload = {
    salutation: 'The StoryTime service is alive and well. Thanks for asking.',
    status: 'All systems are go.',
    version: version
  };
  callback(null, awsHelpers.buildSuccess(payload));
};

/**
 * Returns summaries of all stories in the system.  Someday this will have to
 * be limited with filters and pagination.
 */
module.exports.getSummaries = (event, context, callback) => {
  stories.getSummaries(callback);
};

/**
 * Returns the story with the given storyKey or 404 if not found.
 */
module.exports.getStory = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey;
  stories.getStory(storyKey, callback);
};

/**
 * Adds a new story with a unique storyKey to database.
 */
module.exports.createStory = (event, context, callback) => {
  let body;
  try {
    body = JSON.parse(event.body);
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput());
    return;
  }
  stories.createStory(body, callback);
};

/**
 * Updates story with field values sent in body.
 */
module.exports.updateStory = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey;
  let body;
  try {
    body = JSON.parse(event.body);
  } catch (e) {
    callback(null, awsHelpers.buildErrorMalformedInput());
    return;
  }
  stories.updateStory(storyKey, body, callback);
};
