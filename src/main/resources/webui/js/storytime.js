/**
 * Created by dmount on 2/13/15.
 */

(function() {
  var app = angular.module('storytime', []);

  app.controller('StoryController', function() {
    this.story = {};
    this.activeScene = {};
    this.nextSceneTeaser = '';
    this.newStory = true;
    this.editStory = true;
    this.editScene = false;

    this.updateStory = function() {
      if (this.newStory) {
        // TODO call server create method
        this.story.key = '123';
        this.story.firstScene = {};

        this.newStory = false;
        this.story.scenes = [this.story.firstScene];  // build list of scenes
        this.activeScene = this.story.firstScene;
      } else {
        // TODO call server update method
      };
      this.editStory = false;
      this.editScene = true;
    };

    this.editStory = function() {
      this.editStory = true;
      this.editScene = false;
    };

    this.updateScene = function() {
      // TODO submit scene info to server
      this.activeScene.key = '123';
      this.editScene = false;
    };

    this.editScene = function() {
      this.editScene = true;
    };

    this.addNextSceneOption = function() {

    };
  });
});

