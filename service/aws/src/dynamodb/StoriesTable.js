const CommonAdmin = require('./CommonAdmin');
const dynamodb = CommonAdmin.dynamodb;
const docClient = CommonAdmin.docClient;
const handleResponse = CommonAdmin.handleResponse;

export function create() {
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

export function deleteTable() {
  const params = {
    TableName: 'Stories',
  };
  dynamodb.deleteTable(params, handleResponse);
}

function generateRandomID() {
  let text = '';
  const possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  for (let i = 0; i < 10; i++) {
    text += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  return text;
}

export function addStory(story) {
  const params = {
    TableName: 'Stories',
    Item: {
      storyID: generateRandomID(),
      title: story.title,
      author: story.author,
      tagLine: story.tagLine,
      about: story.about,
    },
  };
  docClient.put(params, handleResponse);
}
