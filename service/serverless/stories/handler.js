'use strict';

module.exports.hello = (event, context, callback) => {
  const response = {
    statusCode: 200,
    body: JSON.stringify({
      message: 'The StoryTime service is alive and well. Thanks for asking.',
      input: event,
    }),
  };

  callback(null, response);

  // Use this code if you don't use the http event with the LAMBDA-PROXY integration
  // callback(null, { message: 'Go Serverless v1.0! Your function executed successfully!', event });
};

module.exports.getStories = (event, context, callback) => {
  const response = {
    statusCode: 200,
    body: JSON.stringify(sampleStories())
  };

  callback(null, response);
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

module.exports.createStory = (event, context, callback) => {
  const response = {
    statusCode: 202,
    body: JSON.stringify(sampleStory())
  };
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
