'use strict';

storyTimeApp
    .controller('CatalogCtrl', ['$scope', function($scope) {

        $scope.catalog = loadCatalog();

        function loadCatalog() {
          StoryService.fetchAllStories().then(
              function (stories) {
                applyRemoteData(stories);
              });
        }

        function applyRemoteData(stories) {
          $scope.catalog = stories;
        }

}]);
