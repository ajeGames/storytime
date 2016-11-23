# Developer's Guide for StoryTime
*What Developers Need to Know*

## REST API
This is a summary of the resources and actions you can take via the StoryTime REST API.

**/stories**
* post - creates a story summary, including a pointer to the first chapter

**/stories/{key}**
* get - returns story summary given its key
* put - updates a story summary
* delete - deletes the story

**/stories/{key}/chapters**
* post - creates a new chapter using given information

**/stories/{key}/chapters/{id}**
* get - returns a chapter given its id
* put - updates a chapter
* delete - deletes a chapter from the story

**/stories/{key}/chapters/{id}/signpost**
* get - returns an array of choices for what happens next (a.k.a. signs)
* put - updates next chapter options
* patch - updates specified options, leaving others intact

### Definitions

**StorySummary**
* **key** - string
* **title** - string
* **author** - ref:Player
* **tagLine** - string
* **about** - string
* **published** - boolean
* **firstChapter** - ChapterSign

**Chapter**
* **id** - integer
* **heading** - string
* **prose** - string
* **signPost** - ChapterSign[]

**ChapterSign**
* **targetChapterId** - integer
* **teaser** - string
