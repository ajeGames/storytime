/**
 * Created by dmount on 2/13/15.
 */

(function() {
  var app = angular.module('storytime', []);

  app.controller('StoryController', function() {
    this.draft = story;
  });

  var story = {
    title: "The Itsy Bitsy Spider",
    author: "Kids Place Live",
    tagline: "Watch what this spider does."
  }
})();

