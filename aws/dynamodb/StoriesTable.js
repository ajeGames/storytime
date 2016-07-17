var CommonAdmin = require('./CommonAdmin');
var dynamodb = CommonAdmin.dynamodb;
var handleResponse = CommonAdmin.handleResponse;

exports.create = function() {
  var params = {
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
  dynamodb.createTable(params, handleResponse);
};

exports.delete = function() {
  var params = {
    TableName: 'Stories',
  };
  dynamodb.deleteTable(params, handleResponse);
};
