/**
 * Javascript for handling story authoring UI.
 */

var app = angular.module('storytime', []);

app.controller('StoryCtrl', ['$scope', 'StoryService', function ($scope, StoryService) {

  // TODO learn how to test

  // === Story summary edit logic ===

//  $scope.catalog = StoryService.listStoriesMock();
  $scope.catalog = StoryService.listStories();
  $scope.draft = {};
  $scope.isEdit = true;

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

