(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('StoryController', StoryController);

        StoryController.$inject = ['$routeParams', 'StoryService'];

        function StoryController($routeParams, StoryService) {
            $scope.currentStory = StoryService.getStory($routeParams.key);
            $scope.currentChapter = currentStory.firstChapter;
        }

})();
