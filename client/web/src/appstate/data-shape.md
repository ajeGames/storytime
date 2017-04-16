# Data Shape for Client State in Redux Store

```js
{
  "reader": {  // for specific state of reader application -- user, bookmark, history, etc.
    "screenName": "BillyJoe",
    "lastLogin": "2017-03-27T09:12:34.45Z",
    "activeStory": "uniquestorykey1",
    "activeStoryStatus": "loaded",  // other options: fetching, error, ...
    "activeChapter": "uniquechapterkey2",
    "activeChapterStatus": "fetching",  // other options: loaded, error, ...
    "breadcrumbs": [
      ["uniquechapterkey2", "uniquechapterkey4"]  // one list per traversal from first chapter
    ],
  },
  "library": {  // for read-only stories
    "uniquestorykey1": {
      "versionStamp": "somekindofchecksumtodetectwhentherehasbeenachange",
      "author": {
        "id": "arn::userkey",
        "penName": "Bubba"
      },
      "tagLine": "tag line",
      "about": "about",
      "qualifiers": {
        "rating": "5 stars",
        "genre": [
          "mystery", "suspense", "sci-fi"
        ]
      },
      "firstChapter": "uniquechapterkey2",
      "chapters": {
        "uniquechapterkey2": {
          "versionStamp": "somekindofchecksumtodetectwhentherehasbeenachange",
          "title": "Danger Lies Within",
          "prose": "blah blah blah blah blah blah with some kind of handlebars for styling, image placement, etc.",
          "signpost": [
            {
              "destination": "uniquechapterkey3",
              "teaser": "Take this path, sucker."
            },
            {
              "destination": "uniquechapterkey4",
              "teaser": "You are making the right choice, dupe."
            }
          ]
        },
        "uniquechapterkey3": {
          "versionStamp": "somekindofchecksumtodetectwhentherehasbeenachange",
          "title": "The End",
          "prose": "Now you have done it.  Good-bye.",
          "signpost": []
        },
        "uniquechapterkey4": {
          "versionStamp": "somekindofchecksumtodetectwhentherehasbeenachange",
          "title": "The End",
          "prose": "The universe has decided to reclaim your matter.  The End (for you).",
          "signpost": []
        }
      }
    }
  }
}
```
