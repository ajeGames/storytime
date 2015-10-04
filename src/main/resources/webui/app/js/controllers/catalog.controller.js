(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('CatalogController', CatalogController);

    CatalogController.$inject = ['RemoteData', 'StoryContext'];

    function CatalogController(RemoteData, StoryContext) {

        var vm = this;
        vm.catalog = StoryContext.getSummaries();

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
            RemoteData.fetchAllSummaries()
                .then(function(stories) {
                    StoryContext.cacheSummaries(stories);
                    vm.catalog = stories;
                });
        }
    }

})();
