(function() {
    'use strict';

    angular
        .module('storyTimeApp')
        .controller('CatalogController', CatalogController);

    CatalogController.$inject = ['connectService'];

    function CatalogController(connectService) {

        var vm = this;
        vm.catalog = {};
        loadCatalog();

        function loadCatalog() {
            connectService.fetchAllStories().then(
                function (stories) {
                    applyRemoteData(stories);
                });
        }

        function applyRemoteData(stories) {
            vm.catalog = stories;
        }
    }

})();
