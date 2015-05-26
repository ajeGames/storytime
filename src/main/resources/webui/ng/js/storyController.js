'use strict';

storyTimeApp
    .controller('StoryCtrl', ['$scope', '$routeParams', function($scope, $routeParams) {

        $scope.currentStory = StoryService.getStory($routeParams.key);
        $scope.currentChapter = currentStory.firstChapter;

}]);
