
var storyTimeApp = angular.module('storyTimeApp', []);

storyTimeApp.config(['$routeProvider',
    function($routeProvider) {
      $routeProvider
        .when('/catalog', {
          templateUrl: 'catalog.html',
          controller: 'CatalogCtrl'
        })
        .when('/reader/:key', {
            templateUrl: 'reader.html',
            controller: 'StoryCtrl'
        })
        .otherwise({
          redirectTo: '/catalog'
        });
    }]);
