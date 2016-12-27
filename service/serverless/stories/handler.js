'use strict';

console.log('Loading StoryTime handlers');

const doc = require('dynamodb-doc');
const dynamo = new doc.DynamoDB();
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

module.exports.hello = (event, context, callback) => {
  prettyLog(event);
  const response = {
    statusCode: 200,
    headers: getHeaders(),
    body: JSON.stringify({
      message: 'The StoryTime service is alive and well. Thanks for asking.',
      input: event,
    }),
  };
  callback(null, response);
};

module.exports.listSummaries = (event, context, callback) => {
  prettyLog(event);

  const params = {
    TableName: storyTableName,
    AttributesToGet: [ 'summary' ],
    ConsistentRead: true,
  };

  const processResults = (err, res) => callback(null, {
    statusCode: err ? '500' : '200',
    headers: getHeaders(),
    body: err ? err.message : JSON.stringify(res),
  });

  dynamo.scan(params, processResults);
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
  // prettyLog(event);

  // validate input
  if (event.title === undefined) {
    callback(new Error('[400] Bad Request'));
    return;
  }

  const storySummary = {
    key: generateStoryKey(),
    title: event.title,
    author: event.author,
    tagLine: event.tagLine,
    about: event.about,
  };

  const params = {
    TableName: storyTableName,
    Item: {
      storyKey: storySummary.key,
      summary: storySummary,
    },
    ConditionExpression: 'attribute_not_exists(storyKey)',
  };

  const processResults = (err, res) => callback(null, {
    statusCode: err ? '400' : '202',
    headers: getHeaders(),
    body: err ? err.message : JSON.stringify(storySummary),
  });

  dynamo.putItem(params, processResults);
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
