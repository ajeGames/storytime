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
            loadStory(storyKey);
            return story;
        }

        function loadStory(storyKey) {
            story = connectService.fetchStory(storyKey);
            indexChapters(story.firstChapter);
        }

        function indexChapters(chapter) {
            if (chapter != null && chapter.id != null) {
                chapters[chapter.id] = chapter;
                for (var i=0, tot=chapters.nextChapterOptions.length; i < tot; i++) {
                    indexSubChapters(chapters.nextChapterOptions[i]);
                }
            }
        }

        function getChapter(chapterId) {
            return chapters[chapterId];
        }
    }

})();
