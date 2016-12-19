'use strict';

const statusResponse = {
    salutation: 'Greetings from the StoryTime server.',
    status: 'Feeling great!',
    version: 'alpha'
};

exports.handler = (event, context, callback) => {
    callback(null, statusResponse);
};
