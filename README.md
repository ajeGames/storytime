StoryTime Application
=====================

Use cases and API methods
-------------------------

*Viewing*

**List stories**

* Return a list of all available stories.

`listStories()`

**Get story**

* Return story information.  Might have options or it might be an ending.

`getStory(key)`

**Get scene**

* Return story information.  Might have next scene options or it might be an ending.

`getScene(key)`


*Authoring*

**Start a story**

* Register a new story in the system.
* Returns the story information that includes a reference to the first scene to be edited.

`startStory(title, description)`

**Add a scene**

* Register a new scene as an option from the scene referenced by `sceneToFollowKey`.

`addNextScene(sceneToFollowKey, summary)`

**Edit scene**

* Change something editable about the scene referenced by the given `key`.

`editScene(key, summary, prose)`

**Edit scene summary**

* Change the summary of the scene with the given key.

`editSceneSummary(key, summary)`

**Edit scene prose**

* Change the scene with the given `key`.

`editSceneContent(key, prose)`

## JSON Objects

Story

    {
        "key": "dw8nhv63",
        "title": "The Three Little Pigs",
        "author": "Bros. Grimm",
        "tagLine": "A lesson in economics.",
        "description": "What happens when forest creatures try to strike a healthy work-life balance?",
        "firstScene": "dw8nhv63-1"
    }
    
Scene

    {
      "key": "dw8nhv63-1",
      "teaser": "A man walks into a bar...",
      "heading": "This is funny.",
      "prose": "A man walks into a bar and says, \"Ouch\"",
      "nextSceneOptions": [
        "dw8nhv63-2", "dw8nhv63-3"
      ]
    }
    
