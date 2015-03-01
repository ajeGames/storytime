StoryTime Application
=====================

Use cases and API methods
-------------------------

*Viewing*

**List stories**

* Return a list of all available stories.
** Story includes key, title, description

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
