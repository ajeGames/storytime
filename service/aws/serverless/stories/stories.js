"use strict";

const awsHelpers = require('awsHelpers');
const storyKeyLength = 12;

function generateStoryKey(length) {
  const possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  let key = "";
  for(var i = 0; i < length; i++) {
    key += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  return key;
}

class Stories {
  constructor(db, storyTableName) {
    this.db = db;
    this.storyTableName = storyTableName;
  }

  getSummaries(callback) {
    const params = {
      TableName: this.storyTableName,
      AttributesToGet: [ 'summary' ],
      ConsistentRead: true
    };
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err));
      } else {
        callback(null, awsHelpers.buildSuccess(res.Items));
      }
    };
    this.db.scan(params, processResults);
  }

  getStory(storyKey, callback) {
    const params = {
      TableName: this.storyTableName,
      Key: {
        storyKey: storyKey
      }
    };
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err));
      } else {
        if (res.Item === undefined) {
          callback(null, awsHelpers.buildErrorNotFound(storyKey));
        } else {
          callback(null, awsHelpers.buildSuccess(res.Item.summary));
        }
      }
    };
    this.db.get(params, processResults);
  }

  createStory(summaryIn, callback) {
    // validate input
    if (summaryIn.title === undefined) {
      callback(null, awsHelpers.buildErrorRequiredField('title'));
      return;
    }
    if (typeof summaryIn.title !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('title', 'string'));
      return;
    }
    if (typeof summaryIn.author !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('author', 'string'));
      return;
    }
    if (typeof summaryIn.tagLine !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('tagLine', 'string'));
      return;
    }
    if (typeof summaryIn.about !== 'string') {
      callback(null, awsHelpers.buildErrorInvalidInput('about', 'string'));
      return;
    }

    // save
    const storyKey = generateStoryKey(storyKeyLength);
    const summary = {
      key: storyKey,
      title: summaryIn.title,
      author: summaryIn.author,
      tagLine: summaryIn.tagLine,
      about: summaryIn.about
    };
    const params = {
      TableName: this.storyTableName,
      Item: {
        storyKey: storyKey,
        summary: summary
      },
      ConditionExpression: 'attribute_not_exists(storyKey)' // fail if key is in use -- worth the risk
    };
    const processResults = (err, res) => {
      if (err) {
        callback(null, awsHelpers.buildErrorDataAccess(err));
      } else {
        callback(null, awsHelpers.buildSuccess(summary, 201));
      }
    };
    this.db.put(params, processResults);
  }

  updateStory(storyKey, updateIn, callback) {
    const fieldsToUpdate = ['title', 'author', 'tagLine', 'about'];

    // construct update expressions
    let updExpr = 'set ';
    const offset = updExpr.length;
    let exprAttrValues = {};
    const numFields = fieldsToUpdate.length;
    for (let i = 0; i < numFields; i++) {
      let fieldName = fieldsToUpdate[i];
      let bodyFieldValue = updateIn[fieldName];
      if (bodyFieldValue === undefined || bodyFieldValue === '') {
        continue;
      }
      if (updExpr.length > offset) {
        updExpr += ', ';
      }
      let placeholder = ':' + fieldName;
      updExpr += 'summary.' + fieldName + ' = ' + placeholder;
      exprAttrValues[placeholder] = bodyFieldValue;
    }

    // do not allow noop, must call with something worth updating
    if (updExpr.length === offset) {
      callback(null, awsHelpers.buildErrorRequiredField('any or all of [' + fieldsToUpdate + ']'));
      return;
    }

    // save updates
    const params = {
      TableName: this.storyTableName,
      Key: {
        storyKey: storyKey
      },
      UpdateExpression: updExpr,
      ExpressionAttributeValues: exprAttrValues,
      ReturnValues: "ALL_NEW"
    };
    const processResults = (err, res) => {
      if (err) {
        // TODO find graceful way to respond when not found
        callback(null, awsHelpers.buildErrorDataAccess(err));
      } else {
        callback(null, awsHelpers.buildSuccess(res.Attributes.summary));
      }
    };
    this.db.update(params, processResults);
  }
}

module.exports = Stories;
