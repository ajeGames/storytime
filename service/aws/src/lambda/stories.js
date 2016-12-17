'use strict';

/**
 * Demonstrates a simple HTTP endpoint using API Gateway. You have full
 * access to the request and response payload, including headers and
 * status code.
 */
exports.handler = (event, context, callback) => {
  console.log('Received event:', JSON.stringify(event, null, 2));

  const notImplemented = {
    statusCode: 200,
    body: {
      message: "not implemented"
    },
    headers: {
      'Content-Type': 'application/json',
    },
  }

  const postResponse = {
    statusCode: '201',
    body: {
      key: "blargyblargy",
      title: "Your Story",
      author: "you",
      tagLine: "something catchy",
      about: "something interesting",
      firstChapter: {
        chapterId: 1,
        teaser: "start here"
      }
    },
    headers: {
      'Content-Type': 'application/json',
    },
  };

  switch (event.httpMethod) {
    case 'DELETE':
      callback(null, notImplemented);
      break;
    case 'GET':
      callback(null, notImplemented);
      break;
    case 'POST':
      callback(null, postResponse);
      break;
    case 'PUT':
      callback(null, notImplemented);
      break;
    default:
      done(new Error(`Unsupported method "${event.httpMethod}"`));
  }
};
