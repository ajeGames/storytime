var AWS = require("aws-sdk");

AWS.config.update({
  region: "us-west-2",
  endpoint: "http://localhost:8000"
});

var dynamodb = new AWS.DynamoDB();

var createParams = {
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

exports.createTable = function() {
  dynamodb.createTable(createParams, function(err, data) {
    if (err) {
      console.error("Unable to create table. Error JSON:", JSON.stringify(err, null, 2));
    } else {
      console.log("Created table. Table description JSON:", JSON.stringify(data, null, 2));
    }
  });
};
