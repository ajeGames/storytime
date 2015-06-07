(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .config(config);

    function config($routeProvider) {
        $routeProvider
            .when('/catalog', {
                templateUrl: 'template/catalog.html',
                controller: 'CatalogController',
                controllerAs: 'vm'
            })
            .when('/reader/:storyKey/:chapter', {
                templateUrl: 'template/reader.html',
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
