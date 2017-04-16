export const normalStory = {
  summary: {
    key: "o9s0toym",
    title: "The Cave",
    author: "Bubba Gumpzzz",
    tagLine: "You want to read this.",
    about: "Sometimes life compels you great things.  And sometimes you'd rather play this game.",
    firstChapter: 1000
  },
  chapter: {
    id: 1000,
    title: "The Cave",
    prose: "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?",
    signPost: []
  }
};

export const fullStory = {
  summary: {
    storyKey: "uniquestorykey1",
    versionStamp: "somekindofchecksumtodetectwhentherehasbeenachange",
    author: {
      id: "arn::userkey",
      penName: "Bubba"
    },
    tagLine: "tag line",
    about: "about",
    qualifiers: {
      rating: "5 stars",
      genre: [
        "mystery", "suspense", "sci-fi"
      ]
    }
  },
  firstChapter: "uniquechapterkey2",
  chapters: {
    uniquechapterkey2: {
      chapterId: "uniquechapterkey2",
      versionStamp: "somekindofchecksumtodetectwhentherehasbeenachange",
      title: "Danger Lies Within",
      prose: "blah blah blah blah blah blah with some kind of handlebars for styling, image placement, etc.",
      signpost: [
        {
          destination: "uniquechapterkey3",
          teaser: "Take this path, sucker."
        },
        {
          destination: "uniquechapterkey4",
          teaser: "You are making the right choice, dupe."
        }
      ]
    },
    uniquechapterkey3: {
      versionStamp: "somekindofchecksumtodetectwhentherehasbeenachange",
      title: "The End",
      prose: "Now you have done it.  Good-bye.",
      signpost: []
    },
    uniquechapterkey4: {
      versionStamp: "somekindofchecksumtodetectwhentherehasbeenachange",
      title: "The End",
      prose: "The universe has decided to reclaim your matter.  The End (for you).",
      signpost: []
    }
  }
};
