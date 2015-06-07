(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('CatalogController', CatalogController);

    CatalogController.$inject = ['connectService', 'storyCache'];

    function CatalogController(connectService, storyCache) {

        var vm = this;
        vm.catalog = storyCache.summaries;

        if (!hasCachedSummaries()) {
            loadCatalog();
        }

        function hasCachedSummaries() {
            for (var property in vm.catalog) {
                if (vm.catalog.hasOwnProperty(property)) {
                    return true;
                }
            }
            return false;
        }

        function loadCatalog() {
            connectService.fetchAllStories().then(
                function (stories) {
                    applyRemoteData(stories);
                });
        }

        function applyRemoteData(stories) {
            storyCache.summaries = stories;
            vm.catalog = stories;
        }
    }

})();
