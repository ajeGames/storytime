'use strict';

console.log('Loading StoryTime handlers');

const doc = require('dynamodb-doc');
const dynamo = new doc.DynamoDB();

function prettyLog(thing) {
  console.log(JSON.stringify(thing, null, 2));
}

function sampleStories() {
  return [
    {
      key: '1111-imauniqukey',
      title: 'Walk About the Neighborhood',
      author: 'Evangeline Sora',
      tagLine: 'Ooo, look at all the pretty lights.',
    }, {
      key: '2222-imauniqukey',
      title: 'The Cave',
      author: 'Bubba Gump',
      tagLine: 'As you are walking through the woods, you discover an opening in the ground.',
    }, {
      key: '3333-imauniqukey',
      title: 'ミスターバブル',
      author: '和くん',
      tagLine: '面白いよ！',
    }
  ];
}

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
    "Access-Control-Allow-Origin" : "*" // Required for CORS support to work
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

function getStorySummaries() {
  return sampleStories();
}

module.exports.listSummaries = (event, context, callback) => {
  prettyLog(event);

  const response = {
    statusCode: 200,
    headers: getHeaders(),
    body: JSON.stringify(getStorySummaries())
  };
  callback(null, response);
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
  prettyLog(event);

  let storySummary = event.body;  // TODO check that body is what we expect; if not, return 400
  storySummary.key = generateStoryKey();

  const params = {
    TableName: "stories",
    Item: {
      key: storySummary.key,
      summary: storySummary;
    }
  };

  const processResults = (err, res) => callback(null, {
    statusCode: err ? '400' : '202',
    headers: getHeaders(),
    body: err ? err.message : JSON.stringify(res),
  });

  dynamo.put(params, processResults);
}

module.exports.getStory = (event, context, callback) => {
  prettyLog(event);
  const response = {
    statusCode: 200,
    headers: getHeaders(),
    body: JSON.stringify(sampleStory())
  };
}
