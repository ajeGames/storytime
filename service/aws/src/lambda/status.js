/**
 * Administrative functions of the StoryTime service.
 */
exports.handler = function(event, context, callback) {
  console.log('Called handleStoryTimeEvents with event: ' + JSON.stringify(event));
  console.log('context=' + JSON.stringify(context));
  const status = {
    salutation: 'Greetings, Earthling.',
    status: 'green',
    version: '0.1.0'
  };
  callback(null, status);
}
