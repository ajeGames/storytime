(function () {
  'use strict';

  angular
      .module('StoryTime')
      .controller('EditorController', EditorController);

  function EditorController(StoryService) {
    var vm = this;

    // TODO learn how to test
    vm.listStoriesMock = [
      {
        'key': 'ABC123', 'title': 'Mock: Tale of Two Cities', 'author': 'Charles Dickens',
        'tagline': 'It was the best of times; it was the worst of times.',
        'firstScene': {
          'key': '098ZYX', 'teaser': '19th century London',
          'prose': 'It was the best of times.  It was the worst of times.  Blah blah blah.',
          'nextSceneOptions': [
            {'key': '123SCENE', 'teaser': 'See what was so good about these times.'},
            {'key': '234SCENE', 'teaser': 'See what was so bad about these times.'}
          ]
        }
      },
      {
        'key': 'DEF456', 'title': 'Mock: The Raven', 'author': 'Edgar Allan Poe', 'tagline': 'Evermore.',
        'firstScene': {'key': '765WVU', 'teaser': 'Something about my love, Lenore...'}
      },
      {
        'key': 'GHI789', 'title': 'Mock: Star Wars', 'author': 'George Lucas',
        'tagline': 'Can our young hero overcome adversity and bring balance to the force?',
        'firstScene': {
          'key': 'QWERTY1', 'teaser': 'May the force be with you.',
          'prose': 'A long time ago in a galaxy far far away, the Rebel alliance was causing trouble for the Galactic Empire.',
          'nextSceneOptions': [
            {'key': 'QWERTY2', 'teaser': 'Use the force.'}
          ]
        }
      }
    ];

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
