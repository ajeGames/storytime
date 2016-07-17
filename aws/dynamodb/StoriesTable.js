var CommonAdmin = require('./CommonAdmin');
var dynamodb = CommonAdmin.dynamodb;
var handleResponse = CommonAdmin.handleResponse;

exports.createTable = function() {
  var createParams = {
    TableName : "Stories",
    KeySchema: [
      { AttributeName: "storyID", KeyType: "HASH" },
    ],
    AttributeDefinitions: [
      { AttributeName: "storyID", AttributeType: "S" },
    ],
    ProvisionedThroughput: {
      ReadCapacityUnits: 1,
      WriteCapacityUnits: 1
    }
  };
  dynamodb.createTable(createParams, handleResponse);
};

exports.deleteTable = function() {
  var deleteParams = {
    TableName: 'Stories',
  };
  dynamodb.deleteTable(deleteParams, handleResponse);
};
