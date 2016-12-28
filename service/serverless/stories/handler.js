'use strict';

const AWS = require('aws-sdk');
const dynamodbClient = new AWS.DynamoDB.DocumentClient();
const storyTableName = 'storiesTable';
const version = '0.5.0';

const headers = {
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin' : '*', // Required for CORS support to work
};

const sampleStory = {
  key: '1111-imauniqukey',
  title: 'Walk About the Neighborhood',
  author: 'Evangeline Sora',
  tagLine: 'Ooo, look at all the pretty lights.',
  firstChapter: {
    chapterId: 1,
    teaser: 'Your destiny starts here.'
  }
};

function prettyJsonLog(thing, description) {
  console.log(description, JSON.stringify(thing, null, 2));
}

module.exports.getStatus = (event, context, callback) => {
  const response = {
    statusCode: 200,
    headers: headers,
    body: JSON.stringify({
      salutation: 'The StoryTime service is alive and well. Thanks for asking.',
      status: 'All systems are go.',
      version: version,
    }),
  };
  callback(null, response);
};

module.exports.getSummaries = (event, context, callback) => {
  const params = {
    TableName: storyTableName,
    AttributesToGet: [ 'summary' ],
    ConsistentRead: true,
  };
  const processResults = (err, res) => callback(null, {
    statusCode: err ? '500' : '200',
    headers: headers,
    body: err ? err.message : JSON.stringify(res.Items),
  });
  dynamodbClient.scan(params, processResults);
}

function generateStoryKey() {
  const length = 12;
  let key = "";
  let possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  for(var i = 0; i < length; i++) {
    key += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  return key;
}

module.exports.createStory = (event, context, callback) => {
  const body = JSON.parse(event.body);

  // validate input
  if (body.title === undefined) {
    callback(new Error('[400] Validation Error: missing required field: title'));
    return;
  }

  // insert story summary
  const storyKey = generateStoryKey();
  const summary = {
    key: storyKey,
    title: body.title,
    author: body.author,
    tagLine: body.tagLine,
    about: body.about,
    firstChapter: {
      chapterId: 1,
      teaser: 'Start here',
    },
  };
  const params = {
    TableName: storyTableName,
    Item: {
      storyKey: storyKey,
      summary: summary,
    },
    // ConditionExpression: 'attribute_not_exists(storyKey)',
  };
  // TODO make this gracefully handle duplicate key, retry
  const processResults = (err, res) => callback(null, {
    statusCode: err ? '500' : '202',
    headers: headers,
    body: err ? err.message : JSON.stringify(summary),
  });
  dynamodbClient.put(params, processResults);
}

module.exports.getStory = (event, context, callback) => {
  prettyJsonLog(event, 'event');
  const response = {
    statusCode: 200,
    headers: headers,
    body: JSON.stringify(sampleStory)
  };
  callback(null, response);
}
