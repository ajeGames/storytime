"use strict";

const awsHelpers = require('awsHelpers');

class Stories {
  constructor(db, storyTableName) {
    this.db = db;
    this.storyTableName = storyTableName;
  }

  getSummaries(callback) {
    console.log(awsHelpers);
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
}

module.exports = Stories;
