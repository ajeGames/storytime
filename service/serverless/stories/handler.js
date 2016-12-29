'use strict';

const AWS = require('aws-sdk');
const dynamodbClient = new AWS.DynamoDB.DocumentClient();
const storyTableName = 'storiesTable';
const version = '0.5.0';

const headers = {
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin' : '*', // Required for CORS support to work
};

function prettyJsonLog(thing, description) {
  console.log(description, JSON.stringify(thing, null, 2));
}

function buildSuccess(payload, statusCode) {
  let code = statusCode ? statusCode : 200;
  return {
    statusCode: code,
    headers: headers,
    body: JSON.stringify(payload),
  };
}

function buildError(statusCode, errorCode, errorMessage) {
  return {
    statusCode: statusCode,
    headers: headers,
    body: JSON.stringify({
      errorCode: errorCode,
      message: errorMessage,
    }),
  };
}

function buildErrorRequiredField(fieldName) {
  return buildError('400', 'MissingRequiredField',
    'Request body missing required field: ' + fieldName);
}

function buildErrorNotFound(key) {
  return buildError('404', 'NotFound', 'Nothing found with key: ' + key);
}

function buildErrorDataAccess(err) {
  prettyJsonLog(err, 'dynamodb err');
  return buildError('500', 'DataAccess', err.message);
}

/**
 * Checks the status of the service; returns signs of life if possible.
 */
module.exports.getStatus = (event, context, callback) => {
  const payload = {
    salutation: 'The StoryTime service is alive and well. Thanks for asking.',
    status: 'All systems are go.',
    version: version,
  };
  callback(null, buildSuccess(payload));
};

/**
 * Returns summaries of all stories in the system.  Someday this will have to
 * be limited with filters and pagination.
 */
module.exports.getSummaries = (event, context, callback) => {
  const params = {
    TableName: storyTableName,
    AttributesToGet: [ 'summary' ],
    ConsistentRead: true,
  };
  const processResults = (err, res) => {
    if (err) {
      callback(null, buildErrorDataAccess(err));
    } else {
      callback(null, buildSuccess(res.Items));
    }
  };
  dynamodbClient.scan(params, processResults);
}

/**
 * Returns the story with the given storyKey or 404 if not found.
 */
module.exports.getStory = (event, context, callback) => {
  const storyKey = event.pathParameters.storyKey;
  const params = {
    TableName: storyTableName,
    Key: {
      storyKey: storyKey,
    },
  };
  const processResults = (err, res) => {
    if (err) {
      callback(null, buildErrorDataAccess(err));
    } else {
      if (res.Item === undefined) {
        callback(null, buildErrorNotFound(storyKey));
      } else {
        callback(null, buildSuccess(res.Item.summary));
      }
    }
  };
  dynamodbClient.get(params, processResults);
}

function generateStoryKey(length) {
  const possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  let key = "";
  for(var i = 0; i < length; i++) {
    key += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  return key;
}

/**
 * Adds a new story with a unique storyKey to database.
 *
 * (There is a minute chance of failure if a key is generated that is
 * already in use.  Just try a second time -- the odds are nearly certain
 * that it won't happen twice in a row unless there's a bug in the service.)
 */
module.exports.createStory = (event, context, callback) => {
  const body = JSON.parse(event.body);

  // validate input
  if (body.title === undefined) {
    callback(null, buildErrorRequiredField('title'));
    return;
  }
  // TODO handle unexpected types (i.e., non-String)

  const storyKey = generateStoryKey(12);  // TODO make sure key not already in use
  const summary = {
    key: storyKey,
    title: body.title,
    author: body.author,
    tagLine: body.tagLine,
    about: body.about,
  };
  const params = {
    TableName: storyTableName,
    Item: {
      storyKey: storyKey,
      summary: summary,
    },
    ConditionExpression: 'attribute_not_exists(storyKey)',  // do not overwrite existing
  };
  const processResults = (err, res) => {
    if (err) {
      callback(null, buildErrorDataAccess(err));
    } else {
      callback(null, buildSuccess(summary, 201));
    }
  };
  dynamodbClient.put(params, processResults);
}

module.exports.updateStory = (event, context, callback) => {
  prettyJsonLog(event, 'updateStory event');
  const storyKey = event.pathParameters.storyKey;
  const body = JSON.parse(event.body);

  let updTitle = body.title ? body.title : '';
  let updAuthor = body.author ? body.author : '';
  let updTagLine = body.tagLine ? body.tagLine : '';
  let updAbout = body.about ? body.about : '';

  const params = {
    TableName: storyTableName,
    Key: {
      storyKey: storyKey,
    },
    UpdateExpression: 'set summary.title = :title, summary.author = :author, summary.tagLine = :tagLine, summary.about = :about',
    ExpressionAttributeValues: {
      ':title': updTitle,
      ':author': updAuthor,
      ':tagLine': updTagLine,
      ':about': updAbout,
    },
    ReturnValues: "ALL_NEW",
  };
  const processResults = (err, res) => {
    if (err) {
      callback(null, buildErrorDataAccess(err));
    } else {
      prettyJsonLog(res, 'updateStory dynamodb result');
      callback(null, buildSuccess(res));
    }
  };
  dynamodbClient.update(params, processResults);
}
