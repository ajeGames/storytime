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

var scanAllTables = function() {
  admin.scan('Stories');
  admin.scan('Chapters');
}

// destroyAllTables();
// createAllTables();
// admin.listTables();
scanAllTables();

var story = {
  storyID: 'ABC123',
  title: 'Blargy',
  author: 'Bubba',
  tagLine: 'Read it now.',
  about: 'This is amazing!!!',
  firstChapter: 1000,
};
// StoriesTable.addStory(story);

var chapters = [
  {
    chapterID: 1000,
    heading: 'The Cave',
    prose: "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes. What would you like to do?",
    signPost: [
      {
        chapterID: 1001,
        teaser: 'Step inside.'
      },
      {
        chapterID: 1002,
        teaser: 'Continue walking.'
      }
    ]
  },
  {
    chapterID: 1001,
    heading: 'A Cool Breeze',
    prose: 'As your eyes adjust to the light, you feel a cool breeze on your face.  You are drawn toward the musty smells as curiosity takes over.',
    signPost: [
      {
        chapterID: 1003,
        teaser: 'Walk toward the breeze.'
      },
      {
        chapterID: 1004,
        teaser: 'Explore the room you are in.'
      },
      {
        chapterID: 1005,
        teaser: 'Leave the cave.'
      }
    ]
  },
  {
    chapterID: 1002,
    heading: 'You Die!',
    prose: 'Unfortunately, fate is not on your side today.  As you step around the rocks, you are bitten by a rattlesnake.  Now you realize what that ominous noise was.  If only you had been paying attention.  Sorry.',
    signPost: []
  },
  {
    chapterID: 1003,
    heading: 'Slippery Slope',
    prose: 'As you head further into the cave, the floor becomes moist.  As you continue, things get slippery.  Next thing you know, you are sliding uncontrollably.',
    signPost: []
  },
  {
    chapterID: 1004,
    heading: 'Treasure',
    prose: 'You notice part of the cave floor is hollow.  With a little digging, you discover a treasure chest.  You are set for life.',
    signPost: []
  },
  {
    chapterID: 1005,
    heading: null,
    prose: null,
    signPost: []
  }
];
// chapters.forEach(function(chapter) {
//   ChaptersTable.addChapter('ABC123', chapter);
// });
