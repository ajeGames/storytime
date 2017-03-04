'use strict'

module.exports.prettyJsonLog = (thing, description) => {
  console.log(description, JSON.stringify(thing, null, 2))
}

module.exports.generateRandomId = (length) => {
  const possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
  let key = ''
  for (var i = 0; i < length; i++) {
    key += possible.charAt(Math.floor(Math.random() * possible.length))
  }
  return key
}

const headers = {
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*' // Required for CORS support to work
}

module.exports.buildSuccess = (payload, statusCode) => {
  let code = statusCode || 200
  return {
    statusCode: code,
    headers: headers,
    body: JSON.stringify(payload)
  }
}

module.exports.buildError = (statusCode, errorCode, errorMessage) => {
  return {
    statusCode: statusCode,
    headers: headers,
    body: JSON.stringify({
      errorCode: errorCode,
      message: errorMessage
    })
  }
}

module.exports.buildErrorNotImplemented = () => {
  return this.buildError('501', 'NotImplemented',
    'This method has not been implemented')
}

module.exports.buildErrorRequiredField = (fieldName) => {
  return this.buildError('400', 'MissingRequiredField',
    'Request body missing required field: ' + fieldName)
}

module.exports.buildErrorInvalidInput = (fieldName, typeName) => {
  return this.buildError('400', 'InvalidInput',
    'Expected field [' + fieldName + '] to be of type [' + typeName + ']')
}

module.exports.buildErrorMalformedInput = () => {
  return this.buildError('400', 'MalformedInput', 'Unable to process input')
}

module.exports.buildErrorNotFound = (key) => {
  return this.buildError('404', 'NotFound', 'Nothing found with key: [' + key + ']')
}

module.exports.buildErrorDataAccess = (err) => {
  this.prettyJsonLog(err, 'dynamodb err')
  return this.buildError('500', 'DataAccess', err.code + ': ' + err.message)
}

module.exports.buildUpdateExpressions = (fieldsToUpdate, valuesIn) => {
  let updExpr = 'set '
  const offset = updExpr.length
  let exprAttrValues = {}
  const numFields = fieldsToUpdate.length
  for (let i = 0; i < numFields; i++) {
    let fieldName = fieldsToUpdate[i]
    let bodyFieldValue = valuesIn[fieldName]
    if (bodyFieldValue === undefined || bodyFieldValue === '') {
      continue
    }
    if (updExpr.length > offset) {
      updExpr += ', '
    }
    let placeholder = ':' + fieldName
    updExpr += 'details.' + fieldName + ' = ' + placeholder
    exprAttrValues[placeholder] = bodyFieldValue
  }
  // do not allow noop, must call with something worth updating
  if (updExpr.length === offset) {
    return
  }
  return (updExpr.length === offset)
    ? {isEmpty: true, expression: '', values: ''}
    : {isEmpty: false, expression: updExpr, values: exprAttrValues}
}
