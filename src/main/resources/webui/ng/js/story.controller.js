(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'storyService', 'connectService'];

        function StoryController($routeParams, storyService, connectService) {
            var vm = this;
            vm.currentStory = {};
            vm.currentChapter = {};
            vm.chapters = {};

            getStory($routeParams.key);

            function getStory(key) {
                connectService.fetchStory(key).then(
                    function (story) {
                        applyRemoteData(story);
                    });
            }

            function applyRemoteData(story) {
                vm.currentStory = story;
                vm.currentChapter = story.firstChapter;
                indexChapters(story.firstChapter);
            }

            function indexChapters(chapter) {
                if (chapter != null && chapter.id != null) {
                    vm.chapters[chapter.id] = chapter;
                    for (var i=0, tot=chapter.nextChapterOptions.length; i < tot; i++) {
                        indexChapters(chapter.nextChapterOptions[i]);
                    }
                }
            }

            function loadChapter(chapterId) {
                vm.currentChapter = chapters[chapterId];
            }
        }

})();
