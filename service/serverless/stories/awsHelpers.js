"use strict";

const headers = {
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin' : '*' // Required for CORS support to work
};

module.exports.prettyJsonLog = (thing, description) => {
  console.log(description, JSON.stringify(thing, null, 2));
}

module.exports.buildSuccess = (payload, statusCode) => {
  let code = statusCode ? statusCode : 200;
  return {
    statusCode: code,
    headers: headers,
    body: JSON.stringify(payload)
  };
}

module.exports.buildError = (statusCode, errorCode, errorMessage) => {
  return {
    statusCode: statusCode,
    headers: headers,
    body: JSON.stringify({
      errorCode: errorCode,
      message: errorMessage
    })
  };
}

module.exports.buildErrorRequiredField = (fieldName) => {
  return this.buildError('400', 'MissingRequiredField',
    'Request body missing required field: ' + fieldName);
}

module.exports.buildErrorInvalidInput = (fieldName, typeName) => {
  return this.buildError('400', 'InvalidInput',
    'Expected field [' + fieldName + '] to be of type [' + typeName + ']');
}

module.exports.buildErrorMalformedInput = () => {
  return this.buildError('400', 'MalformedInput', 'Unable to process input');
}

module.exports.buildErrorNotFound = (key) => {
  return this.buildError('404', 'NotFound', 'Nothing found with key: ' + key);
}

module.exports.buildErrorDataAccess = (err) => {
  prettyJsonLog(err, 'dynamodb err');
  return this.buildError('500', 'DataAccess', err.message);
}
