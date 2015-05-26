(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'StoryService'];

        function StoryController($routeParams, StoryService) {
            var vm = this;
            vm.storyKey = $routeParams.key;
            vm.currentStory = StoryService.getStory($routeParams.key);
            vm.currentChapter = vm.currentStory.firstChapter;
        }

})();
