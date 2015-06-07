(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .config(config);

    function config($routeProvider) {
        $routeProvider
            .when('/catalog', {
                templateUrl: 'catalog.html',
                controller: 'CatalogController',
                controllerAs: 'vm'
            })
            .when('/reader/:storyKey', {
                templateUrl: 'reader.html',
                controller: 'StoryController',
                controllerAs: 'vm'
            })
            .when('/reader/:storyKey/:chapter', {
                templateUrl: 'reader.html',
                controller: 'StoryController',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/catalog'
            });
    }
})();
