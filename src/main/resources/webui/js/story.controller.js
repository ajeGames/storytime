(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('StoryController', StoryController);

    StoryController.$inject = ['$routeParams', 'connectService', 'storyCache'];

    function StoryController($routeParams, connectService, storyCache) {
        console.log('StoryController: called constructor');
        var vm = this;
        //vm.storyCache = storyCache;
        vm.requestedStoryKey = $routeParams.storyKey;
        vm.requestedChapterId = $routeParams.chapter;
        vm.currentStory = storyCache.activeStory;
        vm.currentChapter = storyCache.activeChapters[vm.requestedChapterId];

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
            connectService.fetchStory(key).then(
                function (story) {
                    applyRemoteData(story);
                });
        }

        function applyRemoteData(story) {
            console.log('StoryController: called applyRemoteData');
            storyCache.activeStory = story;
            indexChapters(story.firstChapter);
            getCurrentFromCache();
        }

        function indexChapters(chapter) {
            console.log('StoryController: called indexChapters');
            if (chapter != null && chapter.id != null) {
                storyCache.activeChapters[chapter.id] = chapter;
                for (var i=0, tot=chapter.nextChapterOptions.length; i < tot; i++) {
                    indexChapters(chapter.nextChapterOptions[i]);
                }
            }
        }

        function getCurrentFromCache() {
            console.log('StoryController: called getCurrentFromCache');
            vm.currentStory = storyCache.activeStory;
            if (vm.requestedChapterId) {
                vm.currentChapter = storyCache.activeChapters[vm.requestedChapterId];
            } else {
                vm.currentChapter = storyCache.activeChapters[1];
            }
        }
    }
})();
