(function () {
  'use strict';

  angular
      .module('storyTimeApp')
      .controller('CatalogCtrl', CatalogController);

  function CatalogController(StoryService) {
    var vm = this;

    // === Story summary edit logic ===
    vm.catalog = loadCatalog();

    function loadCatalog() {
      StoryService.fetchAllStories().then(
          function (stories) {
            applyRemoteData(stories);
          });
    }

    function applyRemoteData(stories) {
      vm.catalog = stories;
    }

    function deleteStory(key) {
      StoryService.deleteStory(key);
      for (var i in vm.catalog) {
        if (vm.catalog[i].key == key) {
          vm.catalog.splice(i, 1);
          vm.draft = {};
          break;
        }
      }
    }
  }
})();
