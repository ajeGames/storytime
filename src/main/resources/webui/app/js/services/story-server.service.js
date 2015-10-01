/* connects with the backend API */

(function () {
    'use strict';

    angular
        .module('StoryTime')
        .factory('Backend', BackendAccessFactory);

    BackendAccessFactory.$inject = ['$http', '$q'];

    function BackendAccessFactory($http, $q) {
        return {
            createChapter: createChapter,
            createStory: createStory,
            deleteChapter: deleteChapter,
            deleteStory: deleteStory,
            fetchAllStories: fetchAllStories,
            fetchChapter: fetchChapter,
            fetchStory: fetchStory,
            updateStory: updateStory,
            updateChapter: updateChapter
        };

        function fetchAllStories() {
            var request = $http({
                method: "get",
                url: "../api/storytime/stories"
            });
            return (request.then(handleSuccess, handleError));
        }

        function fetchStorySummary(key) {
            return $http.get("../api/story/" + key)
                .then(handleSuccess).catch(handleError);
        }

        function fetchStory(key) {
            return $http.get("../api/story/" + key + "/full")
                .then(handleSuccess).catch(handleError);
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
            var goTo = "../api/story/" + key;
            var request = $http({
                method: "delete",
                url: goTo
            });
        }

        // chapter functions

        function fetchChapter(storyKey, id) {
            return $http.get("../api/story/" + key + "/chapter/" + id)
                .then(handleSuccess).catch(handleError);
        }

        function updateChapter(storyKey, chapter) {
            var goTo = "../api/story/" + storyKey + "/chapter/" + chapter.id;
            var request = $http({
                method: "put",
                url: goTo,
                data: chapter
            });
            return request.then(handleSuccess).catch(handleError);
        }

        function createChapter(storyKey, fromChapterId, teaser) {
            var goTo = "../api/story/" + storyKey + "/chapter/" + fromChapterId;
            var request = $http({
                method: "post",
                url: goTo,
                data: teaser
            });
            return request.then(handleSuccess).catch(handleError);
        }

        function deleteChapter(storyKey, chapterId) {
            var goTo = "../api/story/" + storyKey + "/chapter/" + chapterId;
            var request = $http({
                method: "delete",
                url: goTo
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
