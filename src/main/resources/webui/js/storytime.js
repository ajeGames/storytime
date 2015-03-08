/**
 * Created by dmount on 2/13/15.
 */

var app = angular.module('storytime', []);

app.controller('StoryCtrl', ['$scope', function($scope){

  $scope.catalog = [
    {
      'key': 'ABC123', 'title': 'Tale of Two Cities', 'author': 'Charles Dickens',
      'tagline': 'It was the best of times; it was the worst of times.',
      'firstScene': {'key': '098ZYX', 'teaser': '19th century London',
                     'prose': 'It was the best of times.  It was the worst of times.  Blah blah blah.',
                     'nextSceneOptions': [
                        { 'key': '123SCENE', 'teaser': 'See what was so good about these times.' },
                        { 'key': '234SCENE', 'teaser': 'See what was so bad about these times.' }
                     ]
                    }
    },
    {
      'key': 'DEF456', 'title': 'The Raven', 'author': 'Edgar Allan Poe', 'tagline': 'Evermore.',
      'firstScene': {'key': '765WVU', 'teaser': 'Something about my love, Lenore...'}
    }
  ];

  $scope.draft = {};
  $scope.isEdit = true;

  $scope.save = function() {
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

  $scope.edit = function(key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.draft = angular.copy($scope.catalog[i]);
        break;
      }
    }
    $scope.isEdit = true;
  };

  $scope.load = function(key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.draft = $scope.catalog[i];
        $scope.draftScene = $scope.draft.firstScene;
        break;
      }
    }
    $scope.isEdit = false;
  };

  $scope.clear = function() {
    $scope.draft = {};
    $scope.isEdit = true;
  };

  $scope.delete = function(key) {
    for (i in $scope.catalog) {
      if ($scope.catalog[i].key == key) {
        $scope.catalog.splice(i,1);
        $scope.draft = {};
      }
    }
  };

  $scope.updateScene = function() {
    if ($scope.draftScene.key == null) {
      $scope.draftScene.key = Date.now();  // TODO backend will do this when hooked up
    }
  };

  /// Scene edit logic

  $scope.draftScene = {};

  $scope.testScene = {
    'key': 'QWERTY1', 'teaser': 'Once upon a time...',
    'prose': 'A long time ago in a galaxy far far away, there lived three little pigs.',
    'nextSceneOptions': [
      { 'key': 'QWERTY2', 'teaser': 'Use the force.' },
      { 'key': 'QWERTY3', 'teaser': 'Turn to the dark side.' }
    ]
  };

  $scope.nextSceneTeaser = null;

  $scope.addSceneOption = function() {
    if ($scope.nextSceneTeaser != null) {
      var sceneOption = { 'key': Date.now(), 'teaser': $scope.nextSceneTeaser };
      $scope.draftScene.nextSceneOptions.push(sceneOption);
      $scope.nextSceneTeaser = null;
    }
  };

}]);

  //app.service('storyService',
  //  function($http, $q) {
  //
  //    // public API
  //    return ({
  //      addStory: addStory
  //    });
  //
  //    function addStory(story) {
  //      var request = $http({
  //        method: "post",
  //        url: "/api/storytime/story",
  //        data: {
  //          story: story
  //        }
  //      });
  //      return (request.then(handleSuccess, handleError));
  //    }
  //
  //    function handleSuccess(response) {
  //      return(response.data);
  //    }
  //
  //    function handleError(response) {
  //      if (!angular.isObject( response.data ) || !response.data.message) {
  //        return($q.reject("An unknown error occurred."));
  //      }
  //      return($q.reject(response.data.message));
  //    }
  //
  //  }
  //);

