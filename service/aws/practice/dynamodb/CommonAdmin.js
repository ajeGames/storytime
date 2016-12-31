import AWS from 'aws-sdk'

// TODO get from environment
AWS.config.update({
  region: 'us-west-2',
  endpoint: 'http://localhost:8000'
})

export const dynamodb = new AWS.DynamoDB()
export const docClient = new AWS.DynamoDB.DocumentClient()

export function handleResponse (err, data) {
  if (err) {
    return false
  }
  return data
}

export function listTables () {
  dynamodb.listTables({}, handleResponse)
}

export function scan (tableName) {
  dynamodb.scan({ TableName: tableName }, handleResponse)
}

export function isAlive () {
  dynamodb.listTables()
}
