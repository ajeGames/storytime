/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .factory('storyService', storyService);

    storyService.$inject = ['connectService'];

    function storyService(connectService) {
        return {
            getChapter: getChapter,
            getStory: getStory
        };

        var chapters = {};
        var story = {};

        function getStory(storyKey) {
            if (storyKey != story.key) {
                loadStory(storyKey);
            }
            return story;
        }

        function loadStory(storyKey) {
            connectService.fetchStory(storyKey).then(
                function(storyIn) {
                    story = storyIn;
                }
            };  // TODO deal with possible async problems
        }

        function indexSubChapters(chapter) {
            // TODO implement
        }

        function getChapter(chapterId) {
            // TODO implement
        }
    }

})();
