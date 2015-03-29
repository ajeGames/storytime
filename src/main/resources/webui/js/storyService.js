(function () {
  'use strict';

  angular
      .module('StoryTime')
      .service('StoryService', StoryService);

  function StoryService($http, $q) {
    return ({
      fetchAllStories: fetchAllStories
    });

    function fetchAllStories() {
      var request = $http({
        method: "get",
        url: "api/storytime/stories"
      });
      return (request.then(handleSuccess, handleError));
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
