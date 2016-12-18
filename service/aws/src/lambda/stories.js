'use strict';

function unsupported() {
  const error = {
    errorCode: 42,
    message: 'The operation is not supported.'
  };
  return error;
}

exports.storyEventHandler = (event, context, callback) => {
  console.log('Received event:', JSON.stringify(event, null, 2));
  console.log('Received event:', JSON.stringify(context, null, 2));

  switch (event.httpMethod) {
    // case 'DELETE':
    //   callback(unsupported());
    //   break;
    // case 'GET':
    //   callback(unsupported());
    //   break;
    // case 'POST':
    //   callback(createStory());
    //   break;
    // case 'PUT':
    //   callback(unsupported());
    //   break;
    default:
      callback(null, unsupported());
  }
};
