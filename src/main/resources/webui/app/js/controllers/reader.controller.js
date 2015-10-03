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
        vm.storySummary = StoryContext.getActiveStorySummary();

        activate();

        function activate() {
            if (vm.paramStoryKey != vm.storySummary.key) {
                loadStory().then(function() {
                    console.log('loaded story: ' + vm.storySummary.key);
                    setActiveChapter();
                });
            } else {
                setActiveChapter();
            }
        }

        function loadStory() {
            console.log('ReaderController: loadStory');
            return RemoteData.fetchStory(vm.paramStoryKey)
                .then(function(story) {
                    StoryContext.cacheStory(story);
                    vm.storySummary = StoryContext.getActiveStorySummary();
                });
        }

        function setActiveChapter() {
            console.log('ReaderController: setActiveChapter');
            var idToLoad = vm.paramChapterId;
            if (idToLoad === undefined || idToLoad === "0") {
                idToLoad = vm.storySummary.firstChapter.targetChapterId;
            }
            console.log('showing chapter ' + idToLoad);
            vm.activeChapter = StoryContext.getChapter(idToLoad);
        }

        function isEndNode() {
            console.log('ReaderController: isEndNode');
            if (vm.activeChapter === undefined) {
                console.log('ReaderController: called isNoNextChapters with current chapter undefined');
                return false;
            }
            return vm.activeChapter.nextChapterOptions === undefined
                    || vm.activeChapter.nextChapterOptions.length === 0;
        }

    }
})();
