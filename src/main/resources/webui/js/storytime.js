/**
 * Created by dmount on 2/13/15.
 */

(function() {
  var app = angular.module('storytime', []);

  app.controller('StoryController', function() {
    this.draft = story;
    this.draft.firstScene = scene;
  });

  var story = {
    title: "The Itsy Bitsy Spider",
    author: "Kids Place Live",
    tagline: "Watch what this spider does."
  }

  var scene = {
    heading: "Introduction",
    prose: "Once upon a time, there was a tiny, little spider who was thinking about where to go."
  }
})();

