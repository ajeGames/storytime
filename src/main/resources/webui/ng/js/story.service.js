(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .factory('storyService', storyService);

    storyService.$inject = ['connectService'];

    function storyService(connectService) {
        var chapters = {};
        var story = {};
        return {
            getChapter: getChapter,
            getStory: getStory
        };

        function getStory(storyKey) {
            if (storyKey != story.key) {
                loadStory(storyKey);
            }
            return story;
        }

        function loadStory(storyKey) {
            // TODO implement
            // connectService.fetchStory(storyKey).then()...
        }

        function indexSubChapters(chapter) {
            // TODO implement
        }

        function getChapter(chapterId) {
            // TODO implement
        }
    }

})();
