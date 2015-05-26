(function () {
  'use strict';

  angular
      .module('storyTimeApp')
      .controller('StoryCtrl', StoryController);

  function StoryController(StoryService) {
    var vm = this;
    vm.currentStory = {};
    vm.currentChapter = {};

    vm.loadStory = function (key) {
        currentStory = StoryService.getStory(key);
        currentChapter = currentStory.firstChapter;
    };

    vm.clearStory = function () {
      vm.currentStory = {};
      vm.currentChapter = {};
    };
  };

})();
