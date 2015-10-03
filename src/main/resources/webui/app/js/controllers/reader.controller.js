(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('ReaderController', ReaderController);

    ReaderController.$inject = ['$routeParams', 'RemoteData', 'StoryContext'];

    function ReaderController($routeParams, RemoteData, StoryContext) {
        console.log('ReaderController: called constructor');
        var vm = this;
        vm.activeChapter = {};
        vm.isTheEnd = isEndNode;
        vm.paramChapterId = $routeParams.chapterId;
        vm.paramStoryKey = $routeParams.storyKey;
        vm.storySummary = {};

        activate();

        function activate() {
            if (vm.paramStoryKey != vm.currentStory.key) {
                loadStory().then(function() {
                    console.log('loaded story: ' + vm.storySummary.key);
                    setActiveChapter();
                });
            }
            setActiveChapter();
        }

        function loadStory() {
            console.log('ReaderController: called getStory');
            return RemoteData.fetchStory(vm.paramStoryKey)
                .then(function (story) {
                    StoryContext.cacheStory(story);
                    vm.storySummary = StoryContext.getActiveStorySummary();
                });
        }

        function setActiveChapter() {
            var idToLoad = vm.paramChapterId;
            if (idToLoad === undefined || idToLoad === 0) {
                idToLoad = currentStory.firstChapter.targetChapterId;
            }
            console.log('showing chapter ' + idToLoad);
            vm.activeChapter = StoryContext.getChapter(idToLoad);
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
