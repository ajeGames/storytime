(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('EditorController', EditorController);

    StoryController.$inject = ['$routeParams', 'StoryServer'];

    function EditorController($routeParams, StoryService) {
        console.log('EditorController: constructor')
        var vm = this;

        // === Story summary edit logic ===

        vm.draft = {};
        vm.isEdit = true;

        vm.save = function () {
          if (vm.draft.key == null) {
            vm.draft.key = Date.now();  // TODO backend will do this when hooked up
            vm.catalog.push(vm.draft);  // new story, so add to list
          } else {
            for (var i in vm.catalog) {
              if (vm.catalog[i].key == vm.draft.key) {
                vm.catalog[i] = vm.draft;
              }
            }
          }
          vm.isEdit = false;
        };

        vm.edit = function (key) {
          for (var i in vm.catalog) {
            if (vm.catalog[i].key == key) {
              vm.draft = angular.copy(vm.catalog[i]);
              break;
            }
          }
          vm.isEdit = true;
        };

        vm.load = function (key) {
          for (var i in vm.catalog) {
            if (vm.catalog[i].key == key) {
              vm.draft = vm.catalog[i];
              vm.draftScene = vm.draft.firstScene;
              if (vm.draftScene.nextSceneOptions == null) {
                vm.draftScene.nextSceneOptions = [];
              }
              break;
            }
          }
          vm.isEdit = false;
        };

        vm.clear = function () {
          vm.draft = {};
          vm.isEdit = true;
        };

        vm.updateScene = function () {
          if (vm.draftScene.key == null) {
            vm.draftScene.key = Date.now();  // TODO backend will do this when hooked up
            vm.draftScene.nextSceneOptions = [];
          }
        };

        // === Scene edit logic ===

        vm.draftScene = {};

        vm.nextSceneTeaser = null;

        vm.addSceneOption = function () {
          if (vm.nextSceneTeaser != null) {
            var sceneOption = {'key': Date.now(), 'teaser': vm.nextSceneTeaser};
            vm.draftScene.nextSceneOptions.push(sceneOption);
            vm.nextSceneTeaser = null;
          }
        };

        vm.removeSceneOption = function (key) {
          for (var i in vm.draftScene.nextSceneOptions) {
            if (vm.draftScene.nextSceneOptions[i].key == key) {
              vm.draftScene.nextSceneOptions.splice(i, 1);
              break;
            }
          }
        };
    }

})();
