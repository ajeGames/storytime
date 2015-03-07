/**
 * Created by dmount on 2/13/15.
 */

(function() {
  var app = angular.module('storytime', []);

  app.controller('StoryController', function($scope, storyService) {
    $scope.story = {};

    $scope.addStory = function() {
      // call server

      $http.post('story').then(function(response) {
        console.log(response.data);
      });

      // update local story with whatever is returned

      // change edit mode on page

    };

  });

  app.service('storyService',
      function($http, $q) {

        // public API
        return ({
          addStory: addStory,
          getStory: getStory
        });

        function addStory(story) {

          var request = $http({
            method: "post",
            url: "/storytime/story",
            data: {
              name: updated_story
            }
          });
          return (request.then (handleSuccess, handleError));
        }
      }
  );


})();

