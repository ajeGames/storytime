var AWS = require("aws-sdk");

AWS.config.update({
  region: "us-west-2",
  endpoint: "http://localhost:8000"
});

var dynamodb = new AWS.DynamoDB();

var params = {
  TableName : "Chapters",
  KeySchema: [
    { AttributeName: "StoryID", KeyType: "HASH"},
    { AttributeName: "ChapterID", KeyType: "RANGE"},
  ],
  AttributeDefinitions: [
    { AttributeName: "StoryID", AttributeType: "S" },
    { AttributeName: "ChapterID", AttributeType: "N" },
  ],
  ProvisionedThroughput: {
    ReadCapacityUnits: 1,
    WriteCapacityUnits: 1
  }
};

dynamodb.createTable(params, function(err, data) {
  if (err) {
    console.error("Unable to create table. Error JSON:", JSON.stringify(err, null, 2));
  } else {
    console.log("Created table. Table description JSON:", JSON.stringify(data, null, 2));
  }
});
