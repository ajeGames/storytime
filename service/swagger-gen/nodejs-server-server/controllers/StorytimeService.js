'use strict';

exports.createChapter = function(args, res, next) {
  /**
   * Creates new chapter with given information.
   * Creates a chapter with the information provided, assigning a chapter ID.
   *
   * storyId String key of story to add chapter to
   * chapter Chapter Chapter information
   * returns inline_response_200_1
   **/
  var examples = {};
  examples['application/json'] = {
  "prose" : "aeiou",
  "chapterId" : "aeiou",
  "signpost" : [ {
    "destinationId" : "aeiou",
    "teaser" : "aeiou"
  } ],
  "title" : "aeiou"
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.createStory = function(args, res, next) {
  /**
   * Creates new story with given information.
   * Creates a story with the information provided, assigning a unique key.
   *
   * story Story Story summary
   * returns inline_response_201_1
   **/
  var examples = {};
  examples['application/json'] = {
  "storyId" : "aeiou",
  "penName" : "aeiou",
  "publishedAt" : "2000-01-23T04:56:07.000+00:00",
  "tagLine" : "aeiou",
  "draft" : true,
  "about" : "aeiou",
  "genre" : [ "aeiou" ],
  "firstChapter" : "aeiou",
  "title" : "aeiou",
  "authorId" : "aeiou",
  "category" : [ "aeiou" ],
  "version" : 123
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.getChapter = function(args, res, next) {
  /**
   * Retrieves chapter with given ID of story with given key.
   * Retrieves chapter with given ID of story with given key.
   *
   * storyId String unique key of story to retrieve
   * chapterId String chapter ID
   * returns inline_response_200_1
   **/
  var examples = {};
  examples['application/json'] = {
  "prose" : "aeiou",
  "chapterId" : "aeiou",
  "signpost" : [ {
    "destinationId" : "aeiou",
    "teaser" : "aeiou"
  } ],
  "title" : "aeiou"
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.getChapters = function(args, res, next) {
  /**
   * Gets all of the chapter of given story
   * Gets every chapter of given story.
   *
   * storyId String key of story to add chapter to
   * returns List
   **/
  var examples = {};
  examples['application/json'] = [ {
  "prose" : "aeiou",
  "chapterId" : "aeiou",
  "signpost" : [ {
    "destinationId" : "aeiou",
    "teaser" : "aeiou"
  } ],
  "title" : "aeiou"
} ];
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.getStorySummaries = function(args, res, next) {
  /**
   * Gets all of the story summaries
   * Gets every story summary. Results might be truncated for paging.
   *
   * returns List
   **/
  var examples = {};
  examples['application/json'] = [ {
  "storyId" : "aeiou",
  "penName" : "aeiou",
  "publishedAt" : "2000-01-23T04:56:07.000+00:00",
  "tagLine" : "aeiou",
  "draft" : true,
  "about" : "aeiou",
  "genre" : [ "aeiou" ],
  "firstChapter" : "aeiou",
  "title" : "aeiou",
  "authorId" : "aeiou",
  "category" : [ "aeiou" ],
  "version" : 123
} ];
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.getStorySummary = function(args, res, next) {
  /**
   * Returns story summary for given key
   * Returns the summary of the story indentified by key.
   *
   * storyId String unique key of story to retrieve
   * returns inline_response_201_1
   **/
  var examples = {};
  examples['application/json'] = {
  "storyId" : "aeiou",
  "penName" : "aeiou",
  "publishedAt" : "2000-01-23T04:56:07.000+00:00",
  "tagLine" : "aeiou",
  "draft" : true,
  "about" : "aeiou",
  "genre" : [ "aeiou" ],
  "firstChapter" : "aeiou",
  "title" : "aeiou",
  "authorId" : "aeiou",
  "category" : [ "aeiou" ],
  "version" : 123
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.patchChapter = function(args, res, next) {
  /**
   * Replaces a portion of the chapter
   * Replaces a portion of the chapter -- the prose, the signpost, etc. without touching the rest
   *
   * storyId String unique key of story to update
   * chapterId String chapter ID
   * chapter Chapter_2 Chapter information
   * returns inline_response_200_1
   **/
  var examples = {};
  examples['application/json'] = {
  "prose" : "aeiou",
  "chapterId" : "aeiou",
  "signpost" : [ {
    "destinationId" : "aeiou",
    "teaser" : "aeiou"
  } ],
  "title" : "aeiou"
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.updateChapter = function(args, res, next) {
  /**
   * Updates chapter with given information.
   * Updates the given chapter of given story.
   *
   * storyId String unique key of story to update
   * chapterId String chapter ID
   * chapter Chapter_1 Chapter information
   * returns inline_response_200_1
   **/
  var examples = {};
  examples['application/json'] = {
  "prose" : "aeiou",
  "chapterId" : "aeiou",
  "signpost" : [ {
    "destinationId" : "aeiou",
    "teaser" : "aeiou"
  } ],
  "title" : "aeiou"
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.updateStorySummary = function(args, res, next) {
  /**
   * Updates a story summary with given information.
   * Creates a story with the information provided, assigning a unique key.
   *
   * storyId String unique key of story to update
   * story Story_1 Story summary
   * returns inline_response_201_1
   **/
  var examples = {};
  examples['application/json'] = {
  "storyId" : "aeiou",
  "penName" : "aeiou",
  "publishedAt" : "2000-01-23T04:56:07.000+00:00",
  "tagLine" : "aeiou",
  "draft" : true,
  "about" : "aeiou",
  "genre" : [ "aeiou" ],
  "firstChapter" : "aeiou",
  "title" : "aeiou",
  "authorId" : "aeiou",
  "category" : [ "aeiou" ],
  "version" : 123
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

