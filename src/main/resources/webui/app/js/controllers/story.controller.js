(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('StoryController', StoryController);

    StoryController.$inject = ['$routeParams', 'StoryServer', 'StoryCache'];

    function StoryController($routeParams, StoryServer, StoryCache) {
        console.log('StoryController: called constructor');
        var vm = this;
        vm.currentStory = StoryCache.activeStory;
        vm.isTheEnd = isNoNextChapters;
        vm.requestedChapterId = $routeParams.chapter;
        vm.requestedStoryKey = $routeParams.storyKey;

        if (vm.requestedStoryKey != vm.currentStory.key) {
            getStory(vm.requestedStoryKey);
        } else {
            setCurrentChapter();
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
            StoryCache.activeStory = story.summary;
            indexChapters(story.chapters);
            setCurrentFromCache();
        }

    // TODO move some of this logic into StoryCache to simply and share with other controllers
    
        function indexChapters(chapters) {
            console.log('StoryController: called indexChapters');
            for (var i=0, max=chapters.length; i < max; i++) {
                console.log('StoryController: indexing chapter ' + chapters[i].id);
                StoryCache.activeChapters[chapters[i].id] = chapters[i];
            }
        }

        function setCurrentFromCache() {
            console.log('StoryController: called getCurrentFromCache');
            vm.currentStory = StoryCache.activeStory;
            setCurrentChapter();
        }

        function setCurrentChapter() {
            if (vm.requestedChapterId) {
                vm.currentChapter = StoryCache.activeChapters[vm.requestedChapterId];
            } else {
                vm.currentChapter = StoryCache.activeChapters[StoryCache.activeStory.firstChapter.targetChapterId];
            }
        }

        function isNoNextChapters() {
            console.log('StoryController: called isTheEnd');
            if (vm.currentChapter === undefined) {
                console.log('StoryController: called isNoNextChapters with current chapter undefined');
                return false;
            }
            return vm.currentChapter.nextChapterOptions === undefined
                    || vm.currentChapter.nextChapterOptions.length === 0;
        }

    }
})();
