(function () {
  'use strict';

  angular
      .module('storyTimeApp')
      .service('StoryService', StoryService);

  function StoryService($http, $q) {
    return ({
      fetchAllStories: fetchAllStories,
      getStory: getStory
    });

    function fetchAllStories() {
      var request = $http({
        method: "get",
        url: "../api/storytime/stories"
      });
      return (request.then(handleSuccess, handleError));
    }

    function getStory(key) {
      var request = $http({
        method: "get",
        url: "../api/adventure/{key}"
      });
      return (request.then(handleSuccess, handleError));
    }

    function deleteStory(key) {
      var request = $http({
        method: "delete",
        url: "../api/adventure/{key}"
      });
    }

    /// "PRIVATE" FUNCTIONS

    // unwrap application data
    function handleError(response) {

      // handle unexpected format
      if (!angular.isObject(response.data) || !response.data.message) {
        return ( $q.reject("An unknown error occurred.") );
      }

      // Otherwise, use expected error message.
      return ( $q.reject(response.data.message) );
    }

    // unwrap application data
    function handleSuccess(response) {
      return ( response.data );
    }
  }

})();
