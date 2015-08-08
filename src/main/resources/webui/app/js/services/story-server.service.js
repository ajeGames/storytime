/* connects with the backend API */

(function () {
    'use strict';

    angular
        .module('StoryTime')
        .factory('StoryServer', StoryServerAccessFactory);

    StoryServerAccessFactory.$inject = ['$http', '$q'];

    function StoryServerAccessFactory($http, $q) {
        return {
            createStory: createStory,
            deleteStory: deleteStory,
            fetchAllStories: fetchAllStories,
            fetchChapters: fetchChapters,
            fetchStory: fetchStory,
            updateStory: updateStory
        };

        function fetchAllStories() {
            var request = $http({
                method: "get",
                url: "../api/storytime/stories"
            });
            return (request.then(handleSuccess, handleError));
        }

        function fetchStory(key) {
            return $http.get("../api/story/" + key)
                .then(handleSuccess).catch(handleError);
        }

        function fetchChapters(storyKey, chapterIds) {
            var goTo = "../api/story/" + storyKey;
            var request = $http({
                method: "get",
                url: goTo
            });
            return request.then(handleSuccess).catch(handleError);
        }

        function createStory(story) {
            var request = $http({
                method: "post",
                url: "../api/story",
                data: story
            });
            return request.then(handleSuccess).catch(handleError);
        }

        function updateStory(story) {
            var goTo = "../api/story/" + story.key;
            var request = $http({
                method: "put",
                url: goTo,
                data: story
            });
            return request.then(handleSuccess).catch(handleError);
        }

        function deleteStory(key) {
            var request = $http({
                method: "delete",
                url: "../api/story/{key}"
            });
        }

        // "PRIVATE" FUNCTIONS

        function handleSuccess(response) {
            return response.data;
        }

        function handleError(response) {

            console.log('Problem with call to server: ' + error.data);

            // handle unexpected format
            if (!angular.isObject(response.data) || !response.data.message) {
            return $q.reject("An unknown error occurred.");
            }

            // Otherwise, use expected error message.
            return $q.reject(response.data.message);
        }
    }

})();
