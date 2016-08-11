const AWS = require('aws-sdk');

// TODO get from environment
AWS.config.update({
  region: 'us-west-2',
  endpoint: 'http://localhost:8000',
});

export const dynamodb = new AWS.DynamoDB();
export const docClient = new AWS.DynamoDB.DocumentClient();

export function handleResponse(err, data) {
  if (err) {
    console.error('Unable to perform action. Error:', JSON.stringify(err, null, 2));
  } else {
    console.log('Action completed. Result:', JSON.stringify(data, null, 2));
  }
}

export function listTables() {
  dynamodb.listTables({}, handleResponse);
}

export function scan(tableName) {
  dynamodb.scan({ TableName: tableName }, handleResponse);
}
