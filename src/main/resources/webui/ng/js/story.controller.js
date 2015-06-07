(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'connectService', 'storyCache'];

        function StoryController($routeParams, connectService, storyCache) {
            var vm = this;
            //vm.storyCache = storyCache;
            vm.requestedStoryKey = $routeParams.storyKey;
            vm.requestedChapterId = $routeParams.chapter;
            vm.currentStory = storyCache.activeStory;
            vm.currentChapter = storyCache.activeChapters[vm.requestedChapterId];

            if (vm.requestedStoryKey != vm.currentStory.key) {
                getStory(vm.requestedStoryKey);
            }

            function getStory(key) {
                connectService.fetchStory(key).then(
                    function (story) {
                        applyRemoteData(story);
                    });
            }

            function applyRemoteData(story) {
                storyCache.activeStory = story;
                indexChapters(story.firstChapter);
                getCurrentFromCache();
            }

            function indexChapters(chapter) {
                if (chapter != null && chapter.id != null) {
                    storyCache.activeChapters[chapter.id] = chapter;
                    for (var i=0, tot=chapter.nextChapterOptions.length; i < tot; i++) {
                        indexChapters(chapter.nextChapterOptions[i]);
                    }
                }
            }

            function getCurrentFromCache() {
                vm.currentStory = storyCache.activeStory;
                if (vm.requestedChapterId) {
                    vm.currentChapter = storyCache.activeChapters[vm.requestedChapterId];
                } else {
                    vm.currentChapter = storyCache.activeChapters[1];
                }
            }
        }

})();
