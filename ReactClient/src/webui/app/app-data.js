let stateShape = {
  storySummary: {
    key: "o9s0toym",
    title: "The Cave",
    author: "Bubba Gump",
    tagLine: "What lies beneath",
    about: "See where your choices lead.  You can choose your own destiny, but can you escape fate?",
    firstChapter: 1000
  },
  draftChapter: {
    id: 1000,
    heading: "The Cave",
    prose: "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?"
  },
  chapters: [
    {1000: {}},
    {1001: {}},
    {1002: {}},
    {1003: {}},
    {1004: {}},
    {1005: {}}
  ],
  signpost: [
    {
      1000: [
        {
          chapterId: 1001,
          teaser: "Step inside"
        }, {
          chapterId: 1002,
          teaser: "Continue walking"
        }
      ]
    }, {
      1001: [
        {
          chapterId: 1003,
          teaser: "Walk toward the breeze."
        }, {
          chapterId: 1004,
          teaser: "Explore the room you are in."
        }, {
          chapterId: 1005,
          teaser: "Leave the cave."
        }
      ]
    }, {
      1003: []
    }, {
      1004: []
    }, {
      1005: []
    }
  ]
};
