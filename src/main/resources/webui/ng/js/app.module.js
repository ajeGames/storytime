(function() {
  'use strict';

  angular
      .module('StoryTime', [])
      .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/reader/:key', {
                controller: 'CatalogController',
                templateUrl: ''
            })
      }

})();
