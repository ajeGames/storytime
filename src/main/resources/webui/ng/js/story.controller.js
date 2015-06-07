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
            vm.requestedChapter = $routeParams.chapter;

            if ($routeParams.storyKey != vm.currentStory.key) {
                getStory($routeParams.storyKey);
            }

            function getStory(key) {
                connectService.fetchStory(key).then(
                    function (story) {
                        applyRemoteData(story);
                    });
            }

            function applyRemoteData(story, chapter) {
                vm.currentStory = story;
                indexChapters(story.firstChapter);
                if (vm.requestedChapter) {
                    vm.currentChapter = vm.chapters[vm.requestedChapter];
                } else {
                    vm.currentChapter = vm.chapters[1];
                }
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
                vm.currentChapter = vm.chapters[chapterId];
            }
        }

})();
