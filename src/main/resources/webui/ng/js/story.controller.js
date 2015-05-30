(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'storyService'];

        function StoryController($routeParams, storyService) {
            var vm = this;
            vm.currentStory = {};
            vm.currentChapter = {};

            getStory($routeParams.key);

            function getStory(key) {
                storyService.getStory(key).then(
                    function (story) {
                        applyRemoteData(story);
                    });
            }

            function applyRemoteData(story) {
                vm.currentStory = story;
                vm.currentChapter = story.firstChapter;
            }

            function getChapter(chapterId) {
                storyService.getChapter(chapterId);
            }
        }

})();
