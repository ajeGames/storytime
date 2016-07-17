var CommonAdmin = require('./CommonAdmin');
var dynamodb = CommonAdmin.dynamodb;
var docClient = CommonAdmin.docClient;
var handleResponse = CommonAdmin.handleResponse;

exports.create = function() {
  var params = {
    TableName : 'Stories',
    KeySchema: [
      { AttributeName: 'storyID', KeyType: 'HASH' },
    ],
    AttributeDefinitions: [
      { AttributeName: 'storyID', AttributeType: 'S' },
    ],
    ProvisionedThroughput: {
      ReadCapacityUnits: 1,
      WriteCapacityUnits: 1
    }
  };
  dynamodb.createTable(params, handleResponse);
};

exports.delete = function() {
  var params = {
    TableName: 'Stories',
  };
  dynamodb.deleteTable(params, handleResponse);
};

exports.addStory = function(story) {
  console.log('Given: ' + JSON.stringify(story));
  var params = {
    TableName: 'Stories',
    Item: {
      storyID: story.storyID,
      summary: {
        title: story.title,
        author: story.author,
        tagLine: story.tagLine,
        about: story.about,
        firstChapter: story.firstChapter,
      },
      chapters: story.chapters,
    }
  };
  docClient.put(params, handleResponse);
};
