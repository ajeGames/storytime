(function() {
    'use strict';

    angular
        .module('StoryTime')
        .config(config);

    function config($routeProvider) {
        $routeProvider
            .when('/catalog', {
                templateUrl: 'templates/pages/catalog/index.html',
                controller: 'CatalogController',
                controllerAs: 'vm'
            })
            .when('/reader/:storyKey/:chapter', {
                templateUrl: 'templates/pages/reader/index.html',
                controller: 'StoryController',
                controllerAs: 'vm'
            })
            .when('/reader/:storyKey', {
                redirectTo: '/reader/:storyKey/1'
            })
            .otherwise({
                redirectTo: '/catalog'
            });
    }
})();
