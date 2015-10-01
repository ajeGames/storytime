(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('CatalogController', CatalogController);

    CatalogController.$inject = ['Backend', 'StoryCache'];

    function CatalogController(Backend, StoryCache) {

        var vm = this;
        vm.catalog = StoryCache.getSummaries();

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
            Backend.fetchAllStories().then(
                function (stories) {
                    applyRemoteData(stories);
                });
        }

        function applyRemoteData(stories) {
            StoryCache.cacheSummaries(stories);
            vm.catalog = stories;
        }
    }

})();
