export const STORY1 = {
  summary : {
    key : "o9s0toym",
    title : "The Dark Cave",
    author : "Mr. Bubba Gumpz",
    tagLine : "What lies beneath may kill you",
    about : "See where your choices lead.  You can choose your own destiny, but can you escape fate?  Unlikely.",
    firstChapter : {
      targetChapterId : 1000,
      teaser : "This might be a good day to take some risks.  Or to stay in bed."
    }
  },
  chapters : [
    {
      id : 1000,
      heading : "The Cave",
      prose : "It's a nice day, so you decide to go for a walk.  You should know better by now.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?",
      nextChapterOptions : [
        {
          targetChapterId : 1001,
          teaser : "Go on.  Step inside."
        },{
          targetChapterId : 1002,
          teaser : "Better keep walking."
        }
      ]
    },{
      id : 1001,
      heading : "You Win!",
      prose : "As your eyes adjust to the light, you see an amazing sight.  The room is filled with treasure, most likely abandoned by pirate many centuries ago.  You take the treasure out of the cave, and bring it home.  There is enough wealth for a lifetime of enjoyment.  Congratulations!",
      nextChapterOptions : []
    },{
      id : 1002,
      heading : "You Die!",
      prose : "Unfortunately, fate is not on your side today.  As you step around the rocks, you are bitten by a rattlesnake.  Now you realize what that ominous noise was.  If only you had been paying attention.\n\nSorry.",
      nextChapterOptions : []
    }
  ]
};

export const SAMPLE2 = {
  summary: {
    key: "ABCD1234",
    title: "Title",
    author: "Author",
    tagLine: "Tag Line",
    about: "About",
    firstChapter: {
      targetChapterId: 1,
      teaser: "Teaser"
    }
  },
  chapters: [
    {
      id: 1,
      heading: "Heading 1",
      prose: "Prose 1",
      nextChapterOptions: [
        {
          targetChapterId: 2,
          teaser: "Teaser 1-1"
        }, {
          targetChapterId: 3,
          teaser: "Teaser 1-2"
        }
      ]
    }, {
      id: 2,
      heading: "Heading 2",
      prose: "Prose 2",
      nextChapterOptions: []
    }, {
      id: 3,
      heading: "Heading 3",
      prose: "Prose 3",
      nextChapterOptions: []
    }
  ]
};
