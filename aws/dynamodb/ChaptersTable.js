var CommonAdmin = require('./CommonAdmin');
var dynamodb = CommonAdmin.dynamodb;
var handleResponse = CommonAdmin.handleResponse;

exports.create = function() {
  var params = {
    TableName : "Chapters",
    KeySchema: [
      { AttributeName: "storyID", KeyType: "HASH"},
      { AttributeName: "chapterID", KeyType: "RANGE"},
    ],
    AttributeDefinitions: [
      { AttributeName: "storyID", AttributeType: "S" },
      { AttributeName: "chapterID", AttributeType: "N" },
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
    TableName: 'Chapters',
  };
  dynamodb.deleteTable(params, handleResponse);
}
