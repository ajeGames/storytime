(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('CatalogController', CatalogController);

    CatalogController.$inject = ['StoryService'];

    function CatalogController(StoryService) {

        var vm = this;
        vm.catalog = loadCatalog();

        function loadCatalog() {
            StoryService.fetchAllStories().then(
                function (stories) {
                    applyRemoteData(stories);
                });
        }

        function applyRemoteData(stories) {
            vm.catalog = stories;
        }
    }

})();
