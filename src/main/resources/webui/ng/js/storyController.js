(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'StoryService'];

        function StoryController($routeParams, StoryService) {
            var vm = this;
            vm.currentStory = {};
            vm.currentChapter = {};
            vm.storyKey = $routeParams.storyKey;
            vm.chapterId = $routeParams.chapterId;

            getStory($routeParams.key);

            function getStory(key) {
                StoryService.getStory(key).then(
                    function (story) {
                        applyRemoteData(story);
                    });
            }

            function applyRemoteData(story) {
                vm.currentStory = story;
                vm.currentChapter = story.firstChapter;
            }

            function getChapter(chapterId) {
                StoryService.getChapter(vm.currentStory.key, chapterId);
            }
        }

})();
