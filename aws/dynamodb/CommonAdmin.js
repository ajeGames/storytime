var AWS = require("aws-sdk");

AWS.config.update({
  region: "us-west-2",
  endpoint: "http://localhost:8000"
});

exports.dynamodb = new AWS.DynamoDB();

exports.handleResponse = function(err, data) {
  if (err) {
    console.error("Unable to perform action. Error:", JSON.stringify(err, null, 2));
  } else {
    console.log("Action completed. Result:", JSON.stringify(data, null, 2));
  }
};
