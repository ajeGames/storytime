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
            if (story == {} || story.key != storyKey) {
                loadStory(storyKey);
            }
            return story;
        }

        function loadStory(storyKey) {
            connectService.fetchStory(storyKey).then(
                function(storyIn) {
                    story = storyIn;
                    indexSubChapters(story.firstChapter);
                }
            };  // TODO deal with possible async problems
        }

        function indexSubChapters(chapter) {
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
