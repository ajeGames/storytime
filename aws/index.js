var StoriesTable = require('./dynamodb/StoriesTable');
var ChaptersTable = require('./dynamodb/ChaptersTable');

var reset = function() {
  // wipe out everything
  StoriesTable.delete();
  ChaptersTable.delete();

  // create new tables
  StoriesTable.create();
  ChaptersTable.create();
}
