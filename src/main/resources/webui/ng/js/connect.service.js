/* connects with the backend API */

(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .factory('connectService', connectService);

    connectService.$inject = ['$http', '$q'];

    function connectService($http, $q) {
        return {
            deleteStory: deleteStory,
            fetchAllStories: fetchAllStories,
            fetchChapters: fetchChapters,
            fetchStory: fetchStory
        };

        // TODO change this to fetchStorySummaries with selection criteria; should return just story info, maybe first chapter
        function fetchAllStories() {
            var request = $http({
                method: "get",
                url: "../api/storytime/stories"
            });
            return (request.then(handleSuccess, handleError));
        }

        function fetchStory(key) {
            var goTo = "../api/adventure/" + key;
            var request = $http({
                method: "get",
                url: goTo
            });
            return (request.then(handleSuccess, handleError));
        }

        function fetchChapters(storyKey, chapterIds) {
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
