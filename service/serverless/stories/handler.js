'use strict';

const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient();
const storyTableName = 'storiesTable';

function prettyLog(thing) {
  console.log(JSON.stringify(thing, null, 2));
}

// function sampleStories() {
//   return [
//     {
//       key: '1111-imauniqukey',
//       title: 'Walk About the Neighborhood',
//       author: 'Evangeline Sora',
//       tagLine: 'Ooo, look at all the pretty lights.',
//     }, {
//       key: '2222-imauniqukey',
//       title: 'The Cave',
//       author: 'Bubba Gump',
//       tagLine: 'As you are walking through the woods, you discover an opening in the ground.',
//     }, {
//       key: '3333-imauniqukey',
//       title: 'ミスターバブル',
//       author: '和くん',
//       tagLine: '面白いよ！',
//     }
//   ];
// }

function sampleStory() {
  return {
    key: '1111-imauniqukey',
    title: 'Walk About the Neighborhood',
    author: 'Evangeline Sora',
    tagLine: 'Ooo, look at all the pretty lights.',
    firstChapter: {
      chapterId: 1,
      teaser: 'Your destiny starts here.'
    }
  };
}

function getHeaders() {
  return {
    'Content-Type': 'application/json',
    "Access-Control-Allow-Origin" : "*", // Required for CORS support to work
  };
}

module.exports.hello = (event, context) => {
  const response = {
    statusCode: 200,
    headers: getHeaders(),
    body: JSON.stringify({
      message: 'The StoryTime service is alive and well. Thanks for asking.',
      input: event,
    }),
  };
  context.succeed(response);
};

module.exports.listSummaries = (event, context, callback) => {
  const params = {
    TableName: storyTableName,
    AttributesToGet: [ 'summary' ],
    ConsistentRead: true,
  };

  const processResults = (err, res) => {
    const resp = {
      statusCode: err ? '500' : '200',
      headers: getHeaders(),
      body: err ? err.message : JSON.stringify(res),
    };
    context.succeed(resp);
  }

  docClient.scan(params, processResults);
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
  console.log('called createStory');
  prettyLog(event);
  prettyLog(context);

  const body = JSON.parse(event.body);

  // validate input
  if (body.title === undefined) {
    console.log('Validation: missing required field [title]')
    callback(new Error('[400] Bad Request'));
    return;
  }

  const storyKey = generateStoryKey();
  const storySummary = {
    key: storyKey,
    title: body.title,
    author: body.author,
    tagLine: body.tagLine,
    about: body.about,
  };
  prettyLog(storySummary);

  const params = {
    TableName: storyTableName,
    Item: {
      storyKey: storyKey,
      summary: storySummary,
    },
    // ConditionExpression: 'attribute_not_exists(storyKey)',
  };

  const correctWayToProcess = (err, res) => {
    prettyLog(err);
    const resp = {
      statusCode: err ? '400' : '202',
      headers: getHeaders(),
      body: err ? err.message : JSON.stringify(storySummary),
    };
    context.succeed(resp);
  }

  const processResults = (err, res) => callback(null, {
    statusCode: err ? '400' : '202',
    headers: getHeaders(),
    body: err ? err.message : JSON.stringify(storySummary),
  });

  prettyLog(params);
  docClient.put(params, correctWayToProcess);
}

module.exports.getStory = (event, context, callback) => {
  prettyLog(event);
  const response = {
    statusCode: 200,
    headers: getHeaders(),
    body: JSON.stringify(sampleStory())
  };
  callback(null, response);
}
