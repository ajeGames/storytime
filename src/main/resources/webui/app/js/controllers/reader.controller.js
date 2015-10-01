(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('ReaderController', ReaderController);

    ReaderController.$inject = ['$routeParams', 'Backend', 'StoryCache'];

    function ReaderController($routeParams, Backend, StoryCache) {
        console.log('ReaderController: called constructor');
        var vm = this;
        vm.currentStory = StoryCache.getStory();
        vm.isTheEnd = isEndNode;
        vm.requestedChapterId = $routeParams.chapter;
        vm.requestedStoryKey = $routeParams.storyKey;

        if (vm.requestedStoryKey != vm.currentStory.key) {
            getStory(vm.requestedStoryKey);
        } else {
            setCurrentChapter();
        }

        function getStory(key) {
            console.log('ReaderController: called getStory');
            Backend.fetchStory(key).then(
                function (story) {
                    applyRemoteData(story);
                });
        }

        function applyRemoteData(story) {
            console.log('ReaderController: called applyRemoteData');
            StoryCache.cacheStory(story);
            vm.currentStory = StoryCache.getStory();
            setCurrentChapter();
        }

        function setCurrentChapter() {
            if (vm.requestedChapterId) {
                vm.currentChapter = StoryCache.getChapter(vm.requestedChapterId);
            } else {
                vm.currentChapter = StoryCache.getChapter(currentStory.firstChapter.targetChapterId);
            }
        }

        function isEndNode() {
            console.log('ReaderController: called isTheEnd');
            if (vm.currentChapter === undefined) {
                console.log('ReaderController: called isNoNextChapters with current chapter undefined');
                return false;
            }
            return vm.currentChapter.nextChapterOptions === undefined
                    || vm.currentChapter.nextChapterOptions.length === 0;
        }

    }
})();
