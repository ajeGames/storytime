const AWS = require('aws-sdk');

// TODO get from environment
AWS.config.update({
  region: 'us-west-2',
  endpoint: 'http://localhost:8000',
});

const dynamodb = new AWS.DynamoDB();
const docClient = new AWS.DynamoDB.DocumentClient();

function handleResponse(err, data) {
  if (err) {
    console.error('Unable to perform action. Error:', JSON.stringify(err, null, 2));
  } else {
    console.log('Action completed. Result:', JSON.stringify(data, null, 2));
  }
}

function listTables() {
  dynamodb.listTables({}, handleResponse);
}

function scan(tableName) {
  dynamodb.scan({ TableName: tableName }, handleResponse);
}

exports.listTables = listTables;
exports.scan = scan;
exports.dynamodb = dynamodb;
exports.docClient = docClient;
exports.handleResponse = handleResponse;
