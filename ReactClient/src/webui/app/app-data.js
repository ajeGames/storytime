const stateShape = {
  user: {
    key: "jiojesf93fioj3w",
    screenName: "Sir Walter Raleigh",
    penName: "Bubba Gump"
  },
  story: {
    summary: {
      key: "o9s0toym",
      title: "The Cave",
      author: "Bubba Gump",
      tagLine: "What lies beneath",
      about: "See where your choices lead.  You can choose your own destiny, but can you escape fate?",
      firstChapter: 1000
    },
    chapters: {
      1000: {
        id: 1000,
        heading: "The Cave",
        prose: "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?",
        signPost: [
          {
            chapterId: 1001,
            teaser: "Step inside"
          }, {
            chapterId: 1002,
            teaser: "Continue walking"
          }
        ]
      },
      1001: {
        id: 1001,
        heading: "It's Dark in Here",
        prose: "You step into the cave.  The cave is very dark.  Once your eyes have time to adjust, you notice a room off to the right.  You also feel a light breeze from deep inside the cave.  Of course, the entrace is right behind you.",
        signPost: [
          {
            chapterId: 1003,
            teaser: "Walk toward the breeze."
          }, {
            chapterId: 1004,
            teaser: "Explore the room."
          }, {
            chapterId: 1005,
            teaser: "Leave the cave."
          }
        ]
      },
      1002: {
        id: 1002,
        heading: "The Hole",
        prose: "Even though you wanted to walk outside, you step into a hole that was covered by leaves and sticks.  Now you are in the cave anyway.",
        signPost: [
          {
            chapterId: 1001,
            teaser: "Meet your fate inside the cave."
          }
        ]
      },
      1003: {
        id: 1003,
        heading: "Slippery Slope",
        prose: "As you head into the cave, the floor slopes downwards.  You notice that the walls are wet.  The floor is also wet.  You go into a slide that lands you in a shallow pool.  Wheee!  The End."
      },
      1004: {
        id: 1004,
        heading: "The Treasure",
        prose: "You notice a mound of dirt in one corner of the room.  A little digging reveals the lid of a treasure chest.  The chest is full of gems.  You are set for life.  The End."
      },
      1005: {
        id: 1005,
        heading: "A Dull Life",
        prose: "That was quick.  I guess you are not much for adventure.  Go home and live the rest of your dull, boring life.  The End."
      }
    }
  },
  draft: {
    summary: {
      key: "o9s0toym",
      title: "The Cave",
      author: "Bubba Gump",
      tagLine: "What lies beneath",
      about: "See where your choices lead.  You can choose your own destiny, but can you escape fate?",
      firstChapter: 1000
    },
    chapter: {
      id: 1000,
      heading: "The Cave",
      prose: "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?",
      signPost: [
        {
          chapterId: 1001,
          teaser: "Step inside"
        }, {
          chapterId: 1002,
          teaser: "Continue walking"
        }
      ]
    }
  }
};
