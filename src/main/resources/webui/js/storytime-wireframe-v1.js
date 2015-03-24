/**
 * Javascript for handling story authoring UI.
 */

var app = angular.module('storytime', []);

app.controller('StoryCtrl', ['$scope', 'StoryService', function ($scope, StoryService) {

  // TODO learn how to test
  $scope.listStoriesMock = [
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

//  $scope.catalog = listStoriesMock;
  $scope.catalog = [];
  $scope.draft = {};
  $scope.isEdit = true;

  function applyRemoteData(stories) {
    $scope.catalog = stories;
  }

  function loadCatalog () {

    // The friendService returns a promise.
    StoryService.refreshStories()
        .then(function( stories ) {
          applyRemoteData( stories );
        });
  }

  $scope.loadCatalog();

  $scope.save = function () {
    if ($scope.draft.key == null) {
      $scope.draft.key = Date.now();  // TODO backend will do this when hooked up
      $scope.catalog.push($scope.draft);  // new story, so add to list
    } else {
      for (i in $scope.catalog) {
        if ($scope.catalog[i].key == $scope.draft.key) {
          $scope.catalog[i] = $scope.draft;
        }
      }
    }
    $scope.isEdit = false;
  };

  $scope.edit = function (key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.draft = angular.copy($scope.catalog[i]);
        break;
      }
    }
    $scope.isEdit = true;
  };

  $scope.load = function (key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.draft = $scope.catalog[i];
        $scope.draftScene = $scope.draft.firstScene;
        if ($scope.draftScene.nextSceneOptions == null) {
          $scope.draftScene.nextSceneOptions = [];
        }
        break;
      }
    }
    $scope.isEdit = false;
  };

  $scope.clear = function () {
    $scope.draft = {};
    $scope.isEdit = true;
  };

  $scope.delete = function (key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.catalog.splice(i, 1);
        $scope.draft = {};
        break;
      }
    }
  };

  $scope.updateScene = function () {
    if ($scope.draftScene.key == null) {
      $scope.draftScene.key = Date.now();  // TODO backend will do this when hooked up
      $scope.draftScene.nextSceneOptions = [];
    }
  };

  // === Scene edit logic ===

  $scope.draftScene = {};

  $scope.nextSceneTeaser = null;

  $scope.addSceneOption = function () {
    if ($scope.nextSceneTeaser != null) {
      var sceneOption = {'key': Date.now(), 'teaser': $scope.nextSceneTeaser};
      $scope.draftScene.nextSceneOptions.push(sceneOption);
      $scope.nextSceneTeaser = null;
    }
  };

  $scope.removeSceneOption = function (key) {
    for (i in $scope.draftScene.nextSceneOptions) {
      if ($scope.draftScene.nextSceneOptions[i].key == key) {
        $scope.draftScene.nextSceneOptions.splice(i, 1);
        break;
      }
    }
  };
}]);

