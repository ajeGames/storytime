const statusResponse = {
    salutation: 'Greetings from the StoryTime server.',
    status: 'Feeling great!',
    version: 'alpha'
};

exports.statusHandler = (event, context, callback) => {
    callback(null, statusResponse);
};

const storyReponse = {
  title: 'the wumpus',
  author: 'the wumpus',
  tagLine: 'the wumpus was here',
  about: 'what is the wumpus?',
  firstChapter: {
    chapterId: 1,
    teaser: 'start here'
  }
};

exports.createStoryHandler = (event, context, callback) => {
  console.log("Event", JSON.stringify(event, null, 2));
  let newStory = event;
  newStory.key = "flkjq3#p98j%3if@jf";
  newStory.firstChapter = {
      chapterId: 1,
      teaser: 'start here'
  };
  callback(null, newStory);
}
