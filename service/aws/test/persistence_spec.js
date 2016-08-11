const expect = require('chai').expect;
const ChaptersTable = require('../src/dynamodb/ChaptersTable');

describe('Story Table admin', () => {
  it('works', () => {
    ChaptersTable.createTable();
    expect(true).is.equal(true);
  });
});
