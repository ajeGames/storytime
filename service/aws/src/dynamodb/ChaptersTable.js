const CommonAdmin = require('./CommonAdmin');
const dynamodb = CommonAdmin.dynamodb;
const docClient = CommonAdmin.docClient;
const handleResponse = CommonAdmin.handleResponse;

export function createTable() {
  const params = {
    TableName: 'Chapters',
    KeySchema: [
      { AttributeName: 'storyID', KeyType: 'HASH' },
      { AttributeName: 'chapterID', KeyType: 'RANGE' },
    ],
    AttributeDefinitions: [
      { AttributeName: 'storyID', AttributeType: 'S' },
      { AttributeName: 'chapterID', AttributeType: 'N' },
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
    TableName: 'Chapters',
  };
  dynamodb.deleteTable(params, handleResponse);
}

export function addChapter(storyID, chapter) {
  const params = {
    TableName: 'Chapters',
    Item: {
      storyID,
      chapterID: chapter.chapterID,
      heading: chapter.heading,
      prose: chapter.prose,
      signPost: chapter.signPost,
    },
  };
  docClient.put(params, handleResponse);
}
