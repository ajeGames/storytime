'use strict';

console.log('Loading function');

const doc = require('dynamodb-doc');
const dynamo = new doc.DynamoDB();

exports.mockHandler = (event, context, callback) => {
  console.log('Received event:', JSON.stringify(event, null, 2));
  console.log('Received event:', JSON.stringify(context, null, 2));
  var responseBody = {
    statusCode: 200,
    body: {
      message: 'pong'
    },
    headers: {
      'Content-Type': 'application/json',
    },
  };
  context.succeed(JSON.stringify(responseBody));
};

exports.handler = (event, context, callback) => {
  console.log('Received event:', JSON.stringify(event, null, 2));
  console.log('Received event:', JSON.stringify(context, null, 2));

  const done = (err, res) => callback(null, {
    statusCode: err ? '400' : '200',
    body: err ? err.message : JSON.stringify(res),
    headers: {
      'Content-Type': 'application/json',
    },
  });

  switch (event.httpMethod) {
    case 'GET':
      dynamo.scan({ TableName: 'Story' }, done);
      break;
    case 'POST':
      dynamo.putItem(JSON.parse(event.body), done);
      break;
    // case 'PUT':
    //   dynamo.updateItem(JSON.parse(event.body), done);
    //   break;
    default:
      done(new Error(`Unsupported method "${event.httpMethod}"`));
  }
};
