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
            activeStory: {},
            chapters: {}
        };

        function getChapter(storyKey, chapterId) {
            if (storyKey != activeStory.key) {
                loadStory(storyKey);
            }
            return vm.chapters[chapterId];
        }

        function loadStory(storyKey) {
            connectService.fetchStory(storyKey).then(
                function (story) {
                    applyRemoteData(story);
                });
        }

        function applyRemoteData(story) {
            vm.activeStory = story;
            indexChapters(vm.activeStory.firstChapter);
        }

        function indexChapters(chapter) {
            if (chapter != null && chapter.id != null) {
                vm.chapters[chapter.id] = chapter;
                for (var i=0, tot=chapter.nextChapterOptions.length; i < tot; i++) {
                    indexChapters(chapter.nextChapterOptions[i]);
                }
            }
        }

    }

})();
