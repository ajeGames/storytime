const CommonAdmin = require('./CommonAdmin');
const dynamodb = CommonAdmin.dynamodb;
const docClient = CommonAdmin.docClient;
const handleResponse = CommonAdmin.handleResponse;

function create() {
  const params = {
    TableName: 'Stories',
    KeySchema: [
      { AttributeName: 'storyID', KeyType: 'HASH' },
    ],
    AttributeDefinitions: [
      { AttributeName: 'storyID', AttributeType: 'S' },
    ],
    ProvisionedThroughput: {
      ReadCapacityUnits: 1,
      WriteCapacityUnits: 1,
    },
  };
  dynamodb.createTable(params, handleResponse);
}

function deleteTable() {
  const params = {
    TableName: 'Stories',
  };
  dynamodb.deleteTable(params, handleResponse);
}

function addStory(story) {
  console.log('Given: ${JSON.stringify(story)}');
  const params = {
    TableName: 'Stories',
    Item: {
      storyID: story.storyID,
      title: story.title,
      author: story.author,
      tagLine: story.tagLine,
      about: story.about,
      firstChapter: story.firstChapter,
    },
  };
  docClient.put(params, handleResponse);
}

exports.create = create;
exports.deleteTable = deleteTable;
exports.addStory = addStory;
