var StoriesTable = require('./dynamodb/StoriesTable');
var ChaptersTable = require('./dynamodb/ChaptersTable');

var admin = require('./dynamodb/CommonAdmin');

// TODO not using aynch correctly; these steps need to be gated by callbacks

var destroyAllTables = function() {
  // wipe out everything
  StoriesTable.delete();
  ChaptersTable.delete();
}

var createAllTables = function() {
  // create new tables
  StoriesTable.create();
  ChaptersTable.create();
}

createAllTables();
admin.listTables();
