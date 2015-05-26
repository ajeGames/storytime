(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'StoryService'];

        function StoryController($routeParams, StoryService) {
            vm = this;
            vm.currentStory = StoryService.getStory($routeParams.key);
            vm.currentChapter = vm.currentStory.firstChapter;
        }

})();
