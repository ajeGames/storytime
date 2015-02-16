/**
 * Created by dmount on 2/13/15.
 */

(function() {
  var app = angular.module('storytime', []);

  app.controller('StoryController', function() {
    this.story = {};
    this.activeScene = {};
    this.lastScene = {};
  });

  var story = {
    title: "The Itsy Bitsy Spider",
    author: "Kids Place Live",
    tagline: "Watch what this spider does.",
    firstSceneKey: "abc123"
  };

  // TODO figure this out
  var scene = {
    key: "abc123",
    heading: "Introduction",
    prose: "Once upon a time, there was a tiny, little spider who was thinking about where to go.",
    choices: [{
      key: "abc234", heading: "Go up the spout."
    }, {
      key: "abc345", heading: "Stay right where you are."
    }]
  };
})();

