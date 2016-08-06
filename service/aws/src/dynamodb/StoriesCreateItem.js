var AWS = require('aws-sdk');

AWS.config.update({
  region: "us-west-2",
  endpoint: "http://localhost:8000"
});

var docClient = new AWS.DynamoDB.DocumentClient();

var params = {
  TableName: "Stories",
  Item: {
    StoryID: "kjkjkj3423423"
  }
};

console.log("Adding a new story");
docClient.put(params, function(err, data) {
  if (err) {
    console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
  } else {
    console.log("Added items:", JSON.stringify(data, null, 2));
  }
});
