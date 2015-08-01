(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('StoryController', StoryController);

    StoryController.$inject = ['$routeParams', 'StoryServer', 'StoryCache'];

    function StoryController($routeParams, StoryServer, StoryCache) {
        console.log('StoryController: called constructor');
        var vm = this;
        //vm.StoryCache = StoryCache;
        vm.requestedStoryKey = $routeParams.storyKey;
        vm.requestedChapterId = $routeParams.chapter;
        vm.currentStory = StoryCache.activeStory;
        vm.currentChapter = StoryCache.activeChapters[vm.requestedChapterId];

        if (vm.requestedStoryKey != vm.currentStory.key) {
            getStory(vm.requestedStoryKey);
        }

        vm.isTheEnd = function() {
            console.log('StoryController: called isTheEnd');
            return vm.currentChapter.nextChapterOptions === undefined
                    || vm.currentChapter.nextChapterOptions.length === 0;
        }

        function getStory(key) {
            console.log('StoryController: called getStory');
            StoryServer.fetchStory(key).then(
                function (story) {
                    applyRemoteData(story);
                });
        }

        function applyRemoteData(story) {
            console.log('StoryController: called applyRemoteData');
            StoryCache.activeStory = story;
            indexChapters(story.firstChapter);
            getCurrentFromCache();
        }

        function indexChapters(chapter) {
            console.log('StoryController: called indexChapters');
            if (chapter != null && chapter.id != null) {
                StoryCache.activeChapters[chapter.id] = chapter;
                for (var i=0, tot=chapter.nextChapterOptions.length; i < tot; i++) {
                    indexChapters(chapter.nextChapterOptions[i]);
                }
            }
        }

        function getCurrentFromCache() {
            console.log('StoryController: called getCurrentFromCache');
            vm.currentStory = StoryCache.activeStory;
            if (vm.requestedChapterId) {
                vm.currentChapter = StoryCache.activeChapters[vm.requestedChapterId];
            } else {
                vm.currentChapter = StoryCache.activeChapters[1];
            }
        }
    }
})();
