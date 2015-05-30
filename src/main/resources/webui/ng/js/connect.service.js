/* connects with the backend API */

(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .service('ConnectService', ConnectService);

    function ConnectService($http, $q) {
        return ({
            fetchAllStories: fetchAllStories,
            getStory: getStory,
            getChapters: getChapters,
            deleteStory: deleteStory
        });

        function fetchAllStories() {
            var request = $http({
                method: "get",
                url: "../api/storytime/stories"
            });
            return (request.then(handleSuccess, handleError));
        }

        function getStory(key) {
            var goTo = "../api/adventure/" + key;
            var request = $http({
                method: "get",
                url: goTo
            });
            return (request.then(handleSuccess, handleError));
        }

        function getChapters(storyKey, chapterIds) {
            var goTo = "../api/adventure/" + storyKey;
            var request = $http({
                method: "get",
                url: goTo
            });
            return (request.then(handleSuccess, handleError));
        }

        function deleteStory(key) {
            var request = $http({
                method: "delete",
                url: "../api/adventure/{key}"
            });
        }

    // "PRIVATE" FUNCTIONS

    function handleSuccess(response) {
        return ( response.data );
    }

    function handleError(response) {

        // handle unexpected format
        if (!angular.isObject(response.data) || !response.data.message) {
        return ( $q.reject("An unknown error occurred.") );
        }

        // Otherwise, use expected error message.
        return ( $q.reject(response.data.message) );
    }
}

})();
